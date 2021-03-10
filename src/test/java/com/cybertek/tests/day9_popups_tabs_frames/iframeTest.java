package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class iframeTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        //driver.quit();
    }

    @Test
    public void SwithchWindowTest() throws InterruptedException {

        driver.get("http://practice.cybertekschool.com/iframe");
        //1. Switch using by name or ID attribute of iframe
        driver.switchTo().frame("mce_0_ifr");

        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#tinymce")).clear();
        driver.findElement(By.cssSelector("#tinymce")).sendKeys("MikeSmith");
        Thread.sleep(2000);

        //1.way go back to first frame(main html)
        //go back to first frame, usefull when we have switched multiple frames
        driver.switchTo().defaultContent();

        //2.Switch with INDEX
        driver.switchTo().frame(0);

        //clear before sendkeys
        driver.findElement(By.cssSelector("#tinymce")).clear();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#tinymce")).sendKeys("MikeSmith WITH INDEX");


        //2. second way to switch parent
        driver.switchTo().parentFrame();

        //3. Using WEBELEMENT
        WebElement iframeElement = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iframeElement);
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#tinymce")).sendKeys("MakeSmith WEBELEMENT");


    }

    @Test
    public void test2(){
        driver.get("http://practice.cybertekschool.com/nested_frames");
        //switch to frame top
        driver.switchTo().frame("frame-top");
        //top has 3 frames under: left, middle and right
        //switch to frame middle
        driver.switchTo().frame("frame-middle");
        System.out.println(driver.findElement(By.id("content")).getText());

        //switch to parent frame
        driver.switchTo().parentFrame();
        //switch to right with index
        driver.switchTo().frame(2);
        System.out.println(driver.findElement(By.tagName("body")).getText());

        //go to main html to switch bottom
        driver.switchTo().defaultContent();
        //switch to bottom frame
        driver.switchTo().frame(1);
        //print to text
        System.out.println(driver.findElement(By.tagName("body")).getText());
    }
}
