package com.company;

import java.util.Random;

public class Util {
    public static int[] arr = new int[10];

    public static void genArr(int a) {
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(a);
        }

    }
}
