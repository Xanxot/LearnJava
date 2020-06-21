package com.company;
import java.lang.Integer;


import java.util.Arrays;
import java.util.List;

public class Array<T> {
    private T[] value;
    private int size;

    public Array(T[] value) {
        this.value = value;
    }

    public Array() {

    }


    public T getValue(int index) {
        return value[index];
    }

    public void addElement(T element) {
        

    }

    public void deleteElement(int index) {
        size = value.length;

        for (int i = index; i < value.length - 1; i++) {

            value[i] = value[i + 1];
        }
        value = Arrays.copyOf(value, size - 1);
    }

    public void printArray() {
        for (int i = 0; i < value.length; i++) {
            System.out.print(value[i] + " ");
        }
        System.out.println();
    }

    public void setElement(int index, T element) {
        value[index] = element;
    }

    public void sortArray() {
        Arrays.sort(value);
    }

    public int getSize() {
        return value.length;
    }


}

