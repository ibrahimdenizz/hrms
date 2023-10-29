package com.ibrahimdenizz.HrmsApplication.modules.employee_leave.model.dto.domain;

import com.ibrahimdenizz.HrmsApplication.modules.employee_leave.model.entity.EmployeeLeaveEntity;
import com.ibrahimdenizz.HrmsApplication.modules.employee_leave.model.enums.Status;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class EmployeeLeave {

    private String id;
    private String employeeId;
    private String leaveTypeId;
    private LocalDate startDate;
    private LocalDate endDate;
    private String reason;
    private Status status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private EmployeeLeaveType leaveType;

    public EmployeeLeave() {
    }

    public static EmployeeLeave fromEntity(EmployeeLeaveEntity entity) {
        return EmployeeLeave.builder()
                .id(entity.getId())
                .employeeId(entity.getEmployeeId())
                .leaveTypeId(entity.getLeaveTypeId())
                .startDate(entity.getStartDate())
                .endDate(entity.getEndDate())
                .reason(entity.getReason())
                .status(entity.getStatus())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .leaveType(EmployeeLeaveType.fromEntity(entity.getLeaveType()))
                .build();
    }

    public EmployeeLeaveEntity toEntity() {
        return EmployeeLeaveEntity.builder()
                .id(this.getId())
                .employeeID(this.getEmployeeId())
                .leaveTypeId(this.getLeaveTypeId())
                .startDate(this.getStartDate())
                .endDate(this.getEndDate())
                .reason(this.getReason())
                .status(this.getStatus())
                .createdAt(this.getCreatedAt())
                .updatedAt(this.getUpdatedAt())
                .leaveType(this.getLeaveType() == null ? null : this.getLeaveType().toEntity())
                .build();
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
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

    public EmployeeLeaveType getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(EmployeeLeaveType leaveType) {
        this.leaveType = leaveType;
    }

    public static EmployeeLeaveBuilder builder() {
        return new EmployeeLeaveBuilder();
    }

    public static class EmployeeLeaveBuilder {

        private final EmployeeLeave employeeLeave;

        public EmployeeLeaveBuilder() {
            this.employeeLeave = new EmployeeLeave();
        }

        public EmployeeLeave build() {
            return this.employeeLeave;
        }

        public EmployeeLeaveBuilder id(String id) {
            this.employeeLeave.id = id;
            return this;
        }

        public EmployeeLeaveBuilder employeeId(String employeeId) {
            this.employeeLeave.employeeId = employeeId;
            return this;
        }

        public EmployeeLeaveBuilder leaveTypeId(String leaveTypeId) {
            this.employeeLeave.leaveTypeId = leaveTypeId;
            return this;
        }

        public EmployeeLeaveBuilder startDate(LocalDate startDate) {
            this.employeeLeave.startDate = startDate;
            return this;
        }

        public EmployeeLeaveBuilder endDate(LocalDate endDate) {
            this.employeeLeave.endDate = endDate;
            return this;
        }

        public EmployeeLeaveBuilder reason(String reason) {
            this.employeeLeave.reason = reason;
            return this;
        }

        public EmployeeLeaveBuilder status(Status status) {
            this.employeeLeave.status = status;
            return this;
        }

        public EmployeeLeaveBuilder createdAt(LocalDateTime createdAt) {
            this.employeeLeave.createdAt = createdAt;
            return this;
        }

        public EmployeeLeaveBuilder updatedAt(LocalDateTime updatedAt) {
            this.employeeLeave.updatedAt = updatedAt;
            return this;
        }

        public EmployeeLeaveBuilder leaveType(EmployeeLeaveType leaveType) {
            this.employeeLeave.leaveType = leaveType;
            return this;
        }

    }

}
