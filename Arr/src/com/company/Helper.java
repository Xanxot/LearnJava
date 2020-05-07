package com.company;

import java.util.Random;
import java.util.Arrays;

public class Helper {

    public static int n = 10;

    public static int[] arr = new int[n];


    public static void rand(int a) {

        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(a);
        }
        System.out.println();

    }


    public static void print(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(" " + a[i] + " ");
        }
    }

    public static void roll(int[] a) {
        int[] c = new int[a.length];
        System.arraycopy(a, 0, c, 0, a.length);
        int j = a.length;
        a.clone();
        for (int i = 0; i < a.length; i++) {
            j--;
            a[i] = c[j];
        }
        System.out.println(" ");
        print(a);
    }


    public static void minvalue(int[] a) {
        Arrays.sort(a);
        System.out.println("\nМинимальное значение: " + a[0]);

    }

    public static void maxvalue(int[] a) {
        Arrays.sort(a);
        System.out.println("\nМаксимальное значение: " + a[a.length - 1]);

    }

    public static void addArr(int[] a, int[] b) {
        n = a.length + b.length;
        int c = a.length;
        int[] temp = new int[n];
        System.arraycopy(a, 0, temp, 0, a.length);

        for (int i = 0; i < b.length; i++) {
            temp[c] = b[i];
            c++;
        }
        for (int i = 0; i < n; i++) {
            System.out.print(temp[i] + " ");
        }
        System.out.println();


    }

    public static void sortArr(int[] a) {
        Arrays.sort(a);
    }

    public static void change(int[] a, int b, int c) {
        a[b] = c;

    }


}

