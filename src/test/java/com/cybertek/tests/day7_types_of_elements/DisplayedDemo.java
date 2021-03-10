package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisplayedDemo {

    @Test
    public void test1() throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");

        WebElement userNameInput = driver.findElement(By.id("username"));


        System.out.println("userNameInput.isDisplayed() = " + userNameInput.isDisplayed());
        Assert.assertFalse(userNameInput.isDisplayed(),"verify that username is NOT isDisplayed");

        if(!userNameInput.isDisplayed()){
            driver.findElement(By.cssSelector("#start>button")).click();
            Thread.sleep(6000);
            Assert.assertTrue(userNameInput.isDisplayed(),"verify username is Displayed");
        }

        userNameInput.sendKeys("Mi");
        Thread.sleep(1000);
        userNameInput.sendKeys("ke");
        Thread.sleep(1000);
        userNameInput.sendKeys(" S");
        Thread.sleep(1000);
        userNameInput.sendKeys("mi");
        Thread.sleep(1000);
        userNameInput.sendKeys("th");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#pwd")).sendKeys("12");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#pwd")).sendKeys("3");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#pwd")).sendKeys("45");
        Thread.sleep(1500);

        if(!driver.findElement(By.cssSelector("div[class='checkbox']>label")).getAttribute("outerHTML").equals(true)){
            driver.findElement(By.cssSelector("div[class='checkbox']>label")).click();
        }
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        Thread.sleep(4000);

        driver.quit();


    }
}
