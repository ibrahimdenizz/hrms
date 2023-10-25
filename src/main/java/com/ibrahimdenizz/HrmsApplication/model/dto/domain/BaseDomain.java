package com.ibrahimdenizz.HrmsApplication.model.dto.domain;

import com.ibrahimdenizz.HrmsApplication.model.BaseModel;

import java.time.LocalDateTime;

public abstract class BaseDomain extends BaseModel {
    protected LocalDateTime createdAt;
    protected LocalDateTime updatedAt;

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
