package com.ibrahimdenizz.HrmsApplication.modules.employee.service;

import com.ibrahimdenizz.HrmsApplication.modules.employee.model.dto.domain.Employee;
import com.ibrahimdenizz.HrmsApplication.modules.employee.model.dto.request.CreateEmployeeRequest;

public interface EmployeeService {

    Employee createEmployee(CreateEmployeeRequest request);

}
