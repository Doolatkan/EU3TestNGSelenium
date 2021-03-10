package com.cybertek.tests.day12_properties_driver_tests;

public class Singleton {

    private static String str;

    public static String getInstance(){

        //if str has no value, initialize it and return it
        if(str==null){
            System.out.println("str is null. assigning value it");
            str="somevalue";
        }else{
            //if it has value just return it
            System.out.println("it has value, just returning it");
        }

        return str;
    }



}
