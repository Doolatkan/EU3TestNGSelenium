package com.cybertek.tests.day15_review;

import com.cybertek.pages.ContactInfoPage;
import com.cybertek.pages.ContactsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class verifyContactInfoTest extends TestBase {

    @Test
    public void contactDetailsTest(){

        extentLogger = report.createTest("contact Details Test");

        LoginPage loginPage = new LoginPage();

        loginPage.loginAs("sales manager");

        extentLogger.info("username: " + ConfigurationReader.get("salesmanager_username"));
        extentLogger.info("password: " + ConfigurationReader.get("salesmanager_password"));
        extentLogger.info("Login in As Sales Manager");

        new DashboardPage().navigateToModule("Customers","Contacts");
        extentLogger.info("navigate to to Customers -> Contacts");

        ContactsPage contactsPage = new ContactsPage();
        contactsPage.waitUntilLoaderScreenDisappear();
        contactsPage.getContactEmail("mbrackstone9@example.com").click();
        contactsPage.waitUntilLoaderScreenDisappear();
        extentLogger.info("Click on mbrackstone9@example.com");

        ContactInfoPage contactInfoPage = new ContactInfoPage();

        String expectecFullName = "Mariam Brackstone";

        String actualFullName = contactInfoPage.fullName.getText();

        Assert.assertEquals(actualFullName,expectecFullName,"verify fullname is Mariam Brackstone");
        extentLogger.info("verify fullname is " +  actualFullName);

        Assert.assertEquals(contactInfoPage.email.getText(),"mbrackstone9@example.com", "verify email is mbrackstone9@example.com");
        extentLogger.info("verify email is mbrackstone9@example.com");

        Assert.assertEquals(contactInfoPage.phone.getText(),"+18982323434","verify phone number is +18982323434");
        extentLogger.info("verify phone number is +18982323434");

        extentLogger.pass("Pass");

    }
}
