package com.ibrahimdenizz.HrmsApplication.modules.employee.service.impl;

import com.ibrahimdenizz.HrmsApplication.modules.employee.model.dto.domain.Employee;
import com.ibrahimdenizz.HrmsApplication.modules.employee.model.dto.request.CreateEmployeeRequest;
import com.ibrahimdenizz.HrmsApplication.modules.employee.repository.EmployeeRepository;
import com.ibrahimdenizz.HrmsApplication.modules.employee.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    /**
     * @param request The request object for creating an employee.
     */
    @Override
    public void createEmployee(CreateEmployeeRequest request) {
        Employee employee = Employee.builder()
                .id(UUID.randomUUID().toString())
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .gender(request.gender())
                .department(request.department())
                .birthday(request.birthday())
                .startedWorkAt(request.startedWorkAt())
                .role(request.role())
                .createdAt(LocalDateTime.now())
                .generateUsername()
                .generatePassword()
                .build();

        employeeRepository.save(employee.toEntity());
    }
}
