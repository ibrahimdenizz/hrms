package com.ibrahimdenizz.HrmsApplication.modules.leave.model.dto.response;

import com.ibrahimdenizz.HrmsApplication.modules.leave.model.dto.domain.Leave;
import com.ibrahimdenizz.HrmsApplication.modules.leave.model.enums.LeaveStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class EmployeeLeavesResponse {

    private LocalDate startDate;
    private LocalDate endDate;

    private String reason;
    private LeaveStatus leaveStatus;
    private String leaveType;
    private LocalDateTime createdAt;

    public EmployeeLeavesResponse() {
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

    public String getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
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

    public static EmployeeLeavesResponse fromDomain(Leave leave) {
        return EmployeeLeavesResponse.builder()
                .startDate(leave.getStartDate())
                .endDate(leave.getEndDate())
                .reason(leave.getReason())
                .status(leave.getStatus())
                .leaveType(leave.getLeaveType().getName())
                .createdAt(leave.getCreatedAt())
                .build();
    }

    public static EmployeeLeavesResponseBuilder builder() {
        return new EmployeeLeavesResponseBuilder();
    }

    public static class EmployeeLeavesResponseBuilder {

        private final EmployeeLeavesResponse employeeLeavesResponse;

        public EmployeeLeavesResponse build() {
            return this.employeeLeavesResponse;
        }

        public EmployeeLeavesResponseBuilder() {
            this.employeeLeavesResponse = new EmployeeLeavesResponse();
        }

        public EmployeeLeavesResponseBuilder startDate(LocalDate startDate) {
            this.employeeLeavesResponse.startDate = startDate;
            return this;
        }

        public EmployeeLeavesResponseBuilder endDate(LocalDate endDate) {
            this.employeeLeavesResponse.endDate = endDate;
            return this;
        }

        public EmployeeLeavesResponseBuilder reason(String reason) {
            this.employeeLeavesResponse.reason = reason;
            return this;
        }

        public EmployeeLeavesResponseBuilder status(LeaveStatus leaveStatus) {
            this.employeeLeavesResponse.leaveStatus = leaveStatus;
            return this;
        }

        public EmployeeLeavesResponseBuilder leaveType(String leaveType) {
            this.employeeLeavesResponse.leaveType = leaveType;
            return this;
        }

        public EmployeeLeavesResponseBuilder createdAt(LocalDateTime createdAt) {
            this.employeeLeavesResponse.createdAt = createdAt;
            return this;
        }

    }

}
