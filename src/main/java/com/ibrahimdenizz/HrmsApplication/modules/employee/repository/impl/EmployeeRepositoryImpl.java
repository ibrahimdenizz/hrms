package com.ibrahimdenizz.HrmsApplication.modules.employee.repository.impl;

import com.ibrahimdenizz.HrmsApplication.modules.employee.model.entity.EmployeeEntity;
import com.ibrahimdenizz.HrmsApplication.modules.employee.repository.EmployeeRepository;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private final Sql2o sql2o;

    public EmployeeRepositoryImpl(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    public void save(EmployeeEntity employeeEntity) {
        try (Connection con = sql2o.open(); final Query query = con.createQuery(employeeEntity.getInsertQuery())) {
            query.bind(employeeEntity);
            query.executeUpdate();
        }
    }
}
