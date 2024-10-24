package assignments.selenium;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.Assertion;

public class DeleteLead {
	
	public static void main(String[] args) throws InterruptedException {
		
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

		driver.findElement(By.linkText("Leads")).click();
		
		driver.findElement(By.linkText("Find Leads")).click();
		
		driver.findElement(By.xpath("//span[contains(@class,'x-tab-strip-text ') and text()='Phone']")).click();
		                         
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("972426562145");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		String sRow = "1";

		String sCol = "1";
		
WebElement leadid	=driver.findElement(By.xpath("//table[@class='x-grid3-row-table']/tbody/tr["+sRow+"]/td["+sCol+"]"));

String lead =leadid.getText();
leadid.click();

System.out.println(lead);


		
		
		Thread.sleep(1000);
		driver.findElement(By.linkText("Delete")).click();
		Thread.sleep(1000);
		
		//Click "Find leads" again.
		driver.findElement(By.linkText("Find Leads")).click();
	// Enter the captured lead ID.
		driver.findElement(By.xpath("//span[contains(@class,'x-tab-strip-text ') and text()='Name and ID']")).click();
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(lead);
		
        
	
	// Click the "Find leads" button.
		
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		//Verify the presence of the message "No records to display" in the Lead List. This message confirms the successful deletion.
		
		String actual = driver.findElement(By.xpath("//div[text()='No records to display']")).getText();
		
		String expected="No records to display";
		
		if(actual==expected)
		{
			
			System.out.println("This message confirms the successful deletion.");
		}
		
		
		
		
		
		
	}

}
