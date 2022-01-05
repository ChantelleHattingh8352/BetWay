package testsBGRow;

import org.testng.annotations.Test;
import static org.apache.commons.lang3.RandomStringUtils.*;
import methodsBGRow.RegistrationSuccessful;


public class RegistrationSuccessfulTest {

	//instantiate the method page allocated
	RegistrationSuccessful rs = new RegistrationSuccessful(); 
	
//test case 
	@Test
	public void GIVEN_ClickOnRegistrationForm_WHEN_ClickAndEnterValidDataIntoFields_THEN_RegistrationSuccessful() {
		
//Accept cookie policy 
		rs.cookiePolicyClick();
		
// open registration form
		rs.registrationForm();
		
//firstname click and enter random alphanumeric data
		rs.firstNameClick();
		rs.firstNameEnter(randomAlphabetic(10));
		
//lastname click and enter random alphanumeric data
		rs.surnameClick();
		rs.surnameEnter(randomAlphabetic(10));
		
//email click and enter random alphanumeric and numeric data
		rs.emailClick();
		rs.emailEnter(randomAlphabetic(5)+randomNumeric(5)+"@rodeoliving.com");
	
//mobile number click and enter random number data
		rs.mobileClick();
		rs.mobileEnter(randomNumeric(10));
		
//click on dropdown and select Bulgaria
		rs.nationalityDropDown();
		
////click and enter pin
		rs.scrollPin();
		rs.pinClick();
		rs.pinEnter("1111111111");
		
//select DOB from DOB dropdown
		//rs.dobDropDownDay();
		//rs.dobDropDownMonth();
		//rs.dobDropDownYear();
		
//Click on dropdown and select Bulgarian Lev
		rs.currencyDropDown();
		
//click and enter address
		rs.scrollAddress();
		rs.addressClick();
		rs.addressEnter(randomAlphabetic(5));
		
//click and enter city 
		rs.cityClick();
		rs.cityEnter(randomAlphabetic(5));
		
//click and enter city code
		rs.codeClick();
		rs.codeEnter(randomNumeric(4));

//click and enter random username
		rs.usernameClick();
		rs.usernameEnter(randomAlphabetic(5) + randomNumeric(4));
		
//click and enter password - casino123456!
		rs.passwordClick();
		rs.passwordEnter("Casino123456!");
		
//click and enter confirmPassword - Casino123456!
		rs.confirmPasswordClick();
		rs.confirmPasswordEnter("Casino123456!");
		
//click on over 18 checkbox
		rs.mouseMove();
		
//click on accept terms checkbox
		rs.acceptTermsCheckbox();
		
//click on accept terms checkbox
		//rs.acceptTermsCheckbox();
		//rs.scrollDownPage();
		
//click on accept Marketing checkbox
		//rs.scrollMarketing();
		rs.acceptMarketingCheckbox();

//click on register cta
		rs.registerView();
		rs.register();
		
//cleanup
		//rs.cleanup();
	}
}
