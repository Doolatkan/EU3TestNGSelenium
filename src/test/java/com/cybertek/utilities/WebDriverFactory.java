package com.cybertek.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {

    public static WebDriver getDriver(String browserType){

        WebDriver driver = null;

        if(browserType.toLowerCase().equals("firefox")){
            WebDriverManager.firefoxdriver().setup();
             driver = new FirefoxDriver();
        }else if(browserType.toLowerCase().equals("chrome")){
            WebDriverManager.chromedriver().setup();
             driver = new ChromeDriver();
        }
        return driver;
    }

}

