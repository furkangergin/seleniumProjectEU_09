package com.cydeo.tests.day5_testNG_intro_dropdowns.HomeWork;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T5 {
    /*
    TC #5: Selecting state from State dropdown and verifying result
1. Open Chrome browser
2. Go to http://practice.cybertekschool.com/dropdown
3. Select Illinois
4. Select Virginia
5. Select California
6. Verify final selected option is California.
Use all Select options. (visible text, value, index)
     */
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/dropdown");

    }
   @Test
    public void dropDownTest() throws InterruptedException {

       Select simpleDrown = new Select(driver.findElement(By.xpath("//select[@id='state']")));

      // WebElement currentSelect = simpleDrown.getFirstSelectedOption();

      // System.out.println("currentSelect.getText() = " + currentSelect.getText());

       /*List<WebElement> allOptions = simpleDrown.getOptions();

       for (WebElement allOption : allOptions) {
           System.out.println(allOption.getText());
       }*/

       Thread.sleep(2000);

       simpleDrown.selectByVisibleText("Illinois");

       Thread.sleep(2000);

       simpleDrown.selectByValue("VA");

       Thread.sleep(2000);

       simpleDrown.selectByIndex(5);

       String expectedFinal = "California";


       String actualFinal = simpleDrown.getFirstSelectedOption().getText();


       Assert.assertEquals(actualFinal,expectedFinal, "FAILED!");









   }

}
