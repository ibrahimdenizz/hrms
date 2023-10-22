package com.ibrahimdenizz.HrmsApplication.modules.employee.model.dto.request;

import com.ibrahimdenizz.HrmsApplication.modules.employee.model.enums.Gender;
import com.ibrahimdenizz.HrmsApplication.modules.employee.model.enums.Role;

import java.util.Date;

public record CreateEmployeeRequest(
        String firstName,
        String lastName,
        String email,
        Gender gender,
        String department,
        Date birthday,
        Date startedWorkAt,
        Role role
) {
}
