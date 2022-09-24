package com.cydeo.tests.day5_testNG_intro_dropdowns.HomeWork;

import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T6 {
    /*
    TC #6: Selecting date on dropdown and verifying
1. Open Chrome browser
2. Go to https://practice.cydeo.com/dropdown
3. Select “December 1st, 1923” and verify it is selected.
Select year using  : visible text
Select month using   : value attribute
Select day using : index number
     */

    public WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/dropdown");
    }
    @Test
    public void dateDropdown () throws InterruptedException {


        /*WebElement year = driver.findElement(By.xpath("//option[.='1923']"));
        year.click();*/

        Thread.sleep(2000);

        Select dropDown = new Select(driver.findElement(By.xpath("//select[@id='year']")));
        dropDown.selectByVisibleText("1923");

        String expectedYear = "1923";
        String actual = dropDown.getFirstSelectedOption().getText();
        Assert.assertEquals(actual,expectedYear,"year is wrong");

        Thread.sleep(2000);

        Select dropDown2 = new Select(driver.findElement(By.xpath("//select[@id='month']")));
        dropDown2.selectByValue("11");

        String expectedMonth = "December";
        String actualMonth = dropDown2.getFirstSelectedOption().getText();
        Assert.assertEquals(actualMonth,expectedMonth,"month is wrong");

        Thread.sleep(2000);

        Select dropDown3 = new Select(driver.findElement(By.xpath("//select[@id='day']")));
        dropDown3.selectByIndex(0);
        String expectedDay = "1";
        String actualDay = dropDown3.getFirstSelectedOption().getText();
        Assert.assertEquals(actualDay,expectedDay,"day is wrong");



        Thread.sleep(3000);
    }
    @AfterMethod
    public void tearDownMethod(){
        driver.close();
    }

}

