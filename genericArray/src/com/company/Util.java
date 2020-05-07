package com.company;
import java.util.Random;
public class Util {
    public static Integer[] arr =new Integer[10];
    public static void genArr(int a){
        Random random = new Random();
        for (int i=0; i<arr.length; i++){
            arr[i]=random.nextInt(a);
        }

    }
}
