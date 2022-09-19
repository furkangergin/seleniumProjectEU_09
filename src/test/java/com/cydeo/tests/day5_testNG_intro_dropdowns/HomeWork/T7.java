package com.cydeo.tests.day5_testNG_intro_dropdowns.HomeWork;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T7 {

    /*
    TC #7: Selecting value from non-select dropdown
1. Open Chrome browser
2. Go to https://practice.cydeo.com/dropdown
3. Click to non-select dropdown
4. Select Facebook from dropdown
5. Verify title is “Facebook - Log In or Sign Up”
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
    public void dropDown7 (){

        WebElement dropDown = driver.findElement(By.xpath("//a[@id='dropdownMenuLink']"));
        dropDown.click();

        WebElement faceBook = driver.findElement(By.xpath("//a[.='Facebook']"));
        faceBook.click();


        String expected = "Facebook - Giriş Yap veya Kaydol";
        String actual = driver.getTitle();

        //System.out.println(expected + "--> "  + actual);

        Assert.assertEquals(expected,actual, "What went wrong?");

    }
    @AfterMethod
    public void tearDownMethod(){
        driver.close();
    }
}

