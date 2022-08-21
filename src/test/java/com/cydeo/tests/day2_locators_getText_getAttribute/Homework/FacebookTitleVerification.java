package com.cydeo.tests.day2_locators_getText_getAttribute.Homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookTitleVerification {

    /*
    TC #1: Facebook title verification
    1. Open Chrome browser
    2. Go to https://www.facebook.com
    3. Verify title:
    Expected: “Facebook - Log In or Sign Up”
     */
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com");

        String expectedTitle ="Facebook – log in or sign up";
        String actualTitle = driver.getTitle();

        System.out.println("actualTitle = " + actualTitle);

        if(expectedTitle.equalsIgnoreCase(actualTitle)){
            System.out.println("PASSED!");
        }else{
            System.out.println("FAILED");
        }
        driver.close();
    }
}
