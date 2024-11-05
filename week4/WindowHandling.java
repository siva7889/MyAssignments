package week4;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandling {

	
	public static void main(String[] args) throws InterruptedException {
		
		
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("http://leaftaps.com/opentaps/control/login");
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
	    // Locate the Contact us link and click	
				driver.findElement(By.linkText("Contacts")).click();
				// Locate the Merge Contacts link and click		
				driver.findElement(By.linkText("Merge Contacts")).click();
				//Locate the from widget
			
				WebElement Fromwidget = driver.findElement(By.xpath("(//img[@src='/images/fieldlookup.gif'])[1]"));
				Fromwidget.click();
				Set<String> allWindowHandles = driver.getWindowHandles();
				Iterator<String> it =allWindowHandles.iterator();
			    String parentWindowHandle = it.next();
				String childWindowHandle = it.next();
			    System.out.println("parentWindowHandle" +parentWindowHandle);
				System.out.println("childWindowHandle" +childWindowHandle);
		        driver.switchTo().window(childWindowHandle);
				Thread.sleep(5000);
				driver.findElement(By.xpath("(//table[@class='x-grid3-row-table']/tbody/tr[1]/td[1]/div)[1]")).click();
				Thread.sleep(3000);
				driver.switchTo().window(parentWindowHandle);
				    
				//Locate the to widget
				
				
				WebElement Towidget = driver.findElement(By.xpath("(//img[@src='/images/fieldlookup.gif'])[2]"));
				Towidget.click();
				Set<String> allWindowHandles1 = driver.getWindowHandles();
				Iterator<String> it1 =allWindowHandles1.iterator();
			    String parentWindowHandle1 = it1.next();
				String childWindowHandle1 = it1.next();
			    System.out.println("parentWindowHandle" +parentWindowHandle1);
				System.out.println("childWindowHandle" +childWindowHandle1);
		        driver.switchTo().window(childWindowHandle1);
				//Locate the contact
				Thread.sleep(5000);
				driver.findElement(By.xpath("(//table[@class='x-grid3-row-table']/tbody/tr[1]/td[1]/div)[2]")).click();
				  driver.switchTo().window(parentWindowHandle1);
				//Submit Merge
				driver.findElement(By.linkText("Merge")).click();
				
				//Alert Interface
				Alert alert = driver.switchTo().alert();
				alert.accept();
				
				// verify the title of the page
				Thread.sleep(2000);
				
				String title = driver.getTitle();
			System.out.println("title of the parent window  : " +title);
				
				
		
		
		
	}
	
	
}
