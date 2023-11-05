package com.ibrahimdenizz.HrmsApplication.modules.employee_leave.repository;

import com.ibrahimdenizz.HrmsApplication.modules.employee_leave.model.entity.EmployeeLeaveEntity;

import java.util.List;

public interface EmployeeLeaveRepository {

    void save(EmployeeLeaveEntity employeeLeaveEntity);

    List<EmployeeLeaveEntity> getAllEmployeeLeaves(String employeeId);
}
