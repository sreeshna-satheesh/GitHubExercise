package learning_Oct25;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenshotExercise {

	WebDriver driver;

	@BeforeTest
	public void launchApplication() {

		System.out.println("Launch Application");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
	}

	@Test
	public void takeScreenshot() throws InterruptedException, IOException {
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone14" + Keys.ENTER);
		Thread.sleep(2000);

		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); 

		File target = new File(".\\screenshot\\AmazonSearchTest.png");

		FileUtils.copyFile(screenshotFile, target);

	}

	@AfterTest
	public void closeApplication() {
		System.out.println("Close Application");
		driver.close();
	}
}
