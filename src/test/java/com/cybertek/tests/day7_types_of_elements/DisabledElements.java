package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisabledElements {

    @Test
    public void test1() throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/radio_buttons");

        WebElement greenRadioButton = driver.findElement(By.id("green"));

        //how to check any WebElement is enable or not?

        System.out.println("greenRadioButton.isEnabled() = " + greenRadioButton.isEnabled());

        Assert.assertFalse(greenRadioButton.isEnabled(),"verify that green radio button is NOT enabled");
        greenRadioButton.click();

        Thread.sleep(2000);
        driver.quit();

    }

    @Test
    public void test2(){

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/dynamic_controls");

        WebElement inputBox = driver.findElement(By.cssSelector("#input-example>input"));
        inputBox.click();

        inputBox.sendKeys("message");



    }
}
