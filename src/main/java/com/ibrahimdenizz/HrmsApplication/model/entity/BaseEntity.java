package com.ibrahimdenizz.HrmsApplication.model.entity;

import com.ibrahimdenizz.HrmsApplication.annotations.Column;
import com.ibrahimdenizz.HrmsApplication.annotations.Table;
import com.ibrahimdenizz.HrmsApplication.model.BaseModel;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseEntity extends BaseModel {

    @Column(columnName = "CREATED_AT")
    private LocalDateTime createdAt;
    @Column(columnName = "UPDATED_AT")
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

    public String getColumnName(String fieldName) {
        Field field = this.getField(fieldName);
        Column annotation = field.getAnnotation(Column.class);
        return annotation.columnName();
    }

    public List<String> getColumnNames() {
        ArrayList<Field> fields = this.getFields();
        ArrayList<String> columns = new ArrayList<String>();
        for (Field field : fields) {
            Column annotation = field.getAnnotation(Column.class);
            if (annotation != null) columns.add(annotation.columnName());
        }
        return columns;
    }

    public String getSqlColumns() {
        return String.join(", ", this.getColumnNames());
    }


    public ArrayList<String> getColumnParams() {
        ArrayList<Field> fields = this.getFields();
        ArrayList<String> columnParams = new ArrayList<String>();

        for (Field field : fields) {
            String columnParam = ":" + field.getName();
            columnParams.add(columnParam);
        }

        return columnParams;
    }

    public String getSqlColumnParams() {
        return String.join(", ", this.getColumnParams());
    }

    public String getTableName() {
        Table annotation = this.getClass().getAnnotation(Table.class);
        return annotation.tableName();
    }

    public String getInsertQuery() {
        return "INSERT INTO " +
                this.getTableName() +
                " (" + this.getSqlColumns() + ") " +
                "VALUES (" + this.getSqlColumnParams() + ")";
    }

}
