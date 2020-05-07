package com.company;


public class Main {

    public static void main(String[] args) {
        Product p1 = new Product("Galaxy a50", 25000, 5);
        Product p2 = new Product("Galaxy a10", 14990, 3);
        Integer b = p1.getPrice();
        Integer v = p2.getPrice();

        UtilClass.num(10);
        UtilClass.fib(10);
        UtilClass.num(15);
        UtilClass.fib(20);

        System.out.println(p1.toString());
        boolean r = b.equals(v);
        System.out.println(r);



    }

}




