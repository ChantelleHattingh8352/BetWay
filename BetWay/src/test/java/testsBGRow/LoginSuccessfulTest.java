package testsBGRow;

import org.testng.Assert;
import org.testng.annotations.Test;

import methodsBGRow.LoginSuccessful;

public class LoginSuccessfulTest {

//instantiate the method page allocated
	LoginSuccessful ls = new LoginSuccessful(); 
	
//Run test case 
	@Test
	public void GIVEN_ClickOnLogin_AND_ValidUsernameEntered_THEN_ClickOnPassword_AND_ValidPasswordEntered_THEN_SuccessfulLoginOnLoginClick() { 
		
//GIVEN - Click on login
		ls.clickLogin(); 
		
//AND - Valid username entered
		ls.enterLogin("JLBBGSTG02");
		
//THEN - Click on password
		ls.clickPassword();
		
//And - Valid password entered
		ls.enterPassword("casino123456");
		
//Click on login for a successful login
		ls.clickLoginCTA();

//Assert if user is logged in 
		Assert.assertEquals(true, ls.isUserLoggedIn());
		
	}
}
