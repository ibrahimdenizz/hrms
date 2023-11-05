package com.ibrahimdenizz.HrmsApplication.modules.leave.model.entity;

import com.ibrahimdenizz.HrmsApplication.annotations.Column;
import com.ibrahimdenizz.HrmsApplication.modules.employee.model.entity.EmployeeEntity;
import com.ibrahimdenizz.HrmsApplication.modules.leave.model.enums.LeaveStatus;
import org.sql2o.data.Row;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class LeaveEntity {
    @Column(columnName = "ID")
    private String id;
    @Column(columnName = "EMPLOYEE_ID")
    private String employeeId;
    @Column(columnName = "LEAVE_TYPE_ID")
    private String leaveTypeId;
    @Column(columnName = "START_DATE")
    private LocalDate startDate;
    @Column(columnName = "END_DATE")
    private LocalDate endDate;
    @Column(columnName = "REASON")
    private String reason;
    @Column(columnName = "STATUS")
    private LeaveStatus leaveStatus;
    @Column(columnName = "CREATED_AT")
    private LocalDateTime createdAt;
    @Column(columnName = "UPDATED_AT")
    private LocalDateTime updatedAt;

    private LeaveTypeEntity leaveType;
    private EmployeeEntity employee;

    public LeaveEntity() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getLeaveTypeId() {
        return leaveTypeId;
    }

    public void setLeaveTypeId(String leaveTypeId) {
        this.leaveTypeId = leaveTypeId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public LeaveStatus getStatus() {
        return leaveStatus;
    }

    public void setStatus(LeaveStatus leaveStatus) {
        this.leaveStatus = leaveStatus;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LeaveTypeEntity getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(LeaveTypeEntity leaveType) {
        this.leaveType = leaveType;
    }

    public EmployeeEntity getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeEntity employee) {
        this.employee = employee;
    }

    static public LeaveEntity fromTableRow(Row row) {
        LocalDate startDate = new Date(row.getDate("start_date").getTime()).toLocalDate();
        LocalDate endDate = new Date(row.getDate("end_date").getTime()).toLocalDate();
        LocalDateTime createdAt = (LocalDateTime) row.getObject("created_at");
        LocalDateTime updatedAt = (LocalDateTime) row.getObject("updated_at");

        LeaveEntity leaveEntity = new LeaveEntity();
        leaveEntity.setId(row.getString("id"));
        leaveEntity.setEmployeeId(row.getString("employee_id"));
        leaveEntity.setLeaveTypeId(row.getString("leave_type_id"));
        leaveEntity.setStartDate(startDate);
        leaveEntity.setEndDate(endDate);
        leaveEntity.setReason(row.getString("reason"));
        leaveEntity.setStatus(LeaveStatus.valueOf(row.getString("status")));
        leaveEntity.setCreatedAt(createdAt);
        leaveEntity.setUpdatedAt(updatedAt);
        LeaveTypeEntity leaveTypeEntity = new LeaveTypeEntity();
        leaveTypeEntity.setId(row.getString("leave_type_id"));
        leaveTypeEntity.setName(row.getString("leave_type_name"));
        leaveEntity.setLeaveType(leaveTypeEntity);
        return leaveEntity;
    }

    public static EmployeeLeaveEntityBuilder builder() {
        return new EmployeeLeaveEntityBuilder();
    }


    public static class EmployeeLeaveEntityBuilder {

        private final LeaveEntity employeeEntity;

        public EmployeeLeaveEntityBuilder() {
            this.employeeEntity = new LeaveEntity();
        }

        public LeaveEntity build() {
            return this.employeeEntity;
        }

        public EmployeeLeaveEntityBuilder id(String id) {
            this.employeeEntity.id = id;
            return this;
        }

        public EmployeeLeaveEntityBuilder employeeID(String employeeID) {
            this.employeeEntity.employeeId = employeeID;
            return this;
        }

        public EmployeeLeaveEntityBuilder leaveTypeId(String leaveTypeId) {
            this.employeeEntity.leaveTypeId = leaveTypeId;
            return this;
        }

        public EmployeeLeaveEntityBuilder startDate(LocalDate startDate) {
            this.employeeEntity.startDate = startDate;
            return this;
        }

        public EmployeeLeaveEntityBuilder endDate(LocalDate endDate) {
            this.employeeEntity.endDate = endDate;
            return this;
        }

        public EmployeeLeaveEntityBuilder reason(String reason) {
            this.employeeEntity.reason = reason;
            return this;
        }

        public EmployeeLeaveEntityBuilder status(LeaveStatus leaveStatus) {
            this.employeeEntity.leaveStatus = leaveStatus;
            return this;
        }

        public EmployeeLeaveEntityBuilder createdAt(LocalDateTime createdAt) {
            this.employeeEntity.createdAt = createdAt;
            return this;
        }

        public EmployeeLeaveEntityBuilder updatedAt(LocalDateTime updatedAt) {
            this.employeeEntity.updatedAt = updatedAt;
            return this;
        }

        public EmployeeLeaveEntityBuilder leaveType(LeaveTypeEntity leaveType) {
            this.employeeEntity.leaveType = leaveType;
            return this;
        }

        public EmployeeLeaveEntityBuilder employee(EmployeeEntity employee) {
            this.employeeEntity.employee = employee;
            return this;
        }

    }

}
