package com.ibrahimdenizz.HrmsApplication.modules.auth.controller;

import com.ibrahimdenizz.HrmsApplication.annotations.RestControllerV1;
import com.ibrahimdenizz.HrmsApplication.modules.auth.model.dto.request.LoginRequest;
import com.ibrahimdenizz.HrmsApplication.modules.auth.model.dto.request.UpdatePasswordRequest;
import com.ibrahimdenizz.HrmsApplication.modules.auth.service.AuthService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestControllerV1
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/auth/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        return authService.login(loginRequest.username(), loginRequest.password());
    }

    @PostMapping("/auth/employee/{id}/password")
    public void updatePassword(@PathVariable String id, @RequestBody UpdatePasswordRequest updatePasswordRequest) {
        authService.updatePassword(id, updatePasswordRequest.password());
    }

}
