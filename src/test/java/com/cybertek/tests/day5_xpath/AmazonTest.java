package com.cybertek.tests.day5_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonTest {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        String expectedResult = "1-48 of over 5,000 results for \"Java\"";
        driver.get("https://www.amazon.com");

        WebElement searchInput = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchInput.sendKeys("Java");

        driver.findElement(By.xpath("//input[@value='Go']")).click();

        String actualResult = driver.findElement(By.xpath("//span[contains(text(),'results for')]")).getText() +" "+driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']")).getText();


        if(expectedResult.equals(actualResult)){
            System.out.println("PASS");
        }else{
            System.out.println(expectedResult);
            System.out.println(actualResult);
            System.out.println("FAIL");
        }
       driver.quit();

    }
}
