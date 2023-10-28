package com.ibrahimdenizz.HrmsApplication.modules.employee.exception;

public class EmployeeUsernameAlreadyExists extends RuntimeException {


    public EmployeeUsernameAlreadyExists() {
        super("Employee Already Exists!");
    }
}
