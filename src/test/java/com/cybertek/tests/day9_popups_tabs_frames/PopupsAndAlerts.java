package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PopupsAndAlerts {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        //Thread.sleep(2000);
        //driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {

        driver.get("https://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml");
        //
        driver.findElement(By.xpath("//button[.='Destroy the World']")).click();

        driver.findElement(By.xpath("//button[.='No']")).click();

    }

    @Test
    public void test2() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        driver.findElement(By.xpath("//button[1]")).click();

        //switch to JS alert pop up
        Alert alert = driver.switchTo().alert();
        Thread.sleep(2000);
        alert.accept();

        driver.findElement(By.xpath("//button[2]")).click();
        Thread.sleep(2000);
        alert.dismiss();

        driver.findElement(By.xpath("//button[3]")).click();
        Thread.sleep(2000);
        alert.sendKeys("mike smith");
        Thread.sleep(2000);
        alert.accept();

    }

}
