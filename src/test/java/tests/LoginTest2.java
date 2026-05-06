package tests;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import base.BaseTest;
import pages.LoginPage;
import utils.ExtentManager;
import utils.ScreenshotUtil;	

public class LoginTest2 extends BaseTest {

    ExtentReports extent = ExtentManager.getInstance();
    ExtentTest test;

    @Test
    public void loginLogoutTest() {

        test = extent.createTest("Login Test");

        LoginPage login = new LoginPage(driver);

        login.open();
        test.info("Opened login page");

        login.login("student", "Password123");

        Assert.assertTrue(login.isLoggedIn(), "Login Failed");
        test.pass("Login successful");

        login.logout();
    }

    @AfterMethod
    public void reportFlush(ITestResult result) {

        if (result.getStatus() == ITestResult.FAILURE) {
            String path = ScreenshotUtil.capture(driver, result.getName());
            test.fail("Test Failed",
                    MediaEntityBuilder.createScreenCaptureFromPath(path).build());
        }

        extent.flush();
    }
}