package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyURLnotChanged {

    public static void main(String[] args) {

        //open chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");

        //save expected url before clickoing button
        String expectedURL = driver.getCurrentUrl();

        //click on Retrive password
        //WebElement --> Interface that represent elements on the webpage
        //findElement ==> method used to find element on a page
        WebElement retrivePasswordButton = driver.findElement(By.id("form_submit"));
        retrivePasswordButton.click();

        //save actual result url after clicking button
        String actualURL = driver.getCurrentUrl();

        //verify that url did not change
        if(expectedURL.equals(actualURL)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }

        //close your browser
        driver.quit();















    }


}
