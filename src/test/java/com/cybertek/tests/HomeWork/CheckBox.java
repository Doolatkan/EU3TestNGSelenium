package com.cybertek.tests.HomeWork;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class CheckBox {

    WebDriver driver;

    @BeforeMethod
    public void openBrowser(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void closeBrowser(){
        //driver.quit();
    }

    @Test
    public void test1(){
        /*1.Open Chrome browser
        2.Go to http://www.seleniumeasy.com/test/basic-checkbox-demo.html
        3.Verify “Success – Check box is checked” message is NOT displayed.
        4.Click to checkbox under “Single Checkbox Demo” section
        5.Verify “Success – Check box is checked” message is displayed.
         */

        driver.get("http://www.seleniumeasy.com/test/basic-checkbox-demo.html");

        WebElement successMessage = driver.findElement(By.id("isAgeSelected"));

        Assert.assertFalse(successMessage.isSelected(),"verify that “Success – Check box is checked” is NOT displayed");
        successMessage.click();
        Assert.assertTrue(successMessage.isDisplayed(),"verify that “Success – Check box is checked” is NOT displayed");

   }

   @Test
    public void test2() throws InterruptedException {

       driver.get("http://www.seleniumeasy.com/test/basic-checkbox-demo.html");
       String checkAllButton = driver.findElement(By.cssSelector("#check1")).getAttribute("value");

       System.out.println("checkAllButton = " + checkAllButton);

       Assert.assertTrue(checkAllButton.equals("Check All"),"verify that Check All buttons text is Check All");
       driver.findElement(By.cssSelector("#check1")).click();
       List<WebElement> elements = driver.findElements(By.xpath("//input[@class='cb1-element']"));

       for (WebElement element : elements) {
           Assert.assertTrue(element.isSelected(),"Verify all check boxes are checked");
       }

       checkAllButton = driver.findElement(By.cssSelector("#check1")).getAttribute("value");

       Assert.assertTrue(checkAllButton.equals("Uncheck All"),"Verify button text changed to “Uncheck All”");

   }
}
