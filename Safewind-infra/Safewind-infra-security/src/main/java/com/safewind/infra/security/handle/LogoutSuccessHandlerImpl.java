package com.safewind.infra.security.handle;

import com.safewind.common.enums.ResultCodeEnum;
import com.safewind.common.utils.JsonUtils;
import com.safewind.common.utils.Result;
import com.safewind.infra.security.entity.LoginUser;
import com.safewind.infra.security.service.TokenService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import java.io.IOException;
import java.util.Objects;

/**
 * @Author: Darven
 * @CreateTime: 2025-05-25  10:04
 * @Description: 退出处理类
 */
@Slf4j
@Configuration
public class LogoutSuccessHandlerImpl implements LogoutSuccessHandler {

    @Autowired
    private TokenService tokenService;

    /**
     * 重写退出处理逻辑
     * */
    @Override
    public void onLogoutSuccess(HttpServletRequest request,
                                HttpServletResponse response,
                                Authentication authentication) throws IOException {
        LoginUser loginUser = tokenService.getLoginUser(request);
        log.info("退出用户信息={}", loginUser);
        if (Objects.nonNull(loginUser))
        {
            // 删除用户缓存记录
            tokenService.delLoginUser(loginUser.getToken());
            // todo 记录用户退出日志
            // 返回退出形式
            response.setStatus(200);
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            response.getWriter().print(JsonUtils.toJsonString(Result.fail(ResultCodeEnum.SUCCESS, "退出成功")));
            log.info("退出成功,退出用户ID={}", loginUser.getUserId());
        }
    }
}
