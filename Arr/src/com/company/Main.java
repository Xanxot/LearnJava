package com.company;

public class Main {

    public static void main(String[] args) {

        Helper.rand(100);    //Генерация массива / a-диапазон чисел в массиве
       /// Helper.print(Helper.arr); //вывод массива
       /// Helper.roll(Helper.arr); //"перевернуть" массив
       /// Helper.maxvalue(Helper.arr); //Максимальное значение массива
       /// Helper.minvalue(Helper.arr); //Минимальное значение массива
       /// Helper.sortArr(Helper.arr); //Метод сортировки массива
       /// Helper.change(Helper.arr, 3, 4567); //Изменение элементов по индексу/1-изменяемый массив 2-индекс 3- на что изменить
       /// Helper.addArr(Helper.arr, new int[]{909, 919, 929, 99}); //Метод добавляющий новые элементы в массив

        Array array=new Array(Helper.arr);
        array.getArray();
        array.deleteElement(3);
        //array.add(new int[]{12});
        array.getArray();


    }
}
