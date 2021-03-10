package com.cybertek.tests.day7_testng;

import org.testng.annotations.*;

public class BeforeAfterMethod {

    @BeforeClass

    public void setUpClass(){
        System.out.println("-----Before Class-----");
        System.out.println("execute one time before class");

    }

    @Test

    public void test1(){

        System.out.println("First Test Case");

    }

    @Ignore
    @Test

    public void test2(){
        System.out.println("Second Test Case");
    }

    @Test

    public void test3(){
        System.out.println("Third Test Case");
    }

    @BeforeMethod
    public void setUp(){
        System.out.println("Before Method");
        System.out.println("WebDriver, opening browser");
    }

    @AfterMethod

    public void tearDown(){
        System.out.println("After Method");
        System.out.println("WebDriver, closing browser");
    }

    @AfterClass

    public void tearnDownClass(){
        System.out.println("-----After Class------");
        System.out.println("Some reporting code here");
    }

}


