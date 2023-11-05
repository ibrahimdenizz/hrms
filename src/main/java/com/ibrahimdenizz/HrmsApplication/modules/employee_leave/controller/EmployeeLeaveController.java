package com.ibrahimdenizz.HrmsApplication.modules.employee_leave.controller;

import com.ibrahimdenizz.HrmsApplication.annotations.RestControllerV1;
import com.ibrahimdenizz.HrmsApplication.modules.employee_leave.model.dto.domain.EmployeeLeave;
import com.ibrahimdenizz.HrmsApplication.modules.employee_leave.model.dto.request.CreateLeaveRequest;
import com.ibrahimdenizz.HrmsApplication.modules.employee_leave.model.dto.response.GetAllEmployeeLeavesResponse;
import com.ibrahimdenizz.HrmsApplication.modules.employee_leave.service.EmployeeLeaveService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Void> createEmployeeLeave(@PathVariable String id, @RequestBody @Valid CreateLeaveRequest request) {
        employeeLeaveService.createEmployeeLeave(id, request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/employee/{id}/leave")
    public List<GetAllEmployeeLeavesResponse> getAllEmployeeLeaves(@PathVariable String id) {
        List<EmployeeLeave> employeeLeaveList = employeeLeaveService.getAllEmployeeLeaves(id);
        return employeeLeaveList.stream()
                .map(GetAllEmployeeLeavesResponse::fromDomain)
                .toList();
    }


}
