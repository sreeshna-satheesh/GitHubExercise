package testNGPractive;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NoCommerceTest {
	
	WebDriver driver;
	
	
	@BeforeTest
	public void launchApplication() {
		
		System.out.println("Launch Application");
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
		driver.manage().window().maximize();
	}

	
	@Test(priority=0)
	public void loginTest() throws InterruptedException {
		System.out.println("Login Test");
		WebElement a =driver.findElement(By.xpath("//input[@id='Email']"));
		a.clear();
		a.sendKeys("admin@yourstore.com");
		
		WebElement b = driver.findElement(By.xpath("//input[@id='Password']"));
		b.clear();
		b.sendKeys("admin");
		
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		Thread.sleep(2000);
		System.out.println(driver.getTitle());
		Assert.assertTrue(driver.getTitle().contains("DashBoard"));
	}
	
	@Test(priority=1)
	public void logoutTest() throws InterruptedException {
		System.out.println("Logout Test");
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		
		Thread.sleep(2000);
		Assert.assertTrue(driver.getTitle().contains("Login"));
		
	}
	
	@AfterTest
	public void closeApplication() {
		System.out.println("Close Application");
		driver.close();
	}
}
