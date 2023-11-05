package com.ibrahimdenizz.HrmsApplication.modules.leave.model.entity;

import com.ibrahimdenizz.HrmsApplication.annotations.Column;
import com.ibrahimdenizz.HrmsApplication.modules.employee.model.enums.Gender;

public class LeaveTypeEntity {

    @Column(columnName = "ID")
    private String id;
    @Column(columnName = "NAME")
    private String name;
    @Column(columnName = "MAX_DAYS")
    private Integer maxDays;
    @Column(columnName = "GENDER")
    private Gender gender;

    public LeaveTypeEntity() {
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

    public static EmployeeLeaveTypeEntityBuilder builder() {
        return new EmployeeLeaveTypeEntityBuilder();
    }

    public static class EmployeeLeaveTypeEntityBuilder {

        private final LeaveTypeEntity leaveTypeEntity;

        public EmployeeLeaveTypeEntityBuilder() {
            this.leaveTypeEntity = new LeaveTypeEntity();
        }

        public LeaveTypeEntity build() {
            return this.leaveTypeEntity;
        }

        public EmployeeLeaveTypeEntityBuilder id(String id) {
            this.leaveTypeEntity.id = id;
            return this;
        }

        public EmployeeLeaveTypeEntityBuilder name(String name) {
            this.leaveTypeEntity.name = name;
            return this;
        }

        public EmployeeLeaveTypeEntityBuilder maxDays(Integer maxDays) {
            this.leaveTypeEntity.maxDays = maxDays;
            return this;
        }

        public EmployeeLeaveTypeEntityBuilder gender(Gender gender) {
            this.leaveTypeEntity.gender = gender;
            return this;
        }


    }
}
