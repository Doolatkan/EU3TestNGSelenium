package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static java.lang.Thread.*;

public class verifyURLchanged {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/forgot_password");

        String expectedURL = "http://practice.cybertekschool.com/email_sent";

        //enter any email
        WebElement emailInputBox = driver.findElement(By.name("email"));

        //sendKeys() --> send keybord action to the webelement
        emailInputBox.sendKeys("mike@smith.com");

        WebElement retrivePasswordButton = driver.findElement(By.id("form_submit"));
        retrivePasswordButton.click();

        //Thread.sleep(3000);

        String actualURL = driver.getCurrentUrl();

        if(expectedURL.equals(actualURL)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("expectedlURL = " + expectedURL);
            System.out.println("actualURL = " + actualURL);
        }

        driver.quit();

    }
}
