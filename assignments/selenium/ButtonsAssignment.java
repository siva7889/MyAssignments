package assignments.selenium;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ButtonsAssignment {
	
	public static void main(String[] args) {
		
		
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://leafground.com/button.xhtml");
		driver.manage().window().maximize();
		
		// To verify the page title
		
		driver.findElement(By.xpath("//span[text()='Click']")).click();
		String title = driver.getTitle();
		System.out.println(title);
		String Expectedresult = "Dashboard";
		//assert.assertEquals(title, Expectedresult);
		
		if(title.contains(Expectedresult))
		    //Pass
		    System.out.println("Page title contains " +Expectedresult);
		else
		    //Fail
		    System.out.println("Page title doesn't contains " +Expectedresult);
		
		driver.navigate().back();
		
		
		// To verify the Disabled state
		boolean enabled = driver.findElement(By.xpath("//span[text()='Disabled']")).isEnabled();
		
		if(enabled==true)
			
			System.out.println("Confirm if the button is disabled ? No, its enabled");
		
		else
		
			System.out.println("Confirm if the button is disabled ? yes, its disabled");
		
		
	// To check the position of the Submit Button
	
	Point location = driver.findElement(By.xpath("//span[text()='Submit']")).getLocation();
	System.out.println("The position of the Submit Button is " +location);
	
	// To check the color of the Save Button
	WebElement Save= driver.findElement(By.xpath("//span[text()='Save']"));
	String bgcolor= Save.getCssValue("color");
	System.out.println("The color of the Save Button is " +bgcolor);
	
	// To check the height and width of the submit button
	Dimension size = driver.findElement(By.xpath("(//span[text()='Submit'])[2]")).getSize();
	
	
	System.out.println("The width and height of the Submit Button is "+"width " +size.getWidth() +" height "+size.getHeight());
	
	
	
	
}
}