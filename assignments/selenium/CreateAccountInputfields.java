package assignments.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateAccountInputfields {
	
	
	

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
			driver.findElement(By.id("accountName")).sendKeys("Sivasankari");
			
			//Description - Enter as "Selenium Automation Tester"
			
			driver.findElement(By.name("description")).sendKeys("Selenium Automation Tester");
			
			driver.findElement(By.id("numberEmployees")).sendKeys("12");
			driver.findElement(By.id("primaryWebUrl")).sendKeys("Leaf Taps");
			

			driver.findElement(By.className("smallSubmit")).click();
			//Locate the Lead Id and print it 
			String Title = driver.getTitle();
			System.out.println(Title);
			driver.close();
		
			
			
	}
	
	

}
