package com.ibrahimdenizz.HrmsApplication.modules.leave.repository;

import com.ibrahimdenizz.HrmsApplication.modules.leave.model.entity.LeaveEntity;

import java.util.List;

public interface LeaveRepository {

    void save(LeaveEntity leaveEntity);

    List<LeaveEntity> findAllByEmployeeId(String employeeId);
}
