package com.cybertek.tests.day10_actions_js;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class HoverTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    /**
     * hover over each image in the website
     * verify each name:user text is displayed
     */

    @Test
    public void test1() throws InterruptedException {

        driver.get("http://practice.cybertekschool.com/hovers");

        List<WebElement> imgs = driver.findElements(By.tagName("img"));

        List<WebElement> namesUser = driver.findElements(By.tagName("h5"));

        Actions actions = new Actions(driver);

        for(int i=0; i<imgs.size();i++){
            Thread.sleep(1000);
            actions.moveToElement(imgs.get(i)).perform();
            Assert.assertTrue(namesUser.get(i).isDisplayed(),"verify user name is displayed");
        }

    }

    @Test
    public void test2() throws InterruptedException {

        driver.get("http://practice.cybertekschool.com/hovers");

        Actions actions = new Actions(driver);

        for (int i=1; i<=3; i++) {
            String xpathIMG = "(//img)[" + i + "]";
            WebElement imgs = driver.findElement(By.xpath(xpathIMG));
            Thread.sleep(2000);
            actions.moveToElement(imgs).perform();
            String textPath = "//h5[.='name: user" + i + "']";
            WebElement namesUser = driver.findElement(By.xpath(textPath));
            Assert.assertTrue(namesUser.isDisplayed(), "verify user "+i+" name is displayed");

        }

    }
}
