package assignments.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class EditLead {
	
	
	public static void main(String[] args) throws InterruptedException {
		
	
	
	// To Launch the browser
			ChromeDriver driver = new ChromeDriver();

			// To load the url
			driver.get("http://leaftaps.com/opentaps/");

			// To maximize the window
			driver.manage().window().maximize();

			// Locate the Element username , ctrl+2, l
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

			// To get the title
			String title = driver.getTitle();
			// Print the title
			System.out.println(title);

			//Locate the Leads tab and click
			driver.findElement(By.linkText("Leads")).click();
			
			//Locate the Create Lead from shortcut menu and click
			driver.findElement(By.linkText("Create Lead")).click();
			
			//Locate the Company name filed and enter TestLeaf
			driver.findElement(By.xpath("//input[@id='createLeadForm_companyName']")).sendKeys("Emirates");
			
			//Locate the first name field and enter your name
			driver.findElement(By.xpath("//input[@id='createLeadForm_firstName']")).sendKeys("siva111");
			
			//Locate the last name filed and enter your last name
			driver.findElement(By.xpath("//input[@id='createLeadForm_lastName']")).sendKeys("Sankari veerappan");
			
			
			driver.findElement(By.xpath("//input[@id='createLeadForm_firstNameLocal']")).sendKeys("Sai");
			
			
			driver.findElement(By.xpath("//input[@id='createLeadForm_departmentName']")).sendKeys("Software tech");
			Thread.sleep(1000);
			
			driver.findElement(By.name("description")).sendKeys("Enter the description");
			
			driver.findElement(By.xpath("//input[@id='createLeadForm_primaryEmail']")).sendKeys("primaryemail@grr.la");
			
			
			//Locate Source Dropdown and Select State
				//Step1: Locate the Dropdown Element
			WebElement stateid = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
				//Step2: Create object for Select and pass WebElement reference inside the constructor
			Select state = new Select(stateid);
				//step3: Use select methods to select value
			state.selectByVisibleText("New York");
			
			
			
			//Locate the Create Lead button and click
			driver.findElement(By.className("smallSubmit")).click();
			
			//Locate the Lead Id and print it 
			String leadID = driver.findElement(By.id("viewLead_companyName_sp")).getText();
			System.out.println(leadID);
			// Edit the lead
			Thread.sleep(1000);
			driver.findElement(By.linkText("Edit")).click();
			driver.findElement(By.name("description")).clear();
			driver.findElement(By.name("importantNote")).sendKeys("This is the department update v1");
		
			driver.findElement(By.className("smallSubmit")).click();
			
			System.out.println(driver.getTitle());
			
			
			// To close the browser
			driver.close();
	
	}

}
