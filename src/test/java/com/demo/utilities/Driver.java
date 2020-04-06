package com.demo.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Driver {

    private static WebDriver driver;
    private Driver() {}

    public static WebDriver getDriver() {

        String browser = ConfigurationReader.getProperty("browser");

        if (driver != null) {
            return driver;
        }

        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.chromedriver().setup();
                driver = new FirefoxDriver();
                break;
            case "safari":
                if (System.getProperty("os.name").contains("Mac")) {
                    WebDriverManager.getInstance(SafariDriver.class).setup();
                    driver = new SafariDriver();
                } else {
                    throw new WebDriverException("Invalid browser for this operating system");
                }
                break;
            case "edge":
                if (System.getProperty("os.name").contains("Win")) {
                    driver = new EdgeDriver();
                } else {
                    throw new WebDriverException("Invalid browser for this operating system");
                }
                break;
            default:
                throw new RuntimeException("Wrong browser type!");
        }
        return driver;
    }

    public static void close_browser() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}
