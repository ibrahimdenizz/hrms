package com.ibrahimdenizz.HrmsApplication.modules.employee.model.dto.request;

import com.ibrahimdenizz.HrmsApplication.modules.employee.model.enums.Gender;
import com.ibrahimdenizz.HrmsApplication.modules.employee.model.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record CreateEmployeeRequest(
        @NotNull
        String firstName,
        @NotNull
        String lastName,
        @NotNull
        @Email
        String email,
        @NotNull
        Gender gender,
        @NotNull
        String department,
        @NotNull
        LocalDate birthday,
        @NotNull
        LocalDate startedWorkAt,
        @NotNull
        Role role
) {
}
