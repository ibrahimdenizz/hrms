package com.ibrahimdenizz.HrmsApplication.modules.employee.controller;

import com.ibrahimdenizz.HrmsApplication.annotations.RestControllerV1;
import com.ibrahimdenizz.HrmsApplication.modules.employee.model.dto.domain.Employee;
import com.ibrahimdenizz.HrmsApplication.modules.employee.model.dto.request.CreateEmployeeRequest;
import com.ibrahimdenizz.HrmsApplication.modules.employee.model.dto.response.CreateEmployeeResponse;
import com.ibrahimdenizz.HrmsApplication.modules.employee.service.EmployeeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestControllerV1
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @PostMapping("/employee")
    public CreateEmployeeResponse createEmployee(@RequestBody CreateEmployeeRequest request) {
        Employee employee = employeeService.createEmployee(request);
        return CreateEmployeeResponse.builder()
                .username(employee.getUsername())
                .password(employee.getPassword())
                .build();
    }

}
