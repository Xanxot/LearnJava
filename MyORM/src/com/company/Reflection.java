package com.company;

import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.util.HashMap;

public class Reflection {
    private final HashMap<String, String> objectData = new HashMap<>();

    public Reflection(Object cl) throws Exception {
        boolean id = false;
        Field[] fields = cl.getClass().getFields();
        for (Field field : fields) {
            objectData.put(field.getName(), field.get(cl).toString());
            if (field.getDeclaredAnnotations().length == 1 && field.getDeclaredAnnotations()[0].annotationType().equals(id.class)) {
                id = true;
            }
        }
        if (!id) {
            throw new Exception(new IdException("В классе " + cl.getClass().getSimpleName() + " отсутствует @id"));
        }
    }

    public HashMap<String, String> getResult() {
        return objectData;
    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface id {
}