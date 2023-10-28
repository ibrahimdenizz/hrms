package com.ibrahimdenizz.HrmsApplication.modules.employee.exception;

import java.io.Serial;

public class EmployeeUsernameAlreadyExists extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 6510119414929463688L;

    public EmployeeUsernameAlreadyExists() {
        super("Employee Already Exists!");
    }

}
