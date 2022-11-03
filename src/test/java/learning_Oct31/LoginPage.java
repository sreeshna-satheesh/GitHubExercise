package learning_Oct31;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver remoteDriver) {
		driver = remoteDriver;
		
		//this.driver = driver;
		
	
	}

	By textEmail = By.id("Email");
	By textPwd = By.id("Password");
	By buttonLogin = By.tagName("button");

	public void enterEmail(String email) {
		driver.findElement(textEmail).clear();
		driver.findElement(textEmail).sendKeys(email);
	}

	public void enterPassword(String password) {
		driver.findElement(textPwd).clear();
		driver.findElement(textPwd).sendKeys(password);
	}

	public void clickLoginButton() {
		driver.findElement(buttonLogin).click();
	}
}
