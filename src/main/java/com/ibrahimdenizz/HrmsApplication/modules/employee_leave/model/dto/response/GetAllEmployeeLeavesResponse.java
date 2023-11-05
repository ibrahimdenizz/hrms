package com.ibrahimdenizz.HrmsApplication.modules.employee_leave.model.dto.response;

import com.ibrahimdenizz.HrmsApplication.modules.employee_leave.model.dto.domain.EmployeeLeave;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class GetAllEmployeeLeavesResponse {

    private LocalDate startDate;
    private LocalDate endDate;

    private String leaveTypeName;
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

    public String getLeaveTypeName() {
        return leaveTypeName;
    }

    public void setLeaveTypeName(String leaveTypeName) {
        this.leaveTypeName = leaveTypeName;
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
                .leaveTypeName(employeeLeave.getLeaveType().getName())
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

        public GetAllEmployeeLeavesResponseBuilder leaveTypeName(String leaveTypeName) {
            this.getAllEmployeeLeavesResponse.leaveTypeName = leaveTypeName;
            return this;
        }

        public GetAllEmployeeLeavesResponseBuilder createdAt(LocalDateTime createdAt) {
            this.getAllEmployeeLeavesResponse.createdAt = createdAt;
            return this;
        }

    }

}
