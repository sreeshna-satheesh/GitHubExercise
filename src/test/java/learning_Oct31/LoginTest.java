package learning_Oct31;

import org.testng.annotations.Test;

import learning_Oct27.BaseTest;
public class LoginTest extends BaseTest{
	

	@Test
	public void verifyLogin() {
		
		lp.enterEmail(conf.getAdminUser());
		lp.enterPassword(conf.getAdminPass());
		lp.clickLoginButton();
		
	
	}
	
	
	
	
	
	
}
