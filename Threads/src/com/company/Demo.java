package com.company;

public class Demo {
    String thread;

    public static void main(String[] args) {
        new Demo().start();
    }

    public void start() {
        Thread thread0 = new Thread(this::worker);
        Thread thread1 = new Thread(this::worker);


        thread0.start();
        thread1.start();

    }

    public void worker() {
        boolean act = true;
        for (int i = 0; true; ) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            if (i == 0) {
                act = true;
            } else if (i == 10) {
                act = false;
            }
            if (act) {
                i++;
            } else {
                i--;
            }
            thread = Thread.currentThread().getName();
            while (thread.equals(Thread.currentThread().getName())) {
            }

        }

    }
}
