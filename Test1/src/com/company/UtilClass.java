package com.company;

public class UtilClass {
    public static void num(int n) {
        if (n < 0) {
            throw new RuntimeException("Значение не может быть отрицательным");
        } else {
            boolean b;
            for (int i = 2; i < n; i++) {
                b = true;
                for (int j = 2; j <= i / j; j++) {
                    if ((i % j) == 0) {
                        b = false;
                        break;
                    }
                }
                if (b)
                    System.out.print(" " + i + " ");
            }
        }

    }

    public static void fib(int c) {
        int a = 0, b = 1, f;
        if (c < 0) {
            throw new RuntimeException("Значение не может быть отрицательным");
        } else {
            if (c == 0) {
                System.out.println();
            } else if (c == 1) {
                System.out.println(a);
            } else
                System.out.print(a + " " + b + " ");
            for (int i = 3; i <= c; i++) {
                f = a + b;
                System.out.print(f + " ");
                a = b;
                b = f;
            }
        }
        System.out.println();
    }

}
