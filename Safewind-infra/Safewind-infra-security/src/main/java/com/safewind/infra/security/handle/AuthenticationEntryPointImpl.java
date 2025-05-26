package com.safewind.infra.security.handle;

import com.safewind.common.enums.ResultCodeEnum;
import com.safewind.common.utils.JsonUtils;
import com.safewind.common.utils.Result;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Serial;
import java.io.Serializable;

/**
 * @Author: Darven
 * @CreateTime: 2025-05-24  23:45
 * @Description: 认证失败处理类 返回未授权
 */
@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint, Serializable
{
    @Serial
    private static final long serialVersionUID = -8970718410437077606L;

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e)
            throws IOException
    {
        String msg="请求访问：{"+request.getRequestURI()+"}，认证失败，无法访问系统资源";
        response.setStatus(200);
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        response.getWriter().print(JsonUtils.toJsonString(Result.fail(ResultCodeEnum.UNAUTHORIZED, msg)));
    }
}
