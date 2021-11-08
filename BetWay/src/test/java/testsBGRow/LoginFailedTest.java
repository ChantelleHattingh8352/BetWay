package testsBGRow;

import org.testng.Assert;
import org.testng.annotations.Test;

import methodsBGRow.LoginFailed;

public class LoginFailedTest {

//instantiate the method page allocated
	LoginFailed lf = new LoginFailed(); 
	
//Run test case
	@Test
	public void GIVEN_ClickOnLogin_AND_ValidUsernameEntered_THEN_ClickOnPassword_AND_InvalidPasswordEntered_THEN_InvalidCredentialsPopUpMessage() { 
		
//GIVEN_Click on login
	lf.clickLogin();
	
//AND - enter valid username
	lf.enterLogin("JLBBGSTG02");
	
//THEN - Click on password 
	lf.clickPassword();
	
//AND - Enter invalid username
	lf.enterPassword("incorrectpassword");
	
//THEN- Click on login for an invalid login
	lf.clickLoginCTA();
	
//Assert if user is not logged in and pop up is shown
	Assert.assertEquals(true, lf.loginFailureDetailsIncorrect());

	}
	
	@Test
	public void GIVEN_ClickOnLogin_AND_InvalidUsernameEntered_THEN_ClickOnPassword_AND_ValidPasswordEntered_THEN_InvalidCredentialsPopUpMessage() { 

	lf.clickLogin();
	
	lf.enterLogin("IncorrectUsername");
	
	lf.clickPassword();
	
	lf.enterPassword("casino123456");
	
	lf.clickLogin();
	
	Assert.assertEquals(true, lf.loginFailureDetailsIncorrect());
	}
	
}
