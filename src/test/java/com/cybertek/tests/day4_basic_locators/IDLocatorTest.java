package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IDLocatorTest {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        WebElement dontClickButton = driver.findElement(By.id("disappearing_button"));
        dontClickButton.click();

        if(driver.findElement(By.id("result")).getText().equals("Now it's gone!")){
            System.out.println("actual message = " + driver.findElement(By.id("result")).getText());
            System.out.println("PASS");
        }else{
            System.out.println("actual message = " + driver.findElement(By.id("result")).getText());
            System.out.println("FAIL");
        }

        driver.quit();
    }
}
