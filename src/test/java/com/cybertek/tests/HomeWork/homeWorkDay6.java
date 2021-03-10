package com.cybertek.tests.HomeWork;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class homeWorkDay6 {

   WebDriver driver;

    @BeforeMethod
    public void openbrowser(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }

    @Test
    public void test1(){

        driver.get("https://www.ebay.com");
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("term");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        String result = driver.findElement(By.xpath("//h1[@class='srp-controls__count-heading']")).getText();
        System.out.println("result = " + result);
    }

    @Test
    public void test2(){
        driver.get("https://www.ebay.com");
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("selenium");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        Assert.assertTrue(driver.getTitle().contains("selenium1"),"verify that title contains selenium");

    }

    @Test
    public void test3() throws InterruptedException {


        driver.get("https://www.wikipedia.org");

        driver.findElement(By.cssSelector("[name='search']")).sendKeys("selenium webdriver");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("i.sprite.svg-search-icon")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Selenium (software)")).click();

        Assert.assertTrue(driver.getCurrentUrl().contains("Selenium_(software)"),"verify that url ends with Selenium_(software)");

    }

    @Test
    public void test4() throws InterruptedException {

       driver.get("http://practice.cybertekschool.com/forgot_password");

       WebElement homeButton = driver.findElement(By.xpath("//a[@class='nav-link']"));
       WebElement forgetPassword = driver.findElement(By.xpath("//h2"));
       WebElement emailTest = driver.findElement(By.xpath("//label[@for='email']"));
       WebElement emailInputBox = driver.findElement(By.xpath("//input[@name='email']"));
       WebElement retrievePassword = driver.findElement(By.xpath("//button[@id='form_submit']"));


        System.out.println("homeButton = " + homeButton);
        System.out.println("forgetPassword = " + forgetPassword);
        System.out.println("emailTest = " + emailTest);
        System.out.println("emailInputBox = " + emailInputBox);

        emailInputBox.sendKeys("mike_smith@cybertek.com");
        Thread.sleep(2000);
        retrievePassword.click();

    }


}
