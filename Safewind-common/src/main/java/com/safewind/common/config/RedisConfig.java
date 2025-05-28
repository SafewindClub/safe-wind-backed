package com.safewind.common.config;

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @Author: Darven
 * @CreateTime: 2025-05-24  00:08
 * @Description: redis配置类
 */
@Configuration // 表明这个类是一个配置类，Spring会自动扫描并处理这个类中的配置信息
@EnableCaching // 启用Spring的缓存功能，使得可以在应用中方便地使用缓存
public class RedisConfig extends CachingConfigurerSupport {
    // 定义一个名为redisTemplate的Bean，用于创建RedisTemplate实例，这个实例用于在Spring应用中与Redis进行交互
    @Bean
    @SuppressWarnings(value = { "unchecked", "rawtypes" }) // 抑制特定的警告，这里是对未经检查的类型转换和原始类型使用的警告
    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<Object, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);
        //序列化
        FastJson2JsonRedisSerializer serializer = new FastJson2JsonRedisSerializer(Object.class);

        // 使用StringRedisSerializer来序列化和反序列化redis的key值，这样在Redis中存储的键是字符串形式
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(serializer);

        // Hash的key也采用StringRedisSerializer的序列化方式，当在Redis中存储Hash数据结构时，键的序列化方式为字符串形式
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setHashValueSerializer(serializer);

        template.afterPropertiesSet(); // 初始化RedisTemplate的属性，例如设置默认的序列化器等
        return template;
    }

    // 定义一个名为limitScript的Bean，用于创建DefaultRedisScript实例，这个脚本用于限流相关的功能
    @Bean
    public DefaultRedisScript<Long> limitScript() {
        DefaultRedisScript<Long> redisScript = new DefaultRedisScript<>();
        redisScript.setScriptText(limitScriptText());
        redisScript.setResultType(Long.class); // 设置脚本执行结果的类型为Long
        return redisScript;
    }

    /**
     * 限流脚本
     */
    private String limitScriptText() {
        return "local key = KEYS[1]\n" +
                "local count = tonumber(ARGV[1])\n" +
                "local time = tonumber(ARGV[2])\n" +
                "local current = redis.call('get', key);\n" +
                "if current and tonumber(current) > count then\n" +
                "    return tonumber(current);\n" +
                "end\n" +
                "current = redis.call('incr', key)\n" +
                "if tonumber(current) == 1 then\n" +
                "    redis.call('expire', key, time)\n" +
                "end\n" +
                "return tonumber(current);";
        // 限流脚本解释：
        // 1. 获取传入的键（KEYS[1]），从参数中获取限制数量（count）和时间（time）。
        // 2. 通过'redis.call('get', key)'获取当前键对应的值（current），如果current存在且大于限制数量，则直接返回current。
        // 3. 如果不满足上述条件，对键的值进行自增操作（'incr', key），如果自增后的值为1，说明是首次访问，设置键的过期时间为指定的时间（'expire', key, time）。
        // 4. 最后返回当前键的值（current）。
    }
}
