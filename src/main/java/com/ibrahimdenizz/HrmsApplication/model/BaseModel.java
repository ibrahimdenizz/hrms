package com.ibrahimdenizz.HrmsApplication.model;

import com.ibrahimdenizz.HrmsApplication.model.entity.BaseEntity;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseModel {

    public ArrayList<Field> getFields() {
        Class<?> clazz = this.getClass();
        Field[] childFields = clazz.getDeclaredFields();
        Field[] parentFields = clazz.getSuperclass().getDeclaredFields();
        ArrayList<Field> fields = new ArrayList<>(List.of(childFields));
        fields.addAll(List.of(parentFields));

        return fields;
    }

    public Field getField(String fieldName) {
        Class<?> clazz = this.getClass();
        try {
            return clazz.getDeclaredField(fieldName);
        } catch (NoSuchFieldException e) {
            try {
                return clazz.getSuperclass().getDeclaredField(fieldName);
            } catch (NoSuchFieldException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    @Override
    public String toString() {
        ArrayList<Field> fields = this.getFields();
        ArrayList<String> fieldPrints = new ArrayList<>();

        for (Field field : fields) {
            try {
                String fieldName = field.getName();
                String fieldValueMethodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
                Object fieldValue = this.getClass().getMethod(fieldValueMethodName).invoke(this);
                String fieldPrint = "\t" +fieldName + "='" + fieldValue + "'";
                fieldPrints.add(fieldPrint);
            } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }

        return this.getClass().getName() + "{\n" + String.join(",\n", fieldPrints) + "\n}";
    }
}
