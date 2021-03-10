package com.cybertek.tests.day1_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OpenBrowser {

    public static void main(String[] args) {

        //we have to enter this line every time we want to open chrome
        WebDriverManager.chromedriver().setup();

        //creating object driver from ChromeDriver() wich is come from selenium
        WebDriver driver = new ChromeDriver();

        driver.get("https://cybertekschool.com");

        WebDriverManager.firefoxdriver().setup();
        WebDriver dr = new FirefoxDriver();
        dr.get("https://facebook.com");
    }

}
