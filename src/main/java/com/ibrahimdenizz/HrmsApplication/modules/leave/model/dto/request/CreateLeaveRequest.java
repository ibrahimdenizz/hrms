package com.ibrahimdenizz.HrmsApplication.modules.leave.model.dto.request;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record CreateLeaveRequest(
        @NotNull
        String leaveTypeId,
        @NotNull
        LocalDate startDate,
        @NotNull
        LocalDate endDate,
        String reason
) {

    @AssertTrue(message = "Start date must be before end date")
    public boolean isValidIfStartDateBeforeEndDate() {
        if (startDate == null || endDate == null) {
            return true;
        }
        return startDate.isBefore(endDate);
    }

    @AssertTrue(message = "Start date must be after today")
    public boolean isValidIfStartDateBeforeToday() {
        if (startDate == null) {
            return true;
        }
        return startDate.isAfter(LocalDate.now());
    }
}
