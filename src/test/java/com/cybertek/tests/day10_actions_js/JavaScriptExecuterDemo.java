package com.cybertek.tests.day10_actions_js;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavaScriptExecuterDemo {



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
        public void clickWithJS() {
            driver.get("http://practice.cybertekschool.com/");
            WebElement dropdownLink = driver.findElement(By.linkText("Dropdown"));
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("arguments[0].click();",dropdownLink);

        }

        @Test
        public void typeWithJS(){
            driver.get("http://practice.cybertekschool.com/dynamic_controls");
            WebElement inputBox = driver.findElement(By.cssSelector("#input-example>input"));
            String text = "Hello Disabled Input";
            JavascriptExecutor jse = (JavascriptExecutor)driver;
            jse.executeScript("arguments[0].setAttribute('value', '" + text + " ')",inputBox);
        }

        @Test
        public void ScrollDownAndUp() throws InterruptedException {

            driver.get("http://practice.cybertekschool.com/infinite_scroll");
            JavascriptExecutor jse = (JavascriptExecutor)driver;

            for(int i=0; i<10; i++){
                Thread.sleep(1000);
                jse.executeScript("window.scrollBy(0,750)");
            }

            for(int i=0; i<10; i++){
                Thread.sleep(1000);
                jse.executeScript("window.scrollBy(0,-250)");
            }

        }

        @Test
        public void ScrollToElement(){
            driver.get("http://www.amazon.com");
            WebElement eng = driver.findElement(By.id("icp-touch-link-language"));
            JavascriptExecutor jse = (JavascriptExecutor)driver;
            jse.executeScript("arguments[0].scrollIntoView(true);",eng);
        }



}
