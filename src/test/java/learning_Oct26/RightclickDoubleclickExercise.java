package learning_Oct26;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RightclickDoubleclickExercise {

	public WebDriver driver;

	@BeforeTest

	public void launchApp() throws Exception {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);

	}

	@AfterTest

	public void closeApp() throws Exception {

		Thread.sleep(4000);

		driver.close();

		System.out.println("closing app.....");

	}
	
	@Test
	 
	public void verifyClickoperation() {
		
		driver.get("https://demo.guru99.com/test/simple_context_menu.html");
		
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MICROSECONDS);
		
		WebElement rightClick = driver.findElement(By.xpath("//span[contains(text(),'right click')]"));
		
		Actions a = new Actions(driver);		
		
		a.contextClick(rightClick).perform();
		
		WebElement doubleClick = driver.findElement(By.xpath("//button[contains(text(),'Double-Click')]"));
		
		a.doubleClick(doubleClick).perform();
		
		Alert b = driver.switchTo().alert();
		
		System.out.println(b.getText());
		
		b.accept();
		
		
	}
}
