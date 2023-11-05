package com.ibrahimdenizz.HrmsApplication.modules.auth.model.request;

public record LoginRequest(
        String username,
        String password
) {
}
