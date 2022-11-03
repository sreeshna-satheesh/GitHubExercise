package learning_Oct25;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramesExercise {
	WebDriver driver;

	@BeforeTest
	public void launchApplication() {

		System.out.println("Launch Application");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		//driver.get("https://paytm.com/");
		driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?org/openqa/selenium/TakesScreenshot.html");
		driver.manage().window().maximize();
	}

	@Test
	public void frameTest() throws InterruptedException {
		/*driver.findElement(By.xpath("//span[text()='Sign In']")).click();
		
		Thread.sleep(2000);

		WebElement myFrame = driver.findElement(By.xpath("//iframe[contains(@src,'login')]"));
		
		Thread.sleep(2000);

		driver.switchTo().frame(myFrame);

		String actualHeading = driver.findElement(By.cssSelector(".heading")).getText();

		System.out.println("Heading text: " + actualHeading);

		Assert.assertTrue(actualHeading.contains("Paytm Web account"));

		driver.findElement(By.xpath("//span[contains(text(),'Watch')]")).click();*/

		driver.switchTo().frame("packageFrame");
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[text()='Actions']")).click();
		
		Thread.sleep(2000);
		
		Assert.assertTrue(driver.getTitle().contains("Action"));
	}

	@AfterTest
	public void closeApplication() {
		System.out.println("Close Application");
		driver.close();
	}
}
