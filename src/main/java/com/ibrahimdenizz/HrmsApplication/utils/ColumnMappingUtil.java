package com.ibrahimdenizz.HrmsApplication.utils;

import com.ibrahimdenizz.HrmsApplication.annotations.Column;

import java.lang.reflect.Field;
import java.util.Map;

public class ColumnMappingUtil {

    public static Map<String, String> get(Class<?> clazz) {
        Field[] fields = clazz.getDeclaredFields();
        Map<String, String> columnMappings = new java.util.HashMap<>(Map.of());
        for (Field field : fields) {
            Column annotation = field.getAnnotation(Column.class);
            if (annotation != null) columnMappings.put(annotation.columnName(), field.getName());
        }
        return columnMappings;
    }

}
