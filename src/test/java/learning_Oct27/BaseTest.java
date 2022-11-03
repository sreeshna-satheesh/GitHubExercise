package learning_Oct27;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import Utilities.ConfigRead;
import io.github.bonigarcia.wdm.WebDriverManager;
import learning_Oct31.LoginPage;

public class BaseTest {
	
	public WebDriver driver;
	public ConfigRead conf;
	public Logger log;
	public LoginPage lp;
	
	@BeforeTest
	public void launchApp() throws Exception {
		log = Logger.getLogger("NOP Comm Login");
	    PropertyConfigurator.configure(".\\testData\\log4j.properties");
	    log.info("launching chrome browser.");
		
	    
	    
	    WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		//launching browser ------ session get created
		
		lp = new LoginPage(driver);
		
		
		
		
		driver.manage().window().maximize();
		conf = new ConfigRead();
        log.info("launching Application: " + conf.getAppURL());
        driver.get(conf.getAppURL());

	    
	}
	@AfterTest
    public void closeApp() throws Exception {

        log.info("closing chrome browser.");
        Thread.sleep(4000);
        driver.close();
    }
	

}
