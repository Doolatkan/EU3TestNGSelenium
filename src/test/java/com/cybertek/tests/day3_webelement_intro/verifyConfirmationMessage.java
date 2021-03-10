package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyConfirmationMessage {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");

        String expectedEmail = "mike@smith.com";
        WebElement emailInputBox = driver.findElement(By.name("email"));
        emailInputBox.sendKeys("mike@smith.com");

        String actualEmail = emailInputBox.getAttribute("value");
        System.out.println("actualEmail =  " + actualEmail);

        if(expectedEmail.equals(actualEmail)){

            WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));
            retrievePasswordButton.click();

            String expectedMessage = "Your e-mail's been sent!";

            WebElement actualConfirmationMessage = driver.findElement(By.name("confirmation_message"));
            String actualMessage = actualConfirmationMessage.getText();

            if(expectedMessage.equals(actualMessage)){
                System.out.println("actualMessage = " + actualMessage);
                System.out.println("PASS");
            }else{
                System.out.println("FAIL");
                System.out.println("expectedMessage = " + expectedMessage);
                System.out.println("actualMessage = " + actualMessage);
            }

        }else{
            System.out.println("FAIL");
            System.out.println("expectedEmail =  " + expectedEmail);
            System.out.println("actualEmail =  " + actualEmail);
        }

        driver.quit();


    }
}
