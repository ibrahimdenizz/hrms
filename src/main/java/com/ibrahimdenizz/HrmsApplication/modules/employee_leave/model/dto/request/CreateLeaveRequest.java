package com.ibrahimdenizz.HrmsApplication.modules.employee_leave.model.dto.request;

import java.time.LocalDate;

public record CreateLeaveRequest(
        String leaveTypeId,
        LocalDate startDate,
        LocalDate endDate,
        String reason
) {
}
