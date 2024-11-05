package week4;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts {

	public static void main(String[] args) {
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://leafground.com/alert.xhtml");
		driver.manage().window().maximize();
	    driver.findElement(By.xpath("(//span[text()='Show'])[5]")).click();
		 Alert alert = driver.switchTo().alert();
		alert.sendKeys("Sivasankari");
		alert.accept();
		
		
		
	
	}
	
	
	
}
