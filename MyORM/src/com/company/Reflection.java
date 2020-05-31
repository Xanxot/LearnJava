package com.company;

import java.lang.reflect.Field;
import java.util.HashMap;

public class Reflection {
    private final HashMap<String, String> objectData = new HashMap<>();
    private final String name;
    private String primaryKey = null;

    public Reflection(Object cl) throws Exception {
        this.name = cl.getClass().getSimpleName();
        int count = 0;
        Field[] fields = cl.getClass().getFields();
        for (Field field : fields) {
            objectData.put(field.getName(), field.get(cl).toString());
            if (field.getDeclaredAnnotations().length == 1 && field.getDeclaredAnnotations()[0].annotationType().equals(id.class)) {
                count++;
                if (count > 1) {
                    throw new Exception(new IdException("В классе " + cl.getClass().getSimpleName() + " @id больше чем 1"));
                }
                primaryKey = field.getName();
            }
        }
        if (primaryKey == null) {
            throw new Exception(new IdException("В классе " + cl.getClass().getSimpleName() + " отсутствует @id"));
        }
    }

    public HashMap<String, String> getResult() {
        return objectData;
    }

    public String getName() {
        return name;
    }

    public String getPrimaryKey() {
        return primaryKey;
    }
}
