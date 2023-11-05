package com.ibrahimdenizz.HrmsApplication.modules.employee_leave.model.dto.response;

import com.ibrahimdenizz.HrmsApplication.modules.employee_leave.model.dto.domain.EmployeeLeave;
import com.ibrahimdenizz.HrmsApplication.modules.employee_leave.model.enums.Status;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class GetAllEmployeeLeavesResponse {

    private LocalDate startDate;
    private LocalDate endDate;

    private String reason;
    private Status status;
    private String leaveType;
    private LocalDateTime createdAt;

    public GetAllEmployeeLeavesResponse() {
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

    public static GetAllEmployeeLeavesResponse fromDomain(EmployeeLeave employeeLeave) {
        return GetAllEmployeeLeavesResponse.builder()
                .startDate(employeeLeave.getStartDate())
                .endDate(employeeLeave.getEndDate())
                .reason(employeeLeave.getReason())
                .status(employeeLeave.getStatus())
                .leaveType(employeeLeave.getLeaveType().getName())
                .createdAt(employeeLeave.getCreatedAt())
                .build();
    }

    public static GetAllEmployeeLeavesResponseBuilder builder() {
        return new GetAllEmployeeLeavesResponseBuilder();
    }

    public static class GetAllEmployeeLeavesResponseBuilder {

        private final GetAllEmployeeLeavesResponse getAllEmployeeLeavesResponse;

        public GetAllEmployeeLeavesResponse build() {
            return this.getAllEmployeeLeavesResponse;
        }

        public GetAllEmployeeLeavesResponseBuilder() {
            this.getAllEmployeeLeavesResponse = new GetAllEmployeeLeavesResponse();
        }

        public GetAllEmployeeLeavesResponseBuilder startDate(LocalDate startDate) {
            this.getAllEmployeeLeavesResponse.startDate = startDate;
            return this;
        }

        public GetAllEmployeeLeavesResponseBuilder endDate(LocalDate endDate) {
            this.getAllEmployeeLeavesResponse.endDate = endDate;
            return this;
        }

        public GetAllEmployeeLeavesResponseBuilder reason(String reason) {
            this.getAllEmployeeLeavesResponse.reason = reason;
            return this;
        }

        public GetAllEmployeeLeavesResponseBuilder status(Status status) {
            this.getAllEmployeeLeavesResponse.status = status;
            return this;
        }

        public GetAllEmployeeLeavesResponseBuilder leaveType(String leaveType) {
            this.getAllEmployeeLeavesResponse.leaveType = leaveType;
            return this;
        }

        public GetAllEmployeeLeavesResponseBuilder createdAt(LocalDateTime createdAt) {
            this.getAllEmployeeLeavesResponse.createdAt = createdAt;
            return this;
        }

    }

}
