package com.ibrahimdenizz.HrmsApplication.modules.employee.service;

import com.ibrahimdenizz.HrmsApplication.modules.employee.model.domain.Employee;
import com.ibrahimdenizz.HrmsApplication.modules.employee.model.request.CreateEmployeeRequest;

public interface EmployeeService {

    Employee createEmployee(CreateEmployeeRequest request);

}
