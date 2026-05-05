package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {

	WebDriver driver;

	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup(); 
		driver = new ChromeDriver();
	}

	@Test
	public void loginLogoutTest() {
		driver.get("https://practicetestautomation.com/practice-test-login/");

		driver.findElement(By.id("username")).sendKeys("student");
		driver.findElement(By.id("password")).sendKeys("Password123");

		driver.findElement(By.id("submit")).click();

		// simple validation
		boolean isLoggedIn = driver.getCurrentUrl().contains("logged-in");
		System.out.println("Login Successful: " + isLoggedIn);

		// logout
		driver.findElement(By.linkText("Log out")).click();
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}