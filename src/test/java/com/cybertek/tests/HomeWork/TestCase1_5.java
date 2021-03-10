package com.cybertek.tests.HomeWork;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class TestCase1_5 {

    WebDriver driver;

    @BeforeMethod
    public void openBrowser(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(2000);
        //driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {
        driver.get("https://practice-cybertekschool.herokuapp.com");
        WebElement registration_form = driver.findElement(By.linkText("Registration Form"));
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        Thread.sleep(2000);
        jse.executeScript("arguments[0].scrollIntoView(true);", registration_form);
        Thread.sleep(2000);
        registration_form.click();
        driver.findElement(By.cssSelector("[name='birthday']")).sendKeys("wrong_dob");
        Assert.assertTrue(driver.findElement(By.xpath("//*[.='The date of birth is not valid']")).isDisplayed());
    }

    @Test
    public void test2() throws InterruptedException {
        driver.get("https://practice-cybertekschool.herokuapp.com");
        WebElement registration_form = driver.findElement(By.linkText("Registration Form"));
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click();", registration_form);
        List<WebElement> elements = driver.findElements(By.cssSelector("div.form-check.form-check-inline"));

        for (WebElement element : elements) {
            Assert.assertTrue(element.isDisplayed());
        }

    }

    @Test
    public void test3() throws InterruptedException {
        driver.get("https://practice-cybertekschool.herokuapp.com");
        WebElement registration_form = driver.findElement(By.linkText("Registration Form"));
        Thread.sleep(2000);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].scrollIntoView(true);",registration_form);
        Thread.sleep(2000);
        registration_form.click();
        driver.findElement(By.name("firstname")).sendKeys("o");
        WebElement warningMessage = driver.findElement(By.cssSelector("[data-bv-validator='stringLength']"));
        Assert.assertTrue(warningMessage.isDisplayed(),"verify warning message is displayed");
    }

    @Test
    public void test4(){
        driver.get("https://practice-cybertekschool.herokuapp.com");
        WebElement registration_form = driver.findElement(By.linkText("Registration Form"));
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click();",registration_form);
        driver.findElement(By.name("lastname")).sendKeys("o");
        WebElement warningMessage = driver.findElement(By.cssSelector("i.form-control-feedback.glyphicon.glyphicon-remove"));
        Assert.assertTrue(warningMessage.isDisplayed(),"verify warning message is displayed");
    }

    @Test
    public void test5() throws InterruptedException {
        driver.get("https://practice-cybertekschool.herokuapp.com");
        Thread.sleep(1000);
        WebElement registration_form = driver.findElement(By.linkText("Registration Form"));
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click();",registration_form);
        Thread.sleep(1000);
        driver.findElement(By.name("firstname")).sendKeys("Mike");
        Thread.sleep(1000);
        driver.findElement(By.name("lastname")).sendKeys("Smith");
        Thread.sleep(1000);
        driver.findElement(By.name("username")).sendKeys("Mike8888");
        Thread.sleep(1000);
        driver.findElement(By.name("email")).sendKeys("mike@smith.com");
        Thread.sleep(1000);
        driver.findElement(By.name("password")).sendKeys("mike1888smith");
        Thread.sleep(1000);
        driver.findElement(By.name("phone")).sendKeys("113-123-4563");
        Thread.sleep(1000);
        driver.findElements(By.cssSelector("[type='radio']")).get(0).click();
        Thread.sleep(1000);
        driver.findElement(By.name("birthday")).sendKeys("11/11/1991");
        Thread.sleep(1000);

        WebElement department = driver.findElement(By.name("department"));
        Select selectDepartment = new Select(department);
        selectDepartment.selectByValue("AO");
        Thread.sleep(1000);

        WebElement jobTitle = driver.findElement(By.name("job_title"));
        Select selectJobTitle = new Select(jobTitle);
        selectJobTitle.selectByVisibleText("SDET");
        Thread.sleep(1000);

        List<WebElement> languages = driver.findElements(By.className("form-check-input"));
        for (WebElement language : languages) {
            language.click();
        }
        Thread.sleep(2000);

        driver.findElement(By.cssSelector("#wooden_spoon")).click();
    }






}
