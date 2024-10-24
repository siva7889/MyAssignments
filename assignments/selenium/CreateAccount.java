package assignments.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateAccount {
	
	public static void main(String[] args) {
		
	
	
	ChromeDriver driver = new ChromeDriver();
	

	driver.get("http://leaftaps.com/opentaps/");
	driver.manage().window().maximize();
	
	WebElement usernameField = driver.findElement(By.id("username"));
	// enter the username
	usernameField.sendKeys("democsr");

	// Locate the password element
	WebElement passwordField = driver.findElement(By.name("PASSWORD"));
	// enter the password
	passwordField.sendKeys("crmsfa");
	// Locate the Login button element
    WebElement loginButton = driver.findElement(By.className("decorativeSubmit"));
			// Click on the login button
			loginButton.click();

			// Locate the CRM/SFA link and click
			driver.findElement(By.linkText("CRM/SFA")).click();

			driver.findElement(By.linkText("Accounts")).click();
			driver.findElement(By.linkText("Create Account")).click();
			
			//Create Account - name
			driver.findElement(By.id("accountName")).sendKeys("Siva Testleaf");
			
			//Description - Enter as "Selenium Automation Tester"
			
			driver.findElement(By.name("description")).sendKeys("Selenium Automation Tester");
	
			//Select Industry
			
			WebElement industryid = driver.findElement(By.name("industryEnumId"));
			Select industry = new Select(industryid);
			industry.selectByIndex(3);
			
			//Select Ownership
			
			WebElement ownershipid = driver.findElement(By.name("ownershipEnumId"));
			Select ownership =  new Select(ownershipid);
			ownership.selectByVisibleText("S-Corporation");
			
			//Select Source
			
			WebElement sourceid = driver.findElement(By.id("dataSourceId"));
			Select source = new Select(sourceid);
			source.selectByValue("LEAD_EMPLOYEE");
			
		     //Select markettingid
			
			WebElement markettingid  = driver.findElement(By.id("marketingCampaignId"));
			Select marketting = new Select(markettingid);
			marketting.selectByIndex(7);
			

			//Select state
			WebElement stateid  = driver.findElement(By.id("generalStateProvinceGeoId"));
			Select state = new Select(stateid);
		    state.selectByValue("TX");
			
			// Submit
			
			driver.findElement(By.className("smallSubmit")).click();
			//Locate the Lead Id and print it 
			String Accountname = driver.findElement(By.className("requiredField")).getText();
			System.out.println(Accountname);
			if(Accountname.contains("Siva Testleaf"))
				
			
			{
				
				System.out.println("The Account name " +Accountname+  " is successfully created");
			}
			else 
			{
				System.out.println("Error with Account creation");
			}
				
				
			// To close the browser
			driver.close();
	
	}
}
