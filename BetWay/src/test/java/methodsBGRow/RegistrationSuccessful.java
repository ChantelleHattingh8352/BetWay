package methodsBGRow;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import PageObjectModel.BetWay.BasePage;

public class RegistrationSuccessful extends BasePage {

//Accept cookie policy
	public void cookiePolicyClick() { 
		clickElement(By.xpath("//app-root/app-cookie-bar/div[@class='l-container-fluid snackbar']//div[@class='u-text--center']/button[2]"));
	}
	
//Open registration form
	public void registrationForm() { 
		clickElement(By.id("login-open-register"));
	}
	
//click on first name field
	public void firstNameClick() { 
		clickElement(By.id("firstName")); 
	}
	
//enter data into first name field
	public void firstNameEnter(String firstName) { 
		EnterText(By.id("firstName"), firstName); 
	}
	
//click on surname field
	public void surnameClick() { 
		clickElement(By.id("lastName"));
	}
	
//enter data into surname field
	public void surnameEnter(String surname) { 
		EnterText(By.id("lastName"), surname); 
	}
	
//click on email field
	public void emailClick() { 
		clickElement(By.id("emailAddress")); 
	}
	
//enter data into email field
	public void emailEnter(String email) { 
		EnterText(By.id("emailAddress"), email); 
	}

	
//click on mobile field
	public void mobileClick() {
		clickElement(By.id("mobileNumber")); 
	}
	
//enter data into mobile field
	public void mobileEnter(String mobile) { 
		EnterText(By.id("mobileNumber"), mobile);
	}
	
//click on dropdown list and select Bulgaria

	
	public void nationalityDropDown() { 
		Select nDropDown = new Select(driver.findElement(By.id("nationality")));
		nDropDown.selectByVisibleText("България");
	}

// This  will scroll down the page by  1000 pixel vertical		
    public void scrollPin() { 
    	WebElement element = driver.findElement(By.id("idNumber"));
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    } 
	
//click on PIN field
	public void pinClick() { 
		clickElement(By.id("idNumber"));
	}
	
//enter data into PIN field
	public void pinEnter(String pin) { 
		EnterText(By.id("idNumber"), pin); 
	}
	
//click on DOB day dropdown list and select day
	public void dobDropDownDay() { 
		Select dobDropDownDay = new Select (getElement(By.xpath("//select[@id='register-dob-day']")));
		dobDropDownDay.selectByValue("23");
	}
	
//click on DOB month dropdown list and select month
	public void dobDropDownMonth() { 
		Select dobDropDownMonth = new Select (getElement(By.xpath("//select[@id='register-dob-month']"))); 
		dobDropDownMonth.selectByValue("4");
	}
	
//click on DOB year dropdown list and select year
	public void dobDropDownYear() { 
		Select dobDropDownYear = new Select (getElement(By.xpath("//select[@id='register-dob-year']")));
		dobDropDownYear.selectByValue("1993");
	}
	
//click on currency dropdown and select currency BG Lev
	public void currencyDropDown() { 
		Select dobDropDownDay = new Select (getElement(By.id("currency")));
		dobDropDownDay.selectByVisibleText("Български лев");
	}
	
//scroll to address input field
    public void scrollAddress() { 
    	Actions act = new Actions(driver);
    	act.sendKeys(Keys.PAGE_UP).build().perform();
    } 
    
//click on address input field
	public void addressClick() { 
		clickElement(By.id("address1")); 
	}
	
//enter data into address field
	public void addressEnter(String address) { 
		EnterText(By.id("address1"), address); 
	} 
	
//click on city input field
	public void cityClick() { 
			clickElement(By.id("city"));
		}
	
//enter random data into city input field
	public void cityEnter(String city) { 
		EnterText(By.id("city"), city);
	}
	
//click on res code input field
	public void codeClick() {
		clickElement(By.id("code"));
	}
	
//enter random data into code input field
	public void codeEnter(String code) { 
		EnterText(By.id("code"), code);
	} 
	
//click on username input field
	public void usernameClick() { 
		clickElement(By.id("userName"));
	}
	
//enter random date into username input field
	public void usernameEnter(String username) { 
		EnterText(By.id("userName"), username); 
	}
	
//click password
	public void passwordClick() { 
		clickElement(By.xpath("//input[starts-with(@id,'password')]"));
	}
	
//enter password - use value "casino123456!" 
	public void passwordEnter(String password) { 
		EnterText(By.xpath("//input[starts-with(@id,'password')]"), password); 
	}
	
//click on confirm password
	public void confirmPasswordClick() { 
		clickElement(By.xpath("//input[starts-with(@id,'confirmPassword')]"));
	}
	
//enter confirm password
	public void confirmPasswordEnter(String confirmPasswordEnter) { 
		EnterText(By.xpath("//input[starts-with(@id,'confirmPassword')]"), confirmPasswordEnter);
	}
	

	
//click on over18 Checkbox 
	public void legalAgeCheckBoxClick() {
			WebElement element = driver.findElement(By.id("legalAge"));
			
			Actions builder = new Actions(driver);
				Action mouseOverHome = builder 
						.moveToElement(element)
								.click().build();
			mouseOverHome.perform();
		clickElement(By.xpath("//*[@id=\"header-form-register-account\"]/div[3]/div/div[4]/plg-field-builder-v2/checkbox"));
	}
	
//click on accept terms checkbox
	public void acceptTermsCheckbox() { 
		System.out.println("hi im here acceptterms");
		WebElement element = driver.findElement(By.id("acceptterms"));
		
		Actions builder = new Actions(driver);
			Action mouseOverHome = builder 
					.moveToElement(element)
							.click().build();
		mouseOverHome.perform();
		System.out.println("hi im here acceptterms 2");

	}

//scroll page down
	public void scrollDownPage() { 
		System.out.println("im here scroll");
		((JavascriptExecutor)driver).executeScript("scroll(0,400");
		
	}
	
//click on accept marketing messages
	public void acceptMarketingCheckbox() { 
		WebElement element = driver.findElement(By.id("acceptMarket"));
		
		Actions builder = new Actions(driver);
			Action mouseOverHome = builder 
					.moveToElement(element)
							.click().build();
		mouseOverHome.perform();
		
		System.out.println("im here marketingcbox"); 
		
	}
	
//scroll register to view
    public void registerView() { 
    	WebElement element = driver.findElement(By.id("signUp"));
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);    	
    }
    
//click on register cta
	public void register() {
		clickElement(By.id("signUp")); 
	}
} 
