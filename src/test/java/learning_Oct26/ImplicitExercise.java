package learning_Oct26;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImplicitExercise {

	WebDriver driver;

	@BeforeTest

	public void launchApp() throws Exception {

		System.out.println("launch app.....");

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.manage().window().maximize();

	}

	@Test

	public void testApp() throws InterruptedException {
		driver.get("http://only-testing-blog.blogspot.com/2014/01/textbox.html");

		// implicit wait --------- any element

		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		// handle sync issue

		// Explicit Wait ------- specific element and specific condition

		WebDriverWait wait = new WebDriverWait(driver, 60); // max time

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("text3")));

		WebElement txt_box3 = driver.findElement(By.id("text3")); //

		txt_box3.sendKeys("Admin");


	}

	
	@AfterTest

	public void closeApp() throws Exception {

		Thread.sleep(4000);

		driver.close();

		System.out.println("closing app.....");

	}
}
