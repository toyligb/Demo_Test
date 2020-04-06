package com.demo.test;

import com.demo.utilities.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.demo.utilities.Util.sleep;

public class LoginPageTest extends TestBase {

    @Test(description = "Verify page title contains Amazon")
    public void verifyPageTitle() {
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Amazon"));
    }

}
