package Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ReflectionHelpClass {

    public static Field[] getFieldsWithAnnotation(Class clazz, Class annotation) {
        int ArrayLength = 0;
        Field[] fieldsOfClazz = clazz.getDeclaredFields();
        Field[] fields = new Field[5];

        for (Field field : fieldsOfClazz) {
            if (field.getDeclaredAnnotations().length == 1 && field.getDeclaredAnnotations()[0].annotationType().equals(annotation)) {

                fields[ArrayLength++] = field;
                if (ArrayLength == fields.length) {
                    fields = Arrays.copyOf(fields, fields.length * 2);
                }
            }
        }
        fields = Arrays.copyOf(fields, ArrayLength);

        return fields;
    }

    public static HashMap<String, String> getPKWithValue(Object cl, Class annotation) throws IllegalAccessException {
        Field[] fields = cl.getClass().getFields();
        HashMap<String, String> PK = new HashMap<>();
        int i = 0;
        for (Field field : fields) {
            if (field.getDeclaredAnnotations().length == 1 && field.getDeclaredAnnotations()[0].annotationType().equals(annotation)) {
                PK.put(field.getName(), fields[i++].get(cl).toString());
            }
        }
        return PK;
    }

    public static HashMap<String, String> getResult(Object cl) throws IllegalAccessException {
        Field[] fields = cl.getClass().getFields();
        int i = 0;
        HashMap<String, String> objectData = new HashMap<>();
        for (Field field : fields) {
            objectData.put(field.getName(), fields[i++].get(cl).toString());

        }
        return objectData;
    }

    public static List<Field> getFields(Class object) {
        List<Field> data = new ArrayList<>(Arrays.asList(object.getDeclaredFields()));
        return data;
    }

    public static <T> T instantiate(Class<T> type, Object... args) {

        try {
            Class<?>[] classes = Arrays.stream(args).map(Object::getClass).toArray(Class<?>[]::new);

            return type.getDeclaredConstructor(classes).newInstance(args);

        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static String getName(Class object) {
        return object.getSimpleName();
    }


}
