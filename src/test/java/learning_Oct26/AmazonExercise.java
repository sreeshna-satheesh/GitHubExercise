package learning_Oct26;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonExercise {

	public WebDriver driver;

	@BeforeTest

	public void launchApp() throws Exception {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://www.amazon.in/");

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

	}

	@AfterTest

	public void closeApp() throws Exception {

		Thread.sleep(4000);

		driver.close();

		System.out.println("closing app.....");

	}

	@Test(enabled = true)

	public void perfomClickOperation() throws Exception {

		WebElement SignIn = driver.findElement(By.xpath("//span[contains(text(),'sign in')]"));

		WebElement CreateWishList = driver.findElement(By.xpath("//span[contains(text(),'Create')]"));

		Actions act = new Actions(driver);

		act.moveToElement(SignIn).click(CreateWishList).perform();

	}

}
