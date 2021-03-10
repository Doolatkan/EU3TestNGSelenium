package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class tagNameLocator {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        //maximaz the window
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/sign_up");

        driver.findElement(By.tagName("input")).sendKeys("Mike Smith");

        driver.findElement(By.name("email")).sendKeys("mike@smith.com");

        Thread.sleep(1000);

        driver.findElement(By.tagName("button")).click();

        Thread.sleep(2000);

        driver.quit();


    }
}
