package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	By username = By.id("username");
	By password = By.id("password");
	By submit = By.id("submit");
	By logout = By.linkText("Log out");

	public void open() {
		driver.get("https://practicetestautomation.com/practice-test-login/");
	}

	public void login(String user, String pass) {
		driver.findElement(username).sendKeys(user);
		driver.findElement(password).sendKeys(pass);
		driver.findElement(submit).click();
	}

	public void logout() {
		driver.findElement(logout).click();
	}

	public boolean isLoggedIn() {
		return driver.getCurrentUrl().contains("logged-in");
	}
}