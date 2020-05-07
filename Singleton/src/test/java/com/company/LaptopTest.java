package com.company;

import org.junit.jupiter.api.*;

/**
 * @author nikita
 */
public class LaptopTest {

    public LaptopTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testUse() {
        System.out.println("use");
        Laptop instance = new Laptop("Test");
        instance.use("test");

    }

}
