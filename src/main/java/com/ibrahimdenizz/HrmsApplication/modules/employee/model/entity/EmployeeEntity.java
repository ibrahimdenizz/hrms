package com.ibrahimdenizz.HrmsApplication.modules.employee.model.entity;

import com.ibrahimdenizz.HrmsApplication.annotations.Column;
import com.ibrahimdenizz.HrmsApplication.annotations.Table;
import com.ibrahimdenizz.HrmsApplication.model.entity.BaseEntity;
import com.ibrahimdenizz.HrmsApplication.modules.employee.model.enums.Gender;
import com.ibrahimdenizz.HrmsApplication.modules.employee.model.enums.Role;

import java.time.LocalDateTime;
import java.util.Date;

@Table(tableName = "EMPLOYEE")
public class EmployeeEntity extends BaseEntity {
    @Column(columnName = "ID")
    private String id;
    @Column(columnName = "USERNAME")
    private String username;
    @Column(columnName = "PASSWORD")
    private String password;
    @Column(columnName = "FIRST_NAME")
    private String firstName;
    @Column(columnName = "LAST_NAME")
    private String lastName;
    @Column(columnName = "EMAIL")
    private String email;
    @Column(columnName = "GENDER")
    private Gender gender;
    @Column(columnName = "DEPARTMENT")
    private String department;
    @Column(columnName = "BIRTHDAY")
    private Date birthday;
    @Column(columnName = "STARTED_WORK_AT")
    private Date startedWorkAt;
    @Column(columnName = "LEAVE_WORK_AT")
    private Date leaveWorkAt;
    @Column(columnName = "ROLE")
    private Role role;

    public EmployeeEntity(){
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getStartedWorkAt() {
        return startedWorkAt;
    }

    public void setStartedWorkAt(Date startedWorkAt) {
        this.startedWorkAt = startedWorkAt;
    }

    public Date getLeaveWorkAt() {
        return leaveWorkAt;
    }

    public void setLeaveWorkAt(Date leaveWorkAt) {
        this.leaveWorkAt = leaveWorkAt;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public static EmployeeEntityBuilder builder() {
        return new EmployeeEntityBuilder();
    }

    public static class EmployeeEntityBuilder {

        private final EmployeeEntity employeeEntity;

        public EmployeeEntityBuilder() {
            this.employeeEntity = new EmployeeEntity();
        }

        public EmployeeEntity build() {
            return this.employeeEntity;
        }

        public EmployeeEntityBuilder id(String id) {
            this.employeeEntity.setId(id);
            return this;
        }

        public EmployeeEntityBuilder username(String username) {
            this.employeeEntity.setUsername(username);
            return this;
        }

        public EmployeeEntityBuilder password(String password) {
            this.employeeEntity.setPassword(password);
            return this;
        }

        public EmployeeEntityBuilder firstName(String firstName) {
            this.employeeEntity.setFirstName(firstName);
            return this;
        }

        public EmployeeEntityBuilder lastName(String lastName) {
            this.employeeEntity.setLastName(lastName);
            return this;
        }

        public EmployeeEntityBuilder email(String email) {
            this.employeeEntity.setEmail(email);
            return this;
        }

        public EmployeeEntityBuilder gender(Gender gender) {
            this.employeeEntity.setGender(gender);
            return this;
        }

        public EmployeeEntityBuilder department(String department) {
            this.employeeEntity.setDepartment(department);
            return this;
        }

        public EmployeeEntityBuilder birthday(Date birthday) {
            this.employeeEntity.setBirthday(birthday);
            return this;
        }

        public EmployeeEntityBuilder startedWorkAt(Date startedWorkAt) {
            this.employeeEntity.setStartedWorkAt(startedWorkAt);
            return this;
        }

        public EmployeeEntityBuilder leaveWorkAt(Date leaveWorkAt) {
            this.employeeEntity.setLeaveWorkAt(leaveWorkAt);
            return this;
        }

        public EmployeeEntityBuilder role(Role role) {
            this.employeeEntity.setRole(role);
            return this;
        }

        public EmployeeEntityBuilder createdAt(LocalDateTime createdAt) {
            this.employeeEntity.setCreatedAt(createdAt);
            return this;
        }

        public EmployeeEntityBuilder updatedAt(LocalDateTime updatedAt) {
            this.employeeEntity.setUpdatedAt(updatedAt);
            return this;
        }

    }

}
