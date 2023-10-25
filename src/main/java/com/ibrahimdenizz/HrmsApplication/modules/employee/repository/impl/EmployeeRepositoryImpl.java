package com.ibrahimdenizz.HrmsApplication.modules.employee.repository.impl;

import com.ibrahimdenizz.HrmsApplication.modules.employee.model.entity.EmployeeEntity;
import com.ibrahimdenizz.HrmsApplication.modules.employee.repository.EmployeeRepository;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;

import java.util.Random;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private final Sql2o sql2o;

    public EmployeeRepositoryImpl(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    public void save(EmployeeEntity employeeEntity) {
        EmployeeEntity employee = this.findByUsername(employeeEntity.getUsername());
        for (int i = 0; i < 5; i++) {
            if (employee == null) break;
            employee = this.findByUsername(employeeEntity.getUsername());
            employeeEntity.setUsername(employeeEntity.getUsername() + new Random().nextInt(10));
        }
        if (employee != null) throw new RuntimeException("Username already exists");

        final String INSERT_EMPLOYEE_QUERY = """
                INSERT INTO EMPLOYEE (
                    ID, USERNAME, PASSWORD, FIRST_NAME, LAST_NAME, EMAIL, GENDER, DEPARTMENT, BIRTHDAY, STARTED_WORK_AT, LEAVE_WORK_AT, ROLE, CREATED_AT, UPDATED_AT
                ) VALUES (
                    :id, :username, :password, :firstName, :lastName, :email, :gender, :department, :birthday, :startedWorkAt, :leaveWorkAt, :role, :createdAt, :updatedAt
                )""";

        try (Connection con = sql2o.open(); final Query query = con.createQuery(INSERT_EMPLOYEE_QUERY)) {
            query.bind(employeeEntity).executeUpdate();
        }

    }

    public EmployeeEntity findByUsername(String username) {
        final String SELECT_EMPLOYEE_BY_USERNAME_QUERY = """
                SELECT * FROM EMPLOYEE WHERE USERNAME = :username
                """;
        try (Connection con = sql2o.open(); final Query query = con.createQuery(SELECT_EMPLOYEE_BY_USERNAME_QUERY)) {
            query.addParameter("username", username);
            return query.setColumnMappings(new EmployeeEntity().getColumnMappings()).executeAndFetchFirst(EmployeeEntity.class);
        }
    }
}
