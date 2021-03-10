package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AttributeTest {

    @Test
    public void test1() {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/radio_buttons");

        WebElement blueRadioButton = driver.findElement(By.id("blue"));
        WebElement redRadioButton = driver.findElement(By.id("red"));

        System.out.println("blueRadioButton.getAttribute(\"value\") = " + blueRadioButton.getAttribute("value"));
        System.out.println("redRadioButton.getAttribute(\"value\") = " + redRadioButton.getAttribute("value"));

        System.out.println(blueRadioButton.getAttribute("type"));

        System.out.println(blueRadioButton.getAttribute("name"));

        //since checked attribute does not keep any value, it will return true or false based on the condition
        System.out.println(blueRadioButton.getAttribute("checked"));

        System.out.println(blueRadioButton.getAttribute("href"));

        System.out.println(blueRadioButton.getAttribute("outerHTML"));

        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        WebElement button2 = driver.findElement(By.name("button2"));
        System.out.println(button2.getAttribute("outerHTML"));
        String button2Outer = button2.getAttribute("outerHTML");
        Assert.assertTrue(button2Outer.contains("Button 2"));

        System.out.println("innerHTML = " + button2.getAttribute("innerHTML"));

        Assert.assertTrue(button2.getAttribute("innerHTML").startsWith("But"),"verify that button2.getAttribute(\"innerHTML\") is starts with But");

        driver.quit();


    }
}
