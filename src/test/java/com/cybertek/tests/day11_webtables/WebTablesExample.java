package com.cybertek.tests.day11_webtables;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebTablesExample {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/tables");

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        //Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void printTable(){

        WebElement table1 = driver.findElement(By.id("table1"));

        System.out.println(table1.getText());

        Assert.assertTrue(table1.getText().contains("jdoe@hotmail.com"));

    }


    @Test
    public void getAllHeaders(){

        List<WebElement> headersList = driver.findElements(By.xpath("(//table)[1]//th"));
        System.out.println("headersList.size() = " + headersList.size());

        for (WebElement header : headersList) {
            System.out.println(header.getText());
        }


    }

    @Test
    public void printTableSize(){

        List<WebElement> headersList = driver.findElements(By.xpath("(//table)[1]//th"));
        System.out.println("headersList.size() = " + headersList.size());

        List<WebElement> allRowsWithHeader = driver.findElements(By.xpath("//table[@id='table1']//tr"));
        System.out.println(allRowsWithHeader.size());

        List<WebElement> allRowsWithoutHeader = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        System.out.println(allRowsWithoutHeader.size());


    }

    @Test
    public void getRow(){

        //WebElement row2 = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[2]"));
        //System.out.println("row2 = " + row2.getText());

        List<WebElement> numRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));

        for (int i = 1; i <=numRows.size(); i++) {
            WebElement row = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+i+"]"));
            System.out.println(i + "-" + row.getText());

        }


    }

    @Test
    public void getAllCellInOneRow(){
        List<WebElement> numRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        for (int i = 1; i <= numRows.size(); i++) {
            List<WebElement> row = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr["+i+"]/td"));
            for (WebElement element : row) {
                System.out.println(element.getText());
            }
            System.out.println();

        }

    }

    @Test
    public void getOnlyOneCell(){

        WebElement cell = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[3]/td[5]"));

        System.out.println(cell.getText());
         cell = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[2]/td[3]"));

    }

    @Test
    public void printAllCellsByIndex(){

        int rowNumber = getNumberOfRows();
        int colNumber = getNumberOfColums();

        for (int i = 1; i <= rowNumber; i++) {

            for (int j = 1; j <=colNumber; j++) {
                WebElement cells = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+i+"]/td["+j+"]"));
                System.out.println(cells.getText());
            }
            System.out.println();
        }
    }

    @Test
    public void getCellInRelationToAnotherCellInSameRow(){

        String firstName = "Jason";
        String xpath = "//table[@id='table1']//td[.='"+firstName+"']/../td[3]";
        WebElement email = driver.findElement(By.xpath(xpath));
        System.out.println(email.getText());


    }

    public int getNumberOfRows(){
        List<WebElement> allRowsWithoutHeader = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        return allRowsWithoutHeader.size();
    }

    public int getNumberOfColums(){
        List<WebElement> headersList = driver.findElements(By.xpath("(//table)[1]//th"));
        return headersList.size();

    }



}























