package com.company;

public class TestClass {
    @Before
    public void before() {
        System.out.println("Сработал Before");
    }

    @Test
    public void test() {
        System.out.println("Сработал Test");
    }

    @Test
    public void test1() {
        System.out.println("Сработал Test1");
    }

    @Test
    public void test4() {
        throw new UnsupportedOperationException();
    }

    @Test
    public void test2() {
        throw new IllegalCallerException();
    }

    public void test3() {
        System.out.println("Сработал метод без аннотации");
    }

    @After
    public void after() {
        System.out.println("Сработал After");
    }

}
