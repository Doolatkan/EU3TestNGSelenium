package com.cybertek.tests.HomeWork;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase6_8 {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        //Thread.sleep(2000);
       // driver.quit();
    }

    @Test
    public void test6() throws InterruptedException {
        driver.get("https://www.tempmailaddress.com/");
        Thread.sleep(3000);

        String email = driver.findElement(By.id("email")).getText();

        driver.navigate().to("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.linkText("Sign Up For Mailing List")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("full_name")).sendKeys("Mike Smith");
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("wooden_spoon")).click();

        WebElement message = driver.findElement(By.name("signup_message"));
        Assert.assertTrue(message.isDisplayed(),"verify message is displayed");
        Thread.sleep(2000);
        driver.get("https://www.tempmailaddress.com/");
        Thread.sleep(2000);
        email = driver.findElement(By.cssSelector("tr.hidden-xs.hidden-sm.klikaciRadek.newMail>td")).getText().trim();
        System.out.println("email = " + email);
        Assert.assertEquals(email,"do-not-reply@practice.cybertekschool.com","Verify that you’ve received an email from “do-not-reply@practice.cybertekschool.com");

        driver.findElement(By.cssSelector("tr.hidden-xs.hidden-sm.klikaciRadek.newMail>td")).click();
        String odesilatel = driver.findElement(By.id("odesilatel")).getText();

        Assert.assertEquals(odesilatel,"do-not-reply@practice.cybertekschool.com","Verify that email is from: “do-not-reply@practice.cybertekschool.com");

        String predmet = driver.findElement(By.id("predmet")).getText();
        Assert.assertEquals(predmet,"Thanks for subscribing to practice.cybertekschool.com!","Verify that subject is: “Thanks for subscribing to practice.cybertekschool.com!");
    }

    @Test
    public void test7() throws InterruptedException {
        /*Step
        1. Go to “https://practice-cybertekschool.herokuapp.com”Step
        2. And click on “File Upload".Step
        3. Upload any file with .txt extension from your computer.Step
        4. Click “Upload” button.Step
        5. Verify that subject is: “File Uploaded!”Step
        6. Verify that uploaded file name is displayed.Note: use element.sendKeys(“/file/path”) with
         */
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.linkText("File Upload")).click();
        WebElement file = driver.findElement(By.name("file"));
        String projectPath = System.getProperty("user.dir");
        String filePath = "src/test/resources/homeWork.txt";
        String fullPath = projectPath + "/" + filePath;
        //String absolutePath = "C:\\Users\\GIGABYTE\\IdeaProjects\\EU3TestNGSelenium\\src\\test\\resources\\textfile.txt";

        file.sendKeys(fullPath);

        driver.findElement(By.id("file-submit")).click();

        WebElement h3 = driver.findElement(By.tagName("h3"));

        Assert.assertTrue(h3.isDisplayed(),"Verify that subject is: “File Uploaded!”");

        WebElement uploadedFile = driver.findElement(By.id("uploaded-files"));

        Assert.assertTrue(uploadedFile.isDisplayed(),"Verify that uploaded file name is displayed");

    }

    @Test
    public void test8() throws InterruptedException {
        /*Step 1. Go to “https://practice-cybertekschool.herokuapp.com”Step
        2. And click on “Autocomplete”.Step
        3. Enter “United States of America” into country input box.Step
        4. Verify that following message is displayed: “You selected: United States of America”
        Optional: If you want to to be a real selenium hero, use @DataProvider for for tests
        cases from 9 through 12. Please use following documentation:
        https://testng.org/doc/documentation-main.html#parameters-dataproviders
        */

        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.linkText("Autocomplete")).click();
        driver.findElement(By.id("myCountry")).sendKeys("United States of America");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
        WebElement result = driver.findElement(By.id("result"));
        Assert.assertTrue(result.isDisplayed(),"Verify that following message is displayed: “You selected: United States of America”");


   }
}
