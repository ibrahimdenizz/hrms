package com.ibrahimdenizz.HrmsApplication.modules.employee_leave.service;

import com.ibrahimdenizz.HrmsApplication.modules.employee_leave.model.dto.domain.EmployeeLeave;
import com.ibrahimdenizz.HrmsApplication.modules.employee_leave.model.dto.request.CreateLeaveRequest;

import java.util.List;

public interface EmployeeLeaveService {

    void createEmployeeLeave(String employeeId, CreateLeaveRequest request);

    List<EmployeeLeave> getAllEmployeeLeaves(String employeeId);
}
