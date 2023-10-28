package com.ibrahimdenizz.HrmsApplication.modules.employee.repository;

import com.ibrahimdenizz.HrmsApplication.modules.employee.model.entity.EmployeeEntity;

import java.util.List;

public interface EmployeeRepository {

    void save(EmployeeEntity employeeEntity);

    List<String> findAllGetUsername();

    EmployeeEntity findByUsername(String username);

}
