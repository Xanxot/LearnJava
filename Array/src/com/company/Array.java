package com.company;

import java.util.Arrays;

public class Array {

    private int[] mas;
    private int size;

    public Array(int[] mas) {
        this.mas = mas;
    }

    public Array() {

    }

    public void getArray() {
        for (int i = 0; i < mas.length; i++) {
            System.out.print(" " + mas[i] + " ");
        }
        System.out.println();
    }

    public void sortArray() {
        Arrays.sort(mas);
    }

    public void changeArray(int a, int b) {
        mas[a] = b;

    }

    public void add(int[] a) {
        if (size != mas.length) {
            mas = Arrays.copyOf(mas, mas.length + a.length);
        }
        size = mas.length - a.length;
        for (int i = 0; i < a.length; i++) {
            mas[size++] = a[i];

        }
    }

    public void deleteElement(int a) {
        size = mas.length;

        for (int i = a; i < mas.length - 1; i++) {
            a++;
            mas[i] = mas[i + 1];
        }
        mas = Arrays.copyOf(mas, size - 1);
    }

    public void addElement(int element) {
        if (mas!=null){
            mas = Arrays.copyOf(mas, mas.length + 1);
            mas[mas.length - 1] = element;
        } else {
            mas = new int[1];
            mas[0] = element;
        }


    }


}