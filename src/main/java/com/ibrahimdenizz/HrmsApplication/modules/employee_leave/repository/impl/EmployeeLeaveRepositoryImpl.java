package com.ibrahimdenizz.HrmsApplication.modules.employee_leave.repository.impl;

import com.ibrahimdenizz.HrmsApplication.modules.employee_leave.model.entity.EmployeeLeaveEntity;
import com.ibrahimdenizz.HrmsApplication.modules.employee_leave.repository.EmployeeLeaveRepository;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;

@Repository
public class EmployeeLeaveRepositoryImpl implements EmployeeLeaveRepository {

    private final Sql2o sql2o;

    public EmployeeLeaveRepositoryImpl(Sql2o sql2o) {
        this.sql2o = sql2o;
    }


    @Override
    public void save(EmployeeLeaveEntity employeeLeaveEntity) {
        String sql = "INSERT INTO hrms.LEAVE (ID, EMPLOYEE_ID, LEAVE_TYPE_ID, START_DATE, END_DATE, REASON, STATUS, CREATED_AT, UPDATED_AT) " +
                     "VALUES (:id, :employeeId, :leaveTypeId, :startDate, :endDate, :reason, :status, :createdAt, :updatedAt)";

        try (Connection connection = sql2o.open(); Query query = connection.createQuery(sql)) {
            query.addParameter("id", employeeLeaveEntity.getId())
                    .addParameter("employeeId", employeeLeaveEntity.getEmployeeId())
                    .addParameter("leaveTypeId", employeeLeaveEntity.getLeaveTypeId())
                    .addParameter("startDate", employeeLeaveEntity.getStartDate())
                    .addParameter("endDate", employeeLeaveEntity.getEndDate())
                    .addParameter("reason", employeeLeaveEntity.getReason())
                    .addParameter("status", employeeLeaveEntity.getStatus())
                    .addParameter("createdAt", employeeLeaveEntity.getCreatedAt())
                    .addParameter("updatedAt", employeeLeaveEntity.getUpdatedAt())
                    .executeUpdate();
        }
    }
}
