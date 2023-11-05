package com.ibrahimdenizz.HrmsApplication.modules.employee_leave.controller;

import com.ibrahimdenizz.HrmsApplication.annotations.RestControllerV1;
import com.ibrahimdenizz.HrmsApplication.modules.employee_leave.model.dto.domain.EmployeeLeave;
import com.ibrahimdenizz.HrmsApplication.modules.employee_leave.model.dto.request.CreateLeaveRequest;
import com.ibrahimdenizz.HrmsApplication.modules.employee_leave.model.dto.response.GetAllEmployeeLeavesResponse;
import com.ibrahimdenizz.HrmsApplication.modules.employee_leave.service.EmployeeLeaveService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

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
    public List<GetAllEmployeeLeavesResponse> getAllEmployeeLeaves(@PathVariable String id) {
        List<EmployeeLeave> employeeLeaveList = employeeLeaveService.getAllEmployeeLeaves(id);
        return employeeLeaveList.stream()
                .map(GetAllEmployeeLeavesResponse::fromDomain)
                .toList();
    }


}
