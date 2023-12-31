package com.ibrahimdenizz.HrmsApplication.modules.employee.model.entity;

import com.ibrahimdenizz.HrmsApplication.annotations.Column;
import com.ibrahimdenizz.HrmsApplication.modules.employee.model.enums.Gender;
import com.ibrahimdenizz.HrmsApplication.modules.employee.model.enums.Role;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class EmployeeEntity {
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
    private LocalDate birthday;
    @Column(columnName = "STARTED_WORK_AT")
    private LocalDate startedWorkAt;
    @Column(columnName = "LEAVE_WORK_AT")
    private LocalDate leaveWorkAt;
    @Column(columnName = "ROLE")
    private Role role;
    @Column(columnName = "CREATED_AT")
    private LocalDateTime createdAt;
    @Column(columnName = "UPDATED_AT")
    private LocalDateTime updatedAt;


    public EmployeeEntity() {
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

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public LocalDate getStartedWorkAt() {
        return startedWorkAt;
    }

    public void setStartedWorkAt(LocalDate startedWorkAt) {
        this.startedWorkAt = startedWorkAt;
    }

    public LocalDate getLeaveWorkAt() {
        return leaveWorkAt;
    }

    public void setLeaveWorkAt(LocalDate leaveWorkAt) {
        this.leaveWorkAt = leaveWorkAt;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
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
            this.employeeEntity.id = id;
            return this;
        }

        public EmployeeEntityBuilder username(String username) {
            this.employeeEntity.username = username;
            return this;
        }

        public EmployeeEntityBuilder password(String password) {
            this.employeeEntity.password = password;
            return this;
        }

        public EmployeeEntityBuilder firstName(String firstName) {
            this.employeeEntity.firstName = firstName;
            return this;
        }

        public EmployeeEntityBuilder lastName(String lastName) {
            this.employeeEntity.lastName = lastName;
            return this;
        }

        public EmployeeEntityBuilder email(String email) {
            this.employeeEntity.email = email;
            return this;
        }

        public EmployeeEntityBuilder gender(Gender gender) {
            this.employeeEntity.gender = gender;
            return this;
        }

        public EmployeeEntityBuilder department(String department) {
            this.employeeEntity.department = department;
            return this;
        }

        public EmployeeEntityBuilder birthday(LocalDate birthday) {
            this.employeeEntity.birthday = birthday;
            return this;
        }

        public EmployeeEntityBuilder startedWorkAt(LocalDate startedWorkAt) {
            this.employeeEntity.startedWorkAt = startedWorkAt;
            return this;
        }

        public EmployeeEntityBuilder leaveWorkAt(LocalDate leaveWorkAt) {
            this.employeeEntity.leaveWorkAt = leaveWorkAt;
            return this;
        }

        public EmployeeEntityBuilder role(Role role) {
            this.employeeEntity.role = role;
            return this;
        }

        public EmployeeEntityBuilder createdAt(LocalDateTime createdAt) {
            this.employeeEntity.createdAt = createdAt;
            return this;
        }

        public EmployeeEntityBuilder updatedAt(LocalDateTime updatedAt) {
            this.employeeEntity.updatedAt = updatedAt;
            return this;
        }

    }

}
