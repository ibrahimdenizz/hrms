package com.ibrahimdenizz.HrmsApplication.modules.employee.service;

import com.ibrahimdenizz.HrmsApplication.modules.employee.model.dto.request.CreateEmployeeRequest;

public interface EmployeeService {

    void createEmployee(CreateEmployeeRequest request);

}
