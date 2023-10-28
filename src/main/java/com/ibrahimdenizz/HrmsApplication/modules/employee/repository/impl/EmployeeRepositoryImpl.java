package com.ibrahimdenizz.HrmsApplication.modules.employee.repository.impl;

import com.ibrahimdenizz.HrmsApplication.modules.employee.model.entity.EmployeeEntity;
import com.ibrahimdenizz.HrmsApplication.modules.employee.repository.EmployeeRepository;
import com.ibrahimdenizz.HrmsApplication.utils.ColumnMappingUtil;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private final Sql2o sql2o;

    public EmployeeRepositoryImpl(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    public void save(EmployeeEntity employeeEntity) {
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

    public List<String> findAllGetUsername() {
        final String SELECT_EMPLOYEE_WITH_USERNAME_QUERY = "SELECT USERNAME FROM EMPLOYEE";

        try (Connection con = sql2o.open(); final Query query = con.createQuery(SELECT_EMPLOYEE_WITH_USERNAME_QUERY)) {
            return query.executeScalarList(String.class);
        }
    }

    public EmployeeEntity findByUsername(String username) {
        final String SELECT_EMPLOYEE_BY_USERNAME_QUERY = """
                SELECT
                    ID, USERNAME, PASSWORD, FIRST_NAME, LAST_NAME, EMAIL, GENDER, DEPARTMENT, BIRTHDAY, STARTED_WORK_AT, LEAVE_WORK_AT, ROLE, CREATED_AT, UPDATED_AT
                FROM EMPLOYEE
                WHERE USERNAME = :username
                """;

        try (Connection con = sql2o.open(); final Query query = con.createQuery(SELECT_EMPLOYEE_BY_USERNAME_QUERY)) {
            return query.addParameter("username", username)
                    .setColumnMappings(ColumnMappingUtil.get(EmployeeEntity.class))
                    .executeAndFetchFirst(EmployeeEntity.class);
        }

    }

    public EmployeeEntity findById(String id) {
        final String SELECT_EMPLOYEE_BY_ID = """
                SELECT
                    ID, USERNAME, PASSWORD, FIRST_NAME, LAST_NAME, EMAIL, GENDER, DEPARTMENT, BIRTHDAY, STARTED_WORK_AT, LEAVE_WORK_AT, ROLE, CREATED_AT, UPDATED_AT
                FROM EMPLOYEE
                WHERE ID = :id
                """;

        try (Connection con = sql2o.open(); final Query query = con.createQuery(SELECT_EMPLOYEE_BY_ID)) {
            return query
                    .addParameter("id", id)
                    .setColumnMappings(ColumnMappingUtil.get(EmployeeEntity.class))
                    .executeAndFetchFirst(EmployeeEntity.class);
        }
    }

    public void updatePassword(String id, String newPassword) {
        final String UPDATE_EMPLOYEE_PASSWORD_QUERY = """
                UPDATE EMPLOYEE
                SET PASSWORD = :password
                WHERE ID = :id
                """;

        try (Connection con = sql2o.open(); final Query query = con.createQuery(UPDATE_EMPLOYEE_PASSWORD_QUERY)) {
            query.addParameter("id", id)
                    .addParameter("password", newPassword)
                    .executeUpdate();
        }
    }

}
