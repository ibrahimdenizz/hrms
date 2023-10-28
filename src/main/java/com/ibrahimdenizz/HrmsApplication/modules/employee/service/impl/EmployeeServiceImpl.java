package com.ibrahimdenizz.HrmsApplication.modules.employee.service.impl;

import com.ibrahimdenizz.HrmsApplication.modules.employee.exception.EmployeeUsernameAlreadyExists;
import com.ibrahimdenizz.HrmsApplication.modules.employee.model.dto.domain.Employee;
import com.ibrahimdenizz.HrmsApplication.modules.employee.model.dto.request.CreateEmployeeRequest;
import com.ibrahimdenizz.HrmsApplication.modules.employee.repository.EmployeeRepository;
import com.ibrahimdenizz.HrmsApplication.modules.employee.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
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
    public Employee createEmployee(CreateEmployeeRequest request) {
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

        this.checkEmployeeUsernameAndFix(employee);
        employeeRepository.save(employee.toEntity());

        return employee;
    }

    private void checkEmployeeUsernameAndFix(Employee employee) {
        List<String> usernames = this.employeeRepository.findAllGetUsername();
        boolean isEmployeeUsernameExists = true;

        for (int i = 0; i < 5; i++) {
            if (usernames.contains(employee.getUsername())) {
                employee.setUsername(employee.getUsername() + new Random().nextInt(10));
            } else {
                isEmployeeUsernameExists = false;
                break;
            }
        }
        if (isEmployeeUsernameExists) throw new EmployeeUsernameAlreadyExists();

    }

}
