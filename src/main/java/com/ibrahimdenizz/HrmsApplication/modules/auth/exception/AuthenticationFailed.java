package com.ibrahimdenizz.HrmsApplication.modules.auth.exception;

import java.io.Serial;

public class AuthenticationFailed extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 3972226317356859276L;

    public AuthenticationFailed() {
        super("Authentication failed!");
    }

}
