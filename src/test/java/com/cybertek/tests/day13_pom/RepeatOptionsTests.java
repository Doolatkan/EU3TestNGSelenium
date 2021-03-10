package com.cybertek.tests.day13_pom;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.CreateCalendarEventsPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RepeatOptionsTests extends TestBase {

    /*VERIFY RADIO BUTTONS
  Open browser
  Login as driver
  Go to Activities->Calendar Events
  Click on create calendar events
  Click on repeat
  Verify that repeat every days is checked
  verify that repeat weekday is not checked
  * */
    @Test
    public void test1(){

        LoginPage loginPage = new LoginPage();
        loginPage.loginAsDriver();
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.navigateToModule("Activities","Calendar Events");
       // BrowserUtils.waitFor(2);
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        calendarEventsPage.createCalendarEvent.click();
        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
        createCalendarEventsPage.repeat.click();
        Assert.assertTrue(createCalendarEventsPage.days.isSelected(), "Verify that repeat every days is checked");
        Assert.assertFalse(createCalendarEventsPage.weekday.isSelected(),"verify that repeat weekday is not checked");
    }

      /*
VERIFY REPEAT OPTIONS
   Open browser
   Login as driver
   Go to Activities->Calendar Events
   Click on create calendar events button
   Click on repeat checkbox
   Verify that repeat options are Daily, Weekly, Monthly,Yearly(in this order)
*/

    @Test
    public void test2(){

        LoginPage loginPage = new LoginPage();
        loginPage.loginAsDriver();
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.navigateToModule("Activities","Calendar Events");
        // BrowserUtils.waitFor(2);
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        calendarEventsPage.createCalendarEvent.click();
        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
        createCalendarEventsPage.repeat.click();

        Select repeatsDropDown = createCalendarEventsPage.repeatOptionsList();

        List<String> expectedList = Arrays.asList("Daily", "Weekly", "Monthly","Yearly");

        List<String> actualList = new ArrayList<>();
        List<WebElement> actualOptions = repeatsDropDown.getOptions();

        for (WebElement option : actualOptions) {

            actualList.add(option.getText());
        }

        //ready method for getting text of list of web element
        List<String> actualList1 = BrowserUtils.getElementsText(actualOptions);

        Assert.assertEquals(actualList,expectedList,"Verify that repeat options are Daily, Weekly, Monthly,Yearly");







    }
}
