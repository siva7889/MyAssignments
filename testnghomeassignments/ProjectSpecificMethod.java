package testnghomeassignments;

import java.sql.Driver;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ProjectSpecificMethod {
	
	public ChromeDriver driver; // Global declaration for the driver 
	
	@Parameters({"url","username","password"})
	@BeforeMethod
	public void preCondition(String url, String username, String password)
	
	
	{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-notifications");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("Login")).click();
		
	}
	
	
	@AfterMethod
public void postCondition()
	
	
	{
		
		driver.close();
		
		
	}
	
	
	

}
