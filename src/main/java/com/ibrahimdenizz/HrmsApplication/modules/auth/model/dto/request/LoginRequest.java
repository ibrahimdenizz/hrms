package com.ibrahimdenizz.HrmsApplication.modules.auth.model.dto.request;

public record LoginRequest(
        String username,
        String password
) {
}
