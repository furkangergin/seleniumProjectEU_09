package com.cydeo.tests.day2_locators_getText_getAttribute.Homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookIncorrectLoginTitleVerification {

    /*
    TC #2: Facebook incorrect login title verification
    1. Open Chrome browser
    2. Go to https://www.facebook.com
    3. Enter incorrect username
    4. Enter incorrect password
    5. Verify title changed to:
    Expected: “Log into Facebook”

     */
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com");

        WebElement userName = driver.findElement(By.id("email"));
        userName.sendKeys("incorrect");

        WebElement passWord = driver.findElement(By.id("pass"));
        passWord.sendKeys("incorret");

        WebElement login = driver.findElement(By.name("login"));
        login.click();

        driver.close();



    }
}
