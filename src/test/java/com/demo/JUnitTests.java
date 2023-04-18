package com.demo;

import org.junit.jupiter.api.*;

public class JUnitTests {

    @BeforeAll
    static void beforeAll(){
        System.out.println("   beforeAll()");
    }



    @BeforeEach
    void beforeEach() {
        System.out.println("     beforeEach()");
    }

    @Test
    void oneTest(){
        Assertions.assertTrue(10>9);
        System.out.println("       oneTest()");
    }

    @Test
    void secondTest(){
        Assertions.assertTrue(10>9);
        System.out.println("       secondTest()");
    }
    @AfterEach
    void afterEach(){
        System.out.println("     afterEach");
    }

}
