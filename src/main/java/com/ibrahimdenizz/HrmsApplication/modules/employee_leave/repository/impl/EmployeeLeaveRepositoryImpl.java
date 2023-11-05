package com.ibrahimdenizz.HrmsApplication.modules.employee_leave.repository.impl;

import com.ibrahimdenizz.HrmsApplication.modules.employee_leave.model.entity.EmployeeLeaveEntity;
import com.ibrahimdenizz.HrmsApplication.modules.employee_leave.repository.EmployeeLeaveRepository;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class EmployeeLeaveRepositoryImpl implements EmployeeLeaveRepository {

    private final Sql2o sql2o;

    public EmployeeLeaveRepositoryImpl(Sql2o sql2o) {
        this.sql2o = sql2o;
    }


    @Override
    public void save(EmployeeLeaveEntity employeeLeaveEntity) {
        String sql = "INSERT INTO `LEAVE` (ID, EMPLOYEE_ID, LEAVE_TYPE_ID, START_DATE, END_DATE, REASON, STATUS, CREATED_AT) " +
                     "VALUES (:id, :employeeId, :leaveTypeId, :startDate, :endDate, :reason, :status, :createdAt)";

        try (Connection connection = sql2o.open(); Query query = connection.createQuery(sql)) {
            query.addParameter("id", employeeLeaveEntity.getId())
                    .addParameter("employeeId", employeeLeaveEntity.getEmployeeId())
                    .addParameter("leaveTypeId", employeeLeaveEntity.getLeaveTypeId())
                    .addParameter("startDate", employeeLeaveEntity.getStartDate())
                    .addParameter("endDate", employeeLeaveEntity.getEndDate())
                    .addParameter("reason", employeeLeaveEntity.getReason())
                    .addParameter("status", employeeLeaveEntity.getStatus())
                    .addParameter("createdAt", employeeLeaveEntity.getCreatedAt())
                    .executeUpdate();
        }
    }

    @Override
    public List<EmployeeLeaveEntity> getAllEmployeeLeaves(String employeeId) {
        String sql = "SELECT " +
                     "`leave`.ID AS ID, `leave`.EMPLOYEE_ID AS EMPLOYEE_ID, `leave`.START_DATE AS START_DATE, " +
                     "`leave`.END_DATE AS END_DATE, `leave`.REASON AS REASON, `leave`.STATUS AS STATUS, " +
                     "`leave`.CREATED_AT AS CREATED_AT, `leave`.UPDATED_AT AS UPDATED_AT, " +
                     "leave_type.ID AS LEAVE_TYPE_ID, leave_type.NAME AS LEAVE_TYPE_NAME " +
                     "FROM `LEAVE` AS `leave` " +
                     "INNER JOIN LEAVE_TYPE AS leave_type ON `leave`.LEAVE_TYPE_ID = leave_type.ID " +
                     "WHERE `leave`.EMPLOYEE_ID = :employeeId";

        try (Connection connection = sql2o.open(); Query query = connection.createQuery(sql)) {
            return query.addParameter("employeeId", employeeId)
                    .executeAndFetchTable()
                    .rows()
                    .stream()
                    .map(EmployeeLeaveEntity::fromTableRow)
                    .toList();
        }
    }
}
