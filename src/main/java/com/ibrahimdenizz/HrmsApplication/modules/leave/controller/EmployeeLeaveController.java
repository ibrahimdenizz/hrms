package com.ibrahimdenizz.HrmsApplication.modules.leave.controller;

import com.ibrahimdenizz.HrmsApplication.annotations.RestControllerV1;
import com.ibrahimdenizz.HrmsApplication.modules.leave.model.dto.domain.Leave;
import com.ibrahimdenizz.HrmsApplication.modules.leave.model.dto.request.CreateLeaveRequest;
import com.ibrahimdenizz.HrmsApplication.modules.leave.model.dto.response.EmployeeLeavesResponse;
import com.ibrahimdenizz.HrmsApplication.modules.leave.service.EmployeeLeaveService;
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
    public List<EmployeeLeavesResponse> getAllEmployeeLeaves(@PathVariable String id) {
        List<Leave> leaves = employeeLeaveService.getAllEmployeeLeaves(id);
        return leaves.stream()
                .map(EmployeeLeavesResponse::fromDomain)
                .toList();
    }


}
