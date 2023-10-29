package com.ibrahimdenizz.HrmsApplication.modules.employee_leave.service;

import com.ibrahimdenizz.HrmsApplication.modules.employee_leave.model.dto.request.CreateLeaveRequest;

public interface EmployeeLeaveService {

    void createEmployeeLeave(String employeeId, CreateLeaveRequest request);

    void findAllByEmployeeId();

}
