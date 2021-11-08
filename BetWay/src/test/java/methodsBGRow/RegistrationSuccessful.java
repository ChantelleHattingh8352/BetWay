package methodsBGRow;

import org.openqa.selenium.By;

import PageObjectModel.BetWay.BasePage;

public class RegistrationSuccessful extends BasePage {

//Open registration form
	public void registrationForm() { 
		clickElement(By.id("login-open-register"));
	}
	
//click on first name field
	public void firstNameClick() { 
		clickElement(By.id("register-first-name")); 
	}
	
//enter data into first name field
	public void firstNameEnter(String firstName) { 
		EnterText(By.id("register-first-name"), firstName); 
	}
	
//click on surname field
	public void surnameClick() { 
		clickElement(By.id("register-surname"));
	}
	
//enter data into surname field
	public void surnameEnter(String surname) { 
		EnterText(By.id("register-surname"), surname); 
	}
	
//enter data into email field
	public void emailClick() { 
		clickElement(By.id("register-email")); 
	}
	
//enter data into email field
	public void emailEnter(String email) { 
		EnterText(By.id("register-email"), email); 
	}
	
//
}
