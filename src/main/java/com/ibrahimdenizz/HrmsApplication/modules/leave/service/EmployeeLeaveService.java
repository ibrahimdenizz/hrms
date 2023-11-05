package com.ibrahimdenizz.HrmsApplication.modules.leave.service;

import com.ibrahimdenizz.HrmsApplication.modules.leave.model.dto.domain.Leave;
import com.ibrahimdenizz.HrmsApplication.modules.leave.model.dto.request.CreateLeaveRequest;

import java.util.List;

public interface EmployeeLeaveService {

    void createEmployeeLeave(String employeeId, CreateLeaveRequest request);

    List<Leave> getAllEmployeeLeaves(String employeeId);
}
