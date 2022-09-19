package com.cydeo.tests.day3_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T5_HomeWork {
    /*
    TC #5: NextBaseCRM, locators, getText(), getAttribute() practice
1- Open a chrome browser
2- Go to: https://login1.nextbasecrm.com/?forgot_password=yes
3- Enter incorrect username into login box:
4- Click to `Reset password` button
5- Verify “error” label is as expected
Expected: Login or E-mail not found
     */

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get(" https://login1.nextbasecrm.com/?forgot_password=yes");

        WebElement userName = driver.findElement(By.cssSelector("input[class='login-inp']"));
        userName.sendKeys("furkan");

        WebElement loginButton = driver.findElement(By.cssSelector("button[class='login-btn']"));
        loginButton.click();

        String expectedError= "Login or E-mail not found";

        WebElement error = driver.findElement(By.cssSelector("div[class='errortext']"));
        String actual = error.getText();

        if(actual.equals(expectedError)){
            System.out.println("PASSED");
        }else{
            System.out.println("FAILED!");
        }


    }
}
