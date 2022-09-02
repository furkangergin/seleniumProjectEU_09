package com.cydeo.tests.day5_testNG_intro_dropdowns.HomeWork;

import com.cydeo.tests.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class T8 {
    /*
    TC #8: Selecting value from multiple select dropdown
1. Open Chrome browser
2. Go to https://practice.cydeo.com/dropdown
3. Select all the options from multiple select dropdown.
4. Print out all selected values.
5. Deselect all values.
     */

    WebDriver driver;
    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/dropdown");
    }
    @Test
    public void dropDown8 (){

        Select option = new Select(driver.findElement(By.xpath("//select[@name='Languages']")));

       // System.out.println("option.isMultiple() = " + option.isMultiple());

        option.selectByIndex(0);
        option.selectByIndex(1);
        option.selectByIndex(2);
        option.selectByIndex(3);
        option.selectByIndex(4);
        option.selectByIndex(5);

        List<WebElement> allSelected =option.getAllSelectedOptions();

        for (WebElement webElement : allSelected) {
            System.out.println(webElement.getText());
        }

        option.deselectAll();


    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();
    }
}
