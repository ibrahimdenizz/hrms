package com.ibrahimdenizz.HrmsApplication.modules.auth.exception;

public class AuthenticationFailed extends RuntimeException {

    public AuthenticationFailed() {
        super("Authentication failed!");
    }
}
