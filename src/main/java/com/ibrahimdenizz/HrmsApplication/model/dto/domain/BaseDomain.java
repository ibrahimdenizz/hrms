package com.ibrahimdenizz.HrmsApplication.model.dto.domain;

import com.ibrahimdenizz.HrmsApplication.model.BaseModel;
import com.ibrahimdenizz.HrmsApplication.model.entity.BaseEntity;
import com.ibrahimdenizz.HrmsApplication.modules.employee.model.entity.EmployeeEntity;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseDomain extends BaseModel {
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

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

}
