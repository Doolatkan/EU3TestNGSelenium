package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class classNameTest {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/sign_up");

        driver.findElement(By.className("nav-link")).click();

        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        System.out.println(driver.findElement(By.className("h3")).getText());


    }
}
