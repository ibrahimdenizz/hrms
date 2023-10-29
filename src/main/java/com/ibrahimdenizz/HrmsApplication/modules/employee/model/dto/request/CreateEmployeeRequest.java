package com.ibrahimdenizz.HrmsApplication.modules.employee.model.dto.request;

import com.ibrahimdenizz.HrmsApplication.modules.employee.model.enums.Gender;
import com.ibrahimdenizz.HrmsApplication.modules.employee.model.enums.Role;

import java.time.LocalDate;

public record CreateEmployeeRequest(
        String firstName,
        String lastName,
        String email,
        Gender gender,
        String department,
        LocalDate birthday,
        LocalDate startedWorkAt,
        Role role
) {
}
