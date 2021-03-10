package com.cybertek.tests.day14_extent_reports;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTestWithReport extends TestBase {

    @Test
    public void wrongPasswordTest(){

        //name of the test
        extentLogger = report.createTest("Wrong Password Test");
        LoginPage loginPage = new LoginPage();

        loginPage.usernameInput.sendKeys("user1");
        extentLogger.info("Enter Username: user1");
        loginPage.passwordInput.sendKeys("somepassword");
        extentLogger.info("Enter Password: somepassword");
        loginPage.loginBtn.click();
        extentLogger.info("Click login Button");

        extentLogger.info("Verify Page URL");
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/user/login");

        extentLogger.pass("Wrong Password Test is Passed");
    }

    @Test
    public void wrongUsernameTest(){

        //name of the test
        extentLogger = report.createTest("Wrong Username Test");
        LoginPage loginPage = new LoginPage();

        extentLogger.info("Enter username: someusername");
        loginPage.usernameInput.sendKeys("someusername");
        extentLogger.info("enter password: UserUser123");
        loginPage.passwordInput.sendKeys("UserUser123");
        extentLogger.info("click Login Button");
        loginPage.loginBtn.click();

        extentLogger.info("Verify page URL");
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/user/loginWE");

        extentLogger.pass("Wrong Username Test is Passed");
    }

    /*
     * open the chrome
     * go to qa1.vytrack
     * login as a sales manager
     * navigate to customers ->contacts
     * click on email mbrackstone9@example.com
     * verify that full name is Mariam Brackstone
     * verify that email is mbrackstone9@example.com
     * verify that phone number is +18982323434
     */


















}
