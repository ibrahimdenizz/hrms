package com.ibrahimdenizz.HrmsApplication.modules.leave.model.domain;

import com.ibrahimdenizz.HrmsApplication.modules.leave.model.entity.LeaveEntity;
import com.ibrahimdenizz.HrmsApplication.modules.leave.model.enums.LeaveStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Leave {

    private String id;
    private String employeeId;
    private String leaveTypeId;
    private LocalDate startDate;
    private LocalDate endDate;
    private String reason;
    private LeaveStatus leaveStatus;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private LeaveType leaveType;

    public Leave() {
    }

    public static Leave fromEntity(LeaveEntity entity) {
        return Leave.builder()
                .id(entity.getId())
                .employeeId(entity.getEmployeeId())
                .leaveTypeId(entity.getLeaveTypeId())
                .startDate(entity.getStartDate())
                .endDate(entity.getEndDate())
                .reason(entity.getReason())
                .status(entity.getStatus())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .leaveType(LeaveType.fromEntity(entity.getLeaveType()))
                .build();
    }

    public LeaveEntity toEntity() {
        return LeaveEntity.builder()
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

    public LeaveType getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(LeaveType leaveType) {
        this.leaveType = leaveType;
    }

    public static LeaveBuilder builder() {
        return new LeaveBuilder();
    }

    public static class LeaveBuilder {

        private final Leave leave;

        public LeaveBuilder() {
            this.leave = new Leave();
        }

        public Leave build() {
            return this.leave;
        }

        public LeaveBuilder id(String id) {
            this.leave.id = id;
            return this;
        }

        public LeaveBuilder employeeId(String employeeId) {
            this.leave.employeeId = employeeId;
            return this;
        }

        public LeaveBuilder leaveTypeId(String leaveTypeId) {
            this.leave.leaveTypeId = leaveTypeId;
            return this;
        }

        public LeaveBuilder startDate(LocalDate startDate) {
            this.leave.startDate = startDate;
            return this;
        }

        public LeaveBuilder endDate(LocalDate endDate) {
            this.leave.endDate = endDate;
            return this;
        }

        public LeaveBuilder reason(String reason) {
            this.leave.reason = reason;
            return this;
        }

        public LeaveBuilder status(LeaveStatus leaveStatus) {
            this.leave.leaveStatus = leaveStatus;
            return this;
        }

        public LeaveBuilder createdAt(LocalDateTime createdAt) {
            this.leave.createdAt = createdAt;
            return this;
        }

        public LeaveBuilder updatedAt(LocalDateTime updatedAt) {
            this.leave.updatedAt = updatedAt;
            return this;
        }

        public LeaveBuilder leaveType(LeaveType leaveType) {
            this.leave.leaveType = leaveType;
            return this;
        }

    }

}
