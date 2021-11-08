package PageObjectModel.BetWay;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	//Declare the WebDriver
		public static WebDriver driver; 
		

		//Constructor of the base class   
			//a constructor is used to initialize objects
			public BasePage() { 
				if (driver == null) { 
					//get parameter values
					String browser = getDataConfigProperties("browser"); 
					String systemUnderTestBG = getDataConfigProperties("systemUnderTestBG"); 
					String pdriverDir = getDataConfigProperties("driverdir"); 
//					String pdriverDirFireFox = getDataConfigProperties("driverdirFireFox");
//					String pdriverDirEdge = getDataConfigProperties("driverdirEdge"); 
	//chrome				
					//check if parameter passed as "chrome" 
					if (browser.equalsIgnoreCase("chrome")) { 
						//set path to chromedriver.exe
						System.setProperty("webdriver.chrome.driver", pdriverDir+"chromedriver.exe");
						
						//create an instance of chrome 
						driver = new ChromeDriver();
						driver.get(systemUnderTestBG);
//						
						driver.manage().window().maximize();
						driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
					}
					
	//firefox
					//check if parameter passed as "firefox"
					if (browser.equalsIgnoreCase("FireFox")) { 
						//set path to geckodriver.exe
						System.setProperty("webdriver.gecko.driver", pdriverDir+"geckodriver.exe");
						
						//create an instance of firefox 
						driver = new FirefoxDriver();
						driver.get(systemUnderTestBG);
						driver.manage().window().maximize();
						driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
					}
					
	//edge
					//check if parameter passed as "Edge"
					if (browser.equalsIgnoreCase("Edge")) { 
						//set path to msedgedriver.exe
						System.setProperty("webdriver.edge.driver", pdriverDir+"msedgedriver.exe");
						
						//create an instance of firefox 
						driver = new EdgeDriver();
						driver.get(systemUnderTestBG);
						driver.manage().window().maximize();
						driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
					}
				}
			}
			
	//Create a method to read the config
		public String getDataConfigProperties(String propertyName) { 
			//properties set up
			Properties p = new Properties (); 
			InputStream is = null; 
					
			try { 
				is = new FileInputStream("config.properties");
			} catch (FileNotFoundException e) { 
				e.printStackTrace();
			} 
			
			try { 
				p.load(is); 
			} catch (IOException e) { 
				e.printStackTrace();
			} 
			return p.getProperty(propertyName);
		} 

		
		
	//properties set

		

		

		
	//Create a method to wait for Element
		public void waitForElement(int elementWait, By pLocator) { 
			WebDriverWait wait = new WebDriverWait(driver,elementWait); 
			wait.until(ExpectedConditions.visibilityOfElementLocated(pLocator)); 
		}
		
	//Create a method to wait for the URL 
		public void waitForUrl(int elementWait, String pLocator) { 
			WebDriverWait wait = new WebDriverWait(driver,elementWait); 
			wait.until(ExpectedConditions.urlContains(pLocator));
		}
		
	//Create a method to wait for Click
		public void waitForClick(int elementWait, By pLocator) { 
			WebDriverWait wait = new WebDriverWait(driver,elementWait);
			wait.until(ExpectedConditions.elementToBeClickable(pLocator)); 
		}
		
	//Create a method to get Element Text
		public String getElementText(By pLocator) { 
			waitForElement(30, pLocator); 
			String h1 = getElement(pLocator).getText();
			return h1; 
		}
		
		
	//Create a method to get Element	
		public WebElement getElement(By pLocator) { 
			waitForClick(30, pLocator);
			return driver.findElement(pLocator); 
		}
		
	//Create a method to click Element
		public void clickElement(By pLocator) { 
			waitForClick(60, pLocator);
			getElement(pLocator).click(); 
		}
		
	//Create a method to Enter Text
		public void EnterText(By pLocator, String pText) { 
			waitForClick(30, pLocator); 
			driver.findElement(pLocator).sendKeys(pText); 
		}
		
		
	//Create a method to select the drop down 
		public void selectDropDown(By pLocator, String pValue) { 
			//creates an instance of the dropdown object
			Select sDrpDown = new Select (getElement(pLocator)); 
			//Populates the dropdown
			sDrpDown.selectByVisibleText(pValue); 
		}
	 
	//Create a method to handle tables
		public void tablesDemo() { 
			
			//to locate the table on the page
			WebElement myTable = getElement(By.xpath("//tbody")); 
			
			//to locate rows of table
			List<WebElement> rows_table = myTable.findElements(By.tagName("tr"));
			
			//to calculate number of rows in table
			int rows_count = rows_table.size(); 
			
			//loop will execute until the last row of table
			for (int row = 0; row <rows_count; row++) { 
				
				//to locate columns/cells of that specific row 
				List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName("td"));
				
				//to calculate number of columns/cells in that specific row 
				int columns_count = Columns_row.size(); 
				System.out.println("Number of cells in row: " + row + " are " + columns_count);
				
				//loop will execute until the last cell of that specific row
				for (int column = 0; column < columns_count; column++) { 
					
					//to retrieve text from that specific cell 
					String celText = Columns_row.get(column).getText(); 
					System.out.println("Cell value of row number: " + row + " and column number " + column + " is: " + celText); 
				}
			}
		}
		
	//Clean up (close the browser) 
		public void cleanup() { 
			driver.quit();
		}
		
	}


