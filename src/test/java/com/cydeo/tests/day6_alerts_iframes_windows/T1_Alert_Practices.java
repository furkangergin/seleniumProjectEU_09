package com.cydeo.tests.day6_alerts_iframes_windows;

import com.cydeo.utilities.*;
import org.openqa.selenium.*;
import org.testng.*;
import org.testng.annotations.*;

import java.util.concurrent.*;

public class T1_Alert_Practices {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        //1. Open browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2. Go to website: https://practice.cydeo.com/javascript_alerts
        driver.get("https://practice.cydeo.com/javascript_alerts");
    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }

    @Test
    public void alert_test1() throws InterruptedException {
        //3. Click to “Click for JS Alert” button
        WebElement informationAlertButton = driver.findElement(By.xpath("//button[.='Click for JS Alert']"));


        informationAlertButton.click();
        Thread.sleep(1000);

        //To be able to click to Alert OK button we need to switch driver's focus to Alert itself.
        Alert alert = driver.switchTo().alert();

        //4. Click to OK button from the alert
        alert.accept();

        //5. Verify “You successfully clicked an alert” text is displayed.
        WebElement resultText = driver.findElement(By.xpath("//p[@id='result']"));

        //Failure message will only be displayed if assertion fails: "Result text is NOT displayed."
        Assert.assertTrue(resultText.isDisplayed(), "Result text is NOT displayed.");

        String expectedText = "You successfully clicked an alert";
        String actualText = resultText.getText();

        Assert.assertEquals(actualText, expectedText, "Actual result text is not as expected!!!");
    }
    @Test
    public void alert_test2() throws InterruptedException {
        /*
        TC #2: Confirmation alert practice
1. Open browser
2. Go to website: http://practice.cydeo.com/javascript_alerts
3. Click to “Click for JS Confirm” button
4. Click to OK button from the alert
5. Verify “You clicked: Ok” text is displayed.
         */
        WebElement confirm = driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));
        confirm.click();
        Thread.sleep(3000);
        Alert alertConfirm = driver.switchTo().alert();
        alertConfirm.accept();

        WebElement result = driver.findElement(By.id("result"));
        System.out.println("result.isDisplayed() = " + result.isDisplayed());

        Assert.assertTrue(result.isDisplayed(), "Non Displayed!");

        String expected = "You clicked: Ok";
        String actual = result.getText();

        Assert.assertEquals(actual,expected, "Hata var kardeş");
    }
    @Test
    public void alert_test3() throws InterruptedException {
        /*
        TC #3: Information alert practice
1. Open browser
2. Go to website: http://practice.cydeo.com/javascript_alerts
3. Click to “Click for JS Prompt” button
4. Send “hello” text to alert
5. Click to OK button from the alert
6. Verify “You entered:  hello” text is displayed.
         */

        WebElement promt = driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));
        promt.click();
        Alert pro = driver.switchTo().alert();
        Thread.sleep(2000);
        pro.sendKeys("hello");
        Thread.sleep(2000);
        pro.accept();
        Thread.sleep(2000);

        WebElement result = driver.findElement(By.id("result"));
        Assert.assertTrue(result.isDisplayed(), "HATA!");




    }




}
