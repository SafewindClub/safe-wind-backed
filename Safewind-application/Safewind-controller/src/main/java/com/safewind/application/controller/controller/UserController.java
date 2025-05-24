package com.safewind.application.controller.controller;

import com.safewind.application.controller.dto.UserLoginDTO;
import com.safewind.application.controller.vo.UserLoginVO;
import com.safewind.common.annotation.ApiOperationLog;
import com.safewind.common.utils.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Darven
 * @CreateTime: 2025-05-23  23:32
 * @Description: 用户控制层
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @ApiOperationLog(description = "登录接口")
    @PostMapping("/login")
    public Result<UserLoginVO> login(@RequestBody UserLoginDTO userLoginDTO){
        return Result.success();
    }

    @ApiOperationLog(description = "注册接口")
    @PostMapping("/register")
    public Result<UserLoginVO> register(@RequestBody UserLoginDTO userLoginDTO){
        return Result.success();
    }
}
