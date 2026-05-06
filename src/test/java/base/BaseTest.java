package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utils.ConfigReader;
import utils.DriverFactory;

public class BaseTest {

    protected WebDriver driver;
    protected ConfigReader config;

    @BeforeMethod
    public void setup() {
        config = new ConfigReader();

        DriverFactory.initDriver();                 // init in factory
        driver = DriverFactory.getDriver();         // always fetch from factory

        driver.manage().window().maximize();
        driver.get(config.getBaseUrl());
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();                 // ❗important (ThreadLocal safe)
    }
}