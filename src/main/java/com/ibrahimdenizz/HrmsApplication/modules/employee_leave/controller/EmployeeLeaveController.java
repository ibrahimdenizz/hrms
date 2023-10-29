package com.ibrahimdenizz.HrmsApplication.modules.employee_leave.controller;

import com.ibrahimdenizz.HrmsApplication.annotations.RestControllerV1;
import com.ibrahimdenizz.HrmsApplication.modules.employee_leave.model.dto.request.CreateLeaveRequest;
import com.ibrahimdenizz.HrmsApplication.modules.employee_leave.service.EmployeeLeaveService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestControllerV1
public class EmployeeLeaveController {

    private final EmployeeLeaveService employeeLeaveService;

    public EmployeeLeaveController(EmployeeLeaveService employeeLeaveService) {
        this.employeeLeaveService = employeeLeaveService;
    }


    @PostMapping("/employee/{id}/leave")
    public void createEmployeeLeave(@PathVariable String id, @RequestBody CreateLeaveRequest request) {
        employeeLeaveService.createEmployeeLeave(id, request);
    }

    @GetMapping("/employee/{id}/leave")
    public void getAllEmployeeLeaves(@PathVariable String id) {
    }


}
