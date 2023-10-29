package com.ibrahimdenizz.HrmsApplication.modules.employee_leave.model.dto.domain;

import com.ibrahimdenizz.HrmsApplication.modules.employee.model.enums.Gender;
import com.ibrahimdenizz.HrmsApplication.modules.employee_leave.model.entity.EmployeeLeaveTypeEntity;

public class EmployeeLeaveType {

    private String id;
    private String name;
    private Integer maxDays;
    private Gender gender;

    public EmployeeLeaveType() {
    }

    public static EmployeeLeaveType fromEntity(EmployeeLeaveTypeEntity entity) {
        return EmployeeLeaveType.builder()
                .id(entity.getId())
                .name(entity.getName())
                .maxDays(entity.getMaxDays())
                .gender(entity.getGender())
                .build();
    }

    public EmployeeLeaveTypeEntity toEntity() {
        return EmployeeLeaveTypeEntity.builder()
                .id(this.getId())
                .name(this.getName())
                .maxDays(this.getMaxDays())
                .gender(this.getGender())
                .build();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMaxDays() {
        return maxDays;
    }

    public void setMaxDays(Integer maxDays) {
        this.maxDays = maxDays;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public static EmployeeLeaveTypeBuilder builder() {
        return new EmployeeLeaveTypeBuilder();
    }

    public static class EmployeeLeaveTypeBuilder {

        private final EmployeeLeaveType employeeLeaveType;

        public EmployeeLeaveTypeBuilder() {
            this.employeeLeaveType = new EmployeeLeaveType();
        }

        public EmployeeLeaveType build() {
            return this.employeeLeaveType;
        }

        public EmployeeLeaveTypeBuilder id(String id) {
            this.employeeLeaveType.id = id;
            return this;
        }

        public EmployeeLeaveTypeBuilder name(String name) {
            this.employeeLeaveType.name = name;
            return this;
        }

        public EmployeeLeaveTypeBuilder maxDays(Integer maxDays) {
            this.employeeLeaveType.maxDays = maxDays;
            return this;
        }

        public EmployeeLeaveTypeBuilder gender(Gender gender) {
            this.employeeLeaveType.gender = gender;
            return this;
        }

    }

}
