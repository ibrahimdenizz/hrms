package com.ibrahimdenizz.HrmsApplication.modules.leave.model.domain;

import com.ibrahimdenizz.HrmsApplication.modules.employee.model.enums.Gender;
import com.ibrahimdenizz.HrmsApplication.modules.leave.model.entity.LeaveTypeEntity;

public class LeaveType {

    private String id;
    private String name;
    private Integer maxDays;
    private Gender gender;

    public LeaveType() {
    }

    public static LeaveType fromEntity(LeaveTypeEntity entity) {
        return LeaveType.builder()
                .id(entity.getId())
                .name(entity.getName())
                .maxDays(entity.getMaxDays())
                .gender(entity.getGender())
                .build();
    }

    public LeaveTypeEntity toEntity() {
        return LeaveTypeEntity.builder()
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

    public static LeaveTypeBuilder builder() {
        return new LeaveTypeBuilder();
    }

    public static class LeaveTypeBuilder {

        private final LeaveType leaveType;

        public LeaveTypeBuilder() {
            this.leaveType = new LeaveType();
        }

        public LeaveType build() {
            return this.leaveType;
        }

        public LeaveTypeBuilder id(String id) {
            this.leaveType.id = id;
            return this;
        }

        public LeaveTypeBuilder name(String name) {
            this.leaveType.name = name;
            return this;
        }

        public LeaveTypeBuilder maxDays(Integer maxDays) {
            this.leaveType.maxDays = maxDays;
            return this;
        }

        public LeaveTypeBuilder gender(Gender gender) {
            this.leaveType.gender = gender;
            return this;
        }

    }

}
