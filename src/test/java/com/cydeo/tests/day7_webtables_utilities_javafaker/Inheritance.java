package com.cydeo.tests.day7_webtables_utilities_javafaker;

import com.cydeo.tests.base.TestBase;
import com.cydeo.tests.utilities.BrowserUtils;
import org.testng.annotations.Test;

public class Inheritance extends TestBase {
    @Test
    public void gergin(){
        System.out.println("hello");
        driver.get("https://www.youtube.com");
        BrowserUtils.verifyTitle(driver, "YouTube");
    }
}
