package com.cybertek.tests.day5_xpath.LocatorHW;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestCase1_2_3 {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://www.ebay.com");

        WebElement searchInput = driver.findElement(By.xpath("//input[@id='gh-ac']"));
        searchInput.click();
        searchInput.sendKeys("dior");

        WebElement seacrButton = driver.findElement(By.xpath("//input[@value='Search']"));
        seacrButton.click();

        System.out.println(driver.findElement(By.xpath("//span[@class='BOLD'][1]")).getText());

    }
}
