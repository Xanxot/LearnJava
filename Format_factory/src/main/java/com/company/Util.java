package com.company;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.function.Supplier;

public class Util {
    private static final int size = 20_000_000;

    public static <T> long mem(Supplier<T> supplier) throws InterruptedException {
        Class<?> test = supplier.get().getClass();
        long mem1 = getMem();
        T[] arr = (T[]) Array.newInstance(test, size);
        long mem2=getMem();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = supplier.get();

        }
        return (getMem() - mem1) / arr.length;
    }

    static long getMemInt() throws InterruptedException {

        long mem1 = getMem();
        int[] arr = new int[size];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        return (getMem() - mem1) / arr.length;
    }

    static long getMemLong() throws InterruptedException {
        long mem1 = getMem();
        long[] arr = new long[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        return (getMem() - mem1) / arr.length;
    }

    static long getMemBoolean() throws InterruptedException {
        long mem1 = getMem();
        boolean[] arr = new boolean[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i % 2 != 0;
        }
        return (getMem() - mem1) / arr.length;
    }

    static long getBool() throws InterruptedException {
        return 0;
    }

    static long getMemChar() throws InterruptedException {
        long mem1 = getMem();
        char[] arr = new char[size];
        Arrays.fill(arr, '/');
        return (getMem() - mem1) / arr.length;
    }

    static long getMemByte() throws InterruptedException {
        long mem1 = getMem();
        byte[] arr = new byte[size];
        Arrays.fill(arr, (byte) 1);
        return (getMem() - mem1) / arr.length;
    }

    static long getMemShort() throws InterruptedException {
        long mem1 = getMem();
        short[] arr = new short[size];
        Arrays.fill(arr, (short) 20);
        return (getMem() - mem1) / arr.length;
    }

    static long getMemFloat() throws InterruptedException {
        long mem1 = getMem();
        float[] arr = new float[size];
        Arrays.fill(arr, (float) 20.22f);
        return (getMem() - mem1) / arr.length;
    }

    static long getMemDouble() throws InterruptedException {
        long mem1 = getMem();
        double[] arr = new double[size];
        Arrays.fill(arr, 2);
        return (getMem() - mem1) / arr.length;
    }

    static <T> long StringObjects(Supplier<T> objectGetter) throws InterruptedException {
        Object[] array = new Object[size];
        long mem1 = getMem();
        for (int i = 0; i < array.length; i++) {
            array[i] = objectGetter.get();
        }

        return (getMem() - mem1) / array.length;
    }

    static long getMemObject(Object val) throws InterruptedException {
        long mem1 = getMem();
        Object[] arr = new Object[size];
        Arrays.fill(arr, val);
        return (getMem() - mem1) / arr.length;
    }

    static long getMemInteger() throws InterruptedException {
        long mem1 = getMem();
        Integer[] arr = new Integer[size];
        Arrays.fill(arr, 2);
        return (getMem() - mem1) / arr.length;
    }


    private static long getMem() throws InterruptedException {
        System.gc();
        Thread.sleep(10);
        Runtime runtime = Runtime.getRuntime();
        return runtime.totalMemory() - runtime.freeMemory();
    }

    public static String getInfo() throws InterruptedException {
        System.gc();
        Thread.sleep(10);
        Runtime runtime = Runtime.getRuntime();
        return ("-----------------------------------------\n" +
                "Busy memory: " + (runtime.totalMemory() - runtime.freeMemory()) + "\nTotal memory: " +
                runtime.totalMemory() + "\nFree memory: " + runtime.freeMemory() + "\nArray length: " + size +
                "\n-----------------------------------------");
    }
}

