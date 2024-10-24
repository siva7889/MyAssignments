package assignments.selenium;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FacebookRegistration {

	public static void main(String[] args) {
		
		// browser launch to hit facebook url
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://en-gb.facebook.com/");
		driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		// Create Account
        
        driver.findElement(By.linkText("Create new account")).click();
        WebElement firstname =driver.findElement(By.xpath("//input[@name='firstname']"));
        firstname.sendKeys("Siva");
     
        WebElement lastname =driver.findElement(By.xpath("//input[@name='lastname']"));
        lastname.sendKeys("sankari");
        
        WebElement mobile =driver.findElement(By.xpath("//input[@name='reg_email__']"));
        mobile.sendKeys("046656566");
        
        WebElement newpassword = driver.findElement(By.xpath("//input[@type='password']"));
        newpassword.sendKeys("Siva@123");
        
        //Select Dateofbirth
        
        WebElement dayid = driver.findElement(By.id("day"));
        Select day = new Select(dayid);
        day.selectByVisibleText("11");
        
        WebElement monthname = driver.findElement(By.id("month"));
        Select month = new Select(monthname);
        month.selectByValue("3");
        
        WebElement yearname = driver.findElement(By.id("year"));
        Select year = new Select(yearname);
        year.selectByValue("1940");
        
        driver.findElement(By.xpath("//label[text()='Female']")).click() ;
        
        // close the browser
        driver.close();
		
      
        }
        
		
	}
	
	

