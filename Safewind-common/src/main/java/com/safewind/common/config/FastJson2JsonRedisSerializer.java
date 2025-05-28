package com.safewind.common.config;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONReader;
import com.alibaba.fastjson2.JSONWriter;
import com.alibaba.fastjson2.filter.Filter;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import java.nio.charset.Charset;

/**
 * @Author: Darven
 * @CreateTime: 2025-05-28  14:54
 * @Description: TODO
 */
public class FastJson2JsonRedisSerializer<T> implements RedisSerializer<T> {
    /**
     * 自动识别json对象白名单配置（仅允许解析的包名，范围越小越安全）  *这是允许访问的报名，如果是自己项目的话就改成自己包名
     * 类似  com.molu
     */
    public static  String[] JSON_WHITELIST_STR = { "org.springframework", "com.safewind" };

    // 定义默认的字符编码为UTF - 8
    public static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");

    // 创建一个自动类型过滤器，用于过滤JSON解析过程中的类型，只允许Constants.JSON_WHITELIST_STR中的类型通过
    static final Filter AUTO_TYPE_FILTER = JSONReader.autoTypeFilter(JSON_WHITELIST_STR);

    private Class<T> clazz;

    public FastJson2JsonRedisSerializer(Class<T> clazz) {
        super();
        this.clazz = clazz;
    }

    // 将对象序列化为字节数组，用于存储到Redis中
    @Override
    public byte[] serialize(T t) throws SerializationException {
        if (t == null) {
            // 如果对象为null，返回一个空字节数组
            return new byte[0];
        }
        // 将对象转换为JSON字符串，并带上类型信息（WriteClassName），然后将字符串编码为字节数组（使用默认字符编码UTF - 8）
        return JSON.toJSONString(t, JSONWriter.Feature.WriteClassName).getBytes(DEFAULT_CHARSET);
    }

    // 将从Redis中读取的字节数组反序列化为对象
    @Override
    public T deserialize(byte[] bytes) throws SerializationException {
        if (bytes == null || bytes.length <= 0) {
            return null;
        }
        // 将字节数组转换为字符串（使用默认字符编码UTF - 8）
        String str = new String(bytes, DEFAULT_CHARSET);

        // 使用FastJSON解析字符串为指定类型的对象，同时应用自动类型过滤器
        return JSON.parseObject(str, clazz, AUTO_TYPE_FILTER);
    }
}
