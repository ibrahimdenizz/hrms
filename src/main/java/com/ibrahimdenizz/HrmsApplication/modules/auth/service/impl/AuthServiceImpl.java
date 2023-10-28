package com.ibrahimdenizz.HrmsApplication.modules.auth.service.impl;

import com.ibrahimdenizz.HrmsApplication.modules.auth.exception.AuthenticationFailed;
import com.ibrahimdenizz.HrmsApplication.modules.auth.service.AuthService;
import com.ibrahimdenizz.HrmsApplication.modules.employee.model.entity.EmployeeEntity;
import com.ibrahimdenizz.HrmsApplication.modules.employee.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final EmployeeRepository employeeRepository;

    public AuthServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    public String login(String username, String password) {
        EmployeeEntity employeeEntity = employeeRepository.findByUsername(username);

        if (!employeeEntity.getPassword().equals(password)) {
            throw new AuthenticationFailed();
        }

        return "Login successful";
    }

}
