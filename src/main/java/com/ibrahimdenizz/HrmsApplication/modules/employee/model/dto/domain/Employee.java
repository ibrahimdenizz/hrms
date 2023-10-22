package com.ibrahimdenizz.HrmsApplication.modules.employee.model.dto.domain;

import com.ibrahimdenizz.HrmsApplication.model.dto.domain.BaseDomain;
import com.ibrahimdenizz.HrmsApplication.modules.employee.model.entity.EmployeeEntity;
import com.ibrahimdenizz.HrmsApplication.modules.employee.model.enums.Gender;
import com.ibrahimdenizz.HrmsApplication.modules.employee.model.enums.Role;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Random;

public class Employee extends BaseDomain {

    private String id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private Gender gender;
    private String department;
    private Date birthday;
    private Date startedWorkAt;
    private Date leaveWorkAt;
    private Role role;

    public Employee() {
    }

    public static Employee fromEntity(EmployeeEntity entity) {
        return Employee.builder()
                .id(entity.getId())
                .username(entity.getUsername())
                .password(entity.getPassword())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .email(entity.getEmail())
                .gender(entity.getGender())
                .department(entity.getDepartment())
                .birthday(entity.getBirthday())
                .startedWorkAt(entity.getStartedWorkAt())
                .leaveWorkAt(entity.getLeaveWorkAt())
                .role(entity.getRole())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }

    public EmployeeEntity toEntity() {
        return EmployeeEntity.builder()
                .id(this.getId())
                .username(this.getUsername())
                .password(this.getPassword())
                .firstName(this.getFirstName())
                .lastName(this.getLastName())
                .email(this.getEmail())
                .gender(this.getGender())
                .department(this.getDepartment())
                .birthday(this.getBirthday())
                .startedWorkAt(this.getStartedWorkAt())
                .leaveWorkAt(this.getLeaveWorkAt())
                .role(this.getRole())
                .createdAt(super.getCreatedAt())
                .updatedAt(super.getUpdatedAt())
        .build();
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

    public static EmployeeBuilder builder() {
        return new EmployeeBuilder();
    }

    public static class EmployeeBuilder {

        private final Employee employee;

        public EmployeeBuilder() {
            this.employee = new Employee();
        }

        public Employee build() {
            if (this.employee.getUsername() == null) this.initUsername();
            if (this.employee.getPassword() == null) this.initPassword();
            if (this.employee.getCreatedAt() != null) this.employee.setUpdatedAt(LocalDateTime.now());
            if (this.employee.getCreatedAt() == null) this.employee.setCreatedAt(LocalDateTime.now());

            return this.employee;
        }

        public void initUsername() {
            int uniqueSuffix = 1000 + new Random().nextInt(9000);
            String username = this.employee.getFirstName().toLowerCase() + "." + this.employee.getLastName().toLowerCase() + "." + uniqueSuffix;
            this.employee.setUsername(username);
        }

        public void initPassword() {
            int passwordNumber = (int) Math.pow(10, 8) + new Random().nextInt((int) (Math.pow(10, 8) * 9));
            String passwordHex = Integer.toHexString(passwordNumber);
            this.employee.setPassword(passwordHex);
        }

        public EmployeeBuilder id(String id) {
            this.employee.setId(id);
            return this;
        }

        public EmployeeBuilder username(String username) {
            this.employee.setUsername(username);
            return this;
        }

        public EmployeeBuilder password(String password) {
            this.employee.setPassword(password);
            return this;
        }

        public EmployeeBuilder firstName(String firstName) {
            this.employee.setFirstName(firstName);
            return this;
        }

        public EmployeeBuilder lastName(String lastName) {
            this.employee.setLastName(lastName);
            return this;
        }

        public EmployeeBuilder email(String email) {
            this.employee.setEmail(email);
            return this;
        }

        public EmployeeBuilder gender(Gender gender) {
            this.employee.setGender(gender);
            return this;
        }

        public EmployeeBuilder department(String department) {
            this.employee.setDepartment(department);
            return this;
        }

        public EmployeeBuilder birthday(Date birthday) {
            this.employee.setBirthday(birthday);
            return this;
        }

        public EmployeeBuilder startedWorkAt(Date startedWorkAt) {
            this.employee.setStartedWorkAt(startedWorkAt);
            return this;
        }

        public EmployeeBuilder leaveWorkAt(Date leaveWorkAt) {
            this.employee.setLeaveWorkAt(leaveWorkAt);
            return this;
        }

        public EmployeeBuilder role(Role role) {
            this.employee.setRole(role);
            return this;
        }

        public EmployeeBuilder createdAt(LocalDateTime createdAt) {
            this.employee.setCreatedAt(createdAt);
            return this;
        }

        public EmployeeBuilder updatedAt(LocalDateTime updatedAt) {
            this.employee.setUpdatedAt(updatedAt);
            return this;
        }

    }

}
