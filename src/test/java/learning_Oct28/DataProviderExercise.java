package learning_Oct28;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import learning_Oct27.BaseTest;

public class DataProviderExercise extends BaseTest {

	@Test(priority = 1, dataProvider = "testData")

	public void verifyLoginWithInValidUserDetails(String uname, String pwd) throws Exception {

		Thread.sleep(2000);

		log.info("clear text from username field.");

		driver.findElement(By.id("Email")).clear();

		log.info("enter value into username: " + uname);

		driver.findElement(By.id("Email")).sendKeys(uname);

		Thread.sleep(2000);

		log.info("clear text from password field.");

		driver.findElement(By.id("Password")).clear();

		log.info("enter value into password: " + pwd);

		driver.findElement(By.id("Password")).sendKeys(pwd);

		Thread.sleep(2000);

		log.info("click on checkbox");

		driver.findElement(By.id("RememberMe")).click();

		Thread.sleep(2000);

		log.info("click on Login button.");

		driver.findElement(By.tagName("button")).click();

		Thread.sleep(2000);

		// validation step

		log.info("Validation of error message for invalid user.");

		Assert.assertTrue(driver.getPageSource().contains("Login was unsuccessful"));

	}

	@DataProvider
	public Object[][] sampleData() {

		Object[][] data = { { "Ashwini@gmail.com", "demo@123" }, { "Deepika@yahoomail.com", "23129900" },
				{ "neha@ibm.com", "welcome@123" } };

		return data;

	}
	
	@DataProvider
	public Object[][] testData(){
		Object[][] data = { { "Ashwini@test.com", "demo@123" }, { "Deepika@test.com", "23129900" },
				{ "neha@test.com", "welcome@123" } };
		return data;
		
	}

}
