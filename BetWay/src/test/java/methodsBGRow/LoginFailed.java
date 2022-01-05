package methodsBGRow;

import org.openqa.selenium.By;

import PageObjectModel.BetWay.BasePage;

public class LoginFailed extends BasePage {
	
	//click on login in the header
		public void clickLogin() {  
			clickElement(By.id("login-username")); 
	   }

	//enter username into field
		public void enterLogin(String bgUsername) { 
			EnterText(By.id("login-username"), bgUsername); 
		}
		
	//click on password in the header
		public void clickPassword() { 
			clickElement(By.id("login-password")); 
		}
		
	//enter password into field
		public void enterPassword(String bgPassword) { 
			EnterText(By.id("login-password"), bgPassword); 
		}

	//click on login button
		public void clickLoginCTA() { 
			clickElement(By.xpath("//app-header/div[1]/div[2]/app-login[1]/div[1]/div[1]/button[1]")); 
		}
		
//Verify that invalid login credentials show 
		//check if svg is visible - meaning user is logged in 	
		public boolean loginFailureDetailsIncorrect() {
			boolean loginFailureDetailsIncorrect = driver.findElement(By.xpath("//app-header/div[1]/div[2]/app-login[1]/div[3]")).isDisplayed();
			return loginFailureDetailsIncorrect;
		}


		public void cleanup() { 
			driver.quit();

		}
}
