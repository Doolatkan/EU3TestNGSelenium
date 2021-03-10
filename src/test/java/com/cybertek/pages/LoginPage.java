package com.cybertek.pages;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {

   public LoginPage(){
            PageFactory.initElements(Driver.get(),this);
        }


        //driver.findElement(By.id("prependedInput"));

       /* @FindBys({                 //both have to be true
            @FindBy(id = "prependedInput"),
            @FindBy(name ="_username")
         })
         public WebElement usernameInput;*/
         /*@FindAll({                //one of these have to be true
              @FindBy(id = "prependedInput"),
            @FindBy(name ="_username")
         })*/

            /*@FindBy(name = "button")      //return list of WE
             public List<WebElement> buttons;*/


        @FindBy(name = "_username")
        public WebElement usernameInput;

        @FindBy(id = "prependedInput2")
        public WebElement passwordInput;

        @FindBy(id = "_submit")
        public WebElement loginBtn;


    public void login(String username,String password){
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();
    }

    public void loginAsStoreManager(){

        String username = ConfigurationReader.get("storemanager_username");
        String password = ConfigurationReader.get("storemanager_password");

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();
    }
    public void loginAsDriver(){

        String username = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();
    }





    public void loginAs(String user){

        String username = null;
        String password = null;

        switch (user.toLowerCase()){
            case "driver":
                username = ConfigurationReader.get("driver_username");
                password = ConfigurationReader.get("driver_password");
                break;
            case "store manager":
                username = ConfigurationReader.get("storemanager_username");
                password = ConfigurationReader.get("storemanager_password");
                break;
            case "sales manager":
                username = ConfigurationReader.get("salesmanager_username");
                password = ConfigurationReader.get("salesmanager_password");
                break;
        }
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();
    }


}
