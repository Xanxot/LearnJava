package com.company;

import org.apache.commons.lang3.StringUtils;

import java.util.*;


public class MyArrayList<T> implements List<T> {
    T[] arr = (T[]) new Object[10];

    private int count_size;
    private int cursor = 0;
    private int iterator_count = 0;
    private int count;

    @Override
    public int size() {
        return arr.length;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean contains(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<T> iterator() {

        return new Itr();
    }


    @Override
    public boolean add(T element) {
        this.count = arr.length;
        if (count <= count_size) {
            arr = Arrays.copyOf(arr, size() * 2);
        }
        arr[count_size] = element;

        count_size++;
        return size() == count + 1;


    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(arr, arr.length);

    }

    @Override
    public <T1> T1[] toArray(T1[] c) {

        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {

        Object[] temp = c.toArray();
        this.count = arr.length;
        int startSize = count_size;
        int cCount = 0;

        for (int g = 0; g < c.size(); g++) {
            if (temp[g] != null) {
                cCount++;
            }

        }

        int math = 0;

        if (c.size() + count_size >= arr.length) {

            this.count = cCount + count_size;
            do {

                math++;
            } while ((c.size() + count_size) >= (arr.length * math));


            arr = Arrays.copyOf(arr, arr.length * math);


        }


        this.count_size = this.count_size + cCount;
        Iterator iterator = c.iterator();


        for (int i = startSize; i < count_size; i++) {
            arr[i] = (T) iterator.next();
        }


        return true;

    }


    @Override
    public boolean addAll(int i, Collection<? extends T> collection) {
        throw new UnsupportedOperationException();

    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {

        return StringUtils.join(arr, " ");

    }

    @Override
    public T get(int index) {
        return (T) arr[index];
    }

    @Override
    public T set(int index, T element) {
        if (index <= count_size) {
            arr[index] = element;
            return arr[index];
        } else throw new IndexOutOfBoundsException();

    }

    @Override
    public void add(int i, T t) {
        if (i <= count_size) {
            T[] temp = this.arr;
            if (size() <= arr.length) {
                arr = Arrays.copyOf(arr, arr.length * 2);
            }

            for (int a = i; a <= count_size; a++) {
                arr[a] = temp[a - 1];

            }
            arr[i] = t;
            count_size++;
        } else throw new IndexOutOfBoundsException();

    }

    @Override
    public T remove(int index) {

        for (int i = index; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }

        return arr[index];
    }

    @Override
    public int indexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException();
    }


    @Override
    public ListIterator<T> listIterator() {
        final int[] index = {0};
        final int[] count = {0};

        return new ListIterator<T>() {
            @Override
            public boolean hasNext() {
                return arr[count[0]] != null;

            }

            @Override
            public T next() {

                return (T) arr[count[0]++];
            }

            @Override
            public boolean hasPrevious() {
                throw new UnsupportedOperationException();
            }

            @Override
            public T previous() {
                throw new UnsupportedOperationException();
            }

            @Override
            public int nextIndex() {
                throw new UnsupportedOperationException();
            }

            @Override
            public int previousIndex() {
                throw new UnsupportedOperationException();
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }

            @Override
            public void set(T t) {


                MyArrayList.this.arr[index[0]++] = t;

            }

            @Override
            public void add(T t) {
                throw new UnsupportedOperationException();
            }
        };

    }

    @Override
    public ListIterator<T> listIterator(int i) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<T> subList(int i, int i1) {
        throw new UnsupportedOperationException();
    }


    public void sort(Comparator<? super T> c) {

        Arrays.sort(arr, 0, count_size, c);
    }


    private class Itr<E> implements Iterator<E> {


        @Override
        public boolean hasNext() {

            return MyArrayList.this.cursor != size() - 1;
        }

        @Override
        public E next() {

            int i = iterator_count;


            T[] elementData = arr;

            if (i >= elementData.length)
                throw new ConcurrentModificationException();
            iterator_count = i + 1;

            return (E) elementData[i];


        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}