package com.cydeo.tests.day4_findElements_checkboxes_radio;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T3_HomeWork {
    /*
    TC #6:  XPATH LOCATOR practice
1. Open Chrome browser
2. Go to http://practice.cydeo.com/multiple_buttons
3. Click on Button 1
4. Verify text displayed is as expected:
Expected: “Clicked on button one!”

USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS
     */
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("http://practice.cydeo.com/multiple_buttons");

        WebElement button1 = driver.findElement(By.xpath("//button[.='Button 1']"));
        button1.click();

        WebElement actualText = driver.findElement(By.xpath("//p[@id='result']"));

       String actual = actualText.getText();
       String expected = "Clicked on button one!";

       if(actual.equals(expected)){
           System.out.println("PASSED");
       }else{
           System.out.println("FAILED");
       }
       //driver.close();



    }
}
