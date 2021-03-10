package com.cybertek.tests.day5_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class xPathLocator {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/multiple_buttons");

       // driver.findElement(By.linkText("Cybertek School")).click();

       WebElement Button2 = driver.findElement(By.xpath("//button[@name='button2']"));

        Button2.click();

        Thread.sleep(2000);

        //driver.quit();



    }
}
