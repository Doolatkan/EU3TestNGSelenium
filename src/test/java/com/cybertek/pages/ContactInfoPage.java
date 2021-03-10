package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage extends BasePage{

    public ContactInfoPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "div.pull-left>h1.user-name")
    public WebElement fullName;

    @FindBy(css = "a.email")
    public WebElement email;

    @FindBy(css = "a.phone")
    public WebElement phone;
}
