package com.cydeo.tests.day2_locators_getText_getAttribute.Homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BackAndForthNavigation {

           /* TC #3: Back and forth navigation
                    1- Open a chrome browser
                    2- Go to: https://google.com
                    3- Click to Gmail from top right.
                    4- Verify title contains:
            Expected: Gmail
                    5- Go back to Google by using the .back();
                    6- Verify title equals:
            Expected: Google*/

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://google.com");

        WebElement gmail = driver.findElement(By.linkText("Gmail"));
        gmail.click();

        String title = driver.getTitle();

        if(title.contains("Gmail")){
            System.out.println("PASSED");
        }else{
            System.out.println("FAILED");
        }
        driver.navigate().back();

        title = driver.getTitle();

        if(title.contains("Google")){
            System.out.println("PASSED");
        }else{
            System.out.println("FAILED");
        }




        driver.close();

    }
}
