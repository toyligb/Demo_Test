package com.demo.test;

import com.demo.utilities.ConfigurationReader;
import com.demo.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    @BeforeMethod
    public void setup() {
        String url = ConfigurationReader.getProperty("url");
        Driver.getDriver().get(url);
    }

    @AfterMethod
    public void tear_down() {
        Driver.close_browser();
        System.out.println("End of the test base!");
    }

}
