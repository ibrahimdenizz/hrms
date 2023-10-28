package com.ibrahimdenizz.HrmsApplication.modules.auth.exception;

import java.io.Serial;

public class AuthEmployeeNotExists extends RuntimeException {

    @Serial
    private static final long serialVersionUID = -6889384485517060866L;

    public AuthEmployeeNotExists() {
        super("User Not Exists!");
    }
}
