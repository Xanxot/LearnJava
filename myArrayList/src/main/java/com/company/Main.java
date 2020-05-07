package com.company;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static <T> void main(String[] args) {
        List<Integer> arrayList = new MyArrayList<>();
        List<Integer> arrayList1 = new MyArrayList<>();
        Collections.addAll(arrayList, 1, 2, 3, 4, 5);
        Collections.addAll(arrayList1, 20, 21, 22);
        for (int i = 0; i < 100000; i++) {
            arrayList.add(i);
            arrayList1.add(i + 2);
        }
        //System.out.println(arrayList.toString());
        // System.out.println(arrayList1.toString());
        System.out.println("----------------------------------------------");

        System.out.println("Copy");
        Collections.copy(arrayList, arrayList1);
        //System.out.println(arrayList);
        // System.out.println(arrayList1);

        System.out.println("Sort");
        Collections.sort(arrayList1, Comparator.reverseOrder());
        System.out.println(arrayList1);
//

    }
}
