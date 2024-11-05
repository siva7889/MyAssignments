package week4;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonActions {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		

		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro",Keys.ENTER);
		WebElement price = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]"));
		System.out.println("Price of Oneplus : "+price.getText());
		WebElement ratings = driver.findElement(By.xpath("(//span[@class='a-icon-alt'])[1]"));
		System.out.println("Ratings for Oneplus : "+ratings.getText());
		driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();
		//Window handels
		Set<String> windowhandles = driver.getWindowHandles();
		 Iterator<String> iterator = windowhandles.iterator();
	       String parentwindowhandle = iterator.next();
		    System.out.println("parentwindowhandle " +parentwindowhandle);
			String childwindowhandle = iterator.next();
			System.out.println("childwindowhandle " +childwindowhandle);
			driver.switchTo().window(childwindowhandle);
			
			// Takescreenshot
			
			WebElement productImage = driver.findElement(By.id("imgTagWrapperId"));
			File screenshotAs = productImage.getScreenshotAs(OutputType.FILE);
		
			File des = new File("./snaps/oneplusimage.png");
			FileUtils.copyFile(screenshotAs, des);	
			System.out.println("Screenshot taken successfully");
			
			driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
			Thread.sleep(3000);
			WebElement Subtotal = driver.findElement(By.xpath("//span[@id='attach-accessory-cart-subtotal']"));
			Thread.sleep(3000);
			System.out.println("Subtotal of the Oneplus product " +Subtotal.getText());
			
			driver.quit();
			
			
			
			
	}
		
		
		
		
		
		
	}