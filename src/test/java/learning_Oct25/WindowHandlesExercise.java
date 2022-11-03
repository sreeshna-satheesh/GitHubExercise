package learning_Oct25;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandlesExercise {

	WebDriver driver;

	@BeforeTest
	public void launchApplication() {

		System.out.println("Launch Application");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.irctc.co.in/");
		driver.manage().window().maximize();
	}

	@Test
	public void windowhandlesexercise() throws InterruptedException {

		driver.findElement(By.xpath("//button[text()='OK']")).click();

		String parentWindow = driver.getWindowHandle();
		System.out.println("Parent Window" + parentWindow);

		driver.findElement(By.partialLinkText("HOTELS")).click();
		Set<String> allWindows = driver.getWindowHandles();

		System.out.println("Windows Opened" + allWindows.size());

		String mainWindow = (String) allWindows.toArray()[0];
		String hotelWindow = (String) allWindows.toArray()[1];
		System.out.println("Parent Window" + mainWindow);
		System.out.println("Hotel Window" + hotelWindow);

		Thread.sleep(4000);

		System.out.println("Switching to hotel window.........");

		driver.switchTo().window(hotelWindow);

		Thread.sleep(4000);

		System.out.println("Switching to main window.........");

		driver.switchTo().window(mainWindow);

		Thread.sleep(4000);

		System.out.println("Switching to hotel window.........");

		driver.switchTo().window(hotelWindow);

		driver.findElement(By.linkText("Login")).click();

		Thread.sleep(4000);

		System.out.println("Switching to main window.........");

		driver.switchTo().window(mainWindow);

		driver.findElement(By.linkText("CONTACT US")).click();

		Thread.sleep(4000);

		System.out.println("Switching to hotel window.........");

		driver.switchTo().window(hotelWindow);

	}
}
