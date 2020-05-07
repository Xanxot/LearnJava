package com.company;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.annotation.*;
import java.util.Arrays;

public class xUnit {
    public static void startTest(Object o, Class c) throws InvocationTargetException, IllegalAccessException {
        int test_count = 0;
        int annotation_count = 0;
        int count = 0;
        int t_count = 0;
        Method[] methods = c.getDeclaredMethods();
        Annotation[] annotations = new Annotation[0];
        Method[] tests = new Method[0];
        Method before = null;
        Method after = null;

        for (Method method : methods) {
            if (method.getDeclaredAnnotations().length != 0) {
                annotation_count++;
                if (method.getDeclaredAnnotations()[0].annotationType().equals(Test.class)) {
                    test_count++;
                }
                if (method.getDeclaredAnnotations()[0].annotationType().equals(After.class)) {
                    after = method;
                }
                if (method.getDeclaredAnnotations()[0].annotationType().equals(Before.class)) {
                    before = method;
                }

            }
        }
        tests = Arrays.copyOf(tests, test_count);
        annotations = Arrays.copyOf(annotations, annotation_count);
        for (Method method : methods) {
            if (method.getDeclaredAnnotations().length != 0) {
                annotations[count++] = method.getDeclaredAnnotations()[0];
                if (method.getDeclaredAnnotations()[0].annotationType().equals(Test.class)) {
                    tests[t_count++] = method;
                }


            }

        }

        for (Method test : tests) {

            try {
                assert before != null;
                before.invoke(o);
            } catch (InvocationTargetException e) {
                System.out.println(e.getTargetException().toString());
            }
            try {
                test.invoke(o);
            } catch (InvocationTargetException e) {
                System.out.println(e.getTargetException().toString());
            }
            try {
                assert after != null;
                after.invoke(o);
            } catch (InvocationTargetException e) {
                System.out.println(e.getTargetException().toString());
            }


        }


    }


}


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Test {

}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Before {

}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface After {
}
