package learning_Oct26;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JSExercise {

	public WebDriver driver;

	@BeforeTest

	public void launchApp() throws Exception {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

	}

	@AfterTest

	public void closeApp() throws Exception {

		Thread.sleep(4000);

		driver.close();

		System.out.println("closing app.....");

	}

	@Test

	public void perfomClickOperation() throws Exception {

		Thread.sleep(4000); // hard coded delay

		WebElement btnLogin = driver.findElement(By.tagName("button"));

		// JavascriptExecutor JS = (JavascriptExecutor) driver;

		// JS.executeScript("arguments[0].click()", btnLogin);

		// alert('hello');

		// JavascriptExecutor JS = (JavascriptExecutor) driver;

		// JS.executeScript("arguments[0].click()", btnLogin);

		clickUsingJS(btnLogin);

		Thread.sleep(4000);

	}

	public void clickUsingJS(WebElement ele) {

		JavascriptExecutor JS = (JavascriptExecutor) driver;

		JS.executeScript("arguments[0].click()", ele);

	}

}
