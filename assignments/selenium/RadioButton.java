package assignments.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButton {

	public static void main(String[] args) {
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://www.leafground.com/radio.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		WebElement browser = driver.findElement(By.xpath("//table[@id='j_idt87:console1']"));
		browser.click();
		browser.click();
		
		// To select the browser Radio button
		
		boolean selected = browser.isSelected();
		
		if(selected == true)
			
			System.out.println("Radio Button is selected");
		
		else
		
		System.out.println("Radio Button is not selected");
		
		// To select the Age Radio button
		
		WebElement age = driver.findElement(By.xpath("//div[@id='j_idt87:age']/div[1]/div[2]/div[1]/div[2]"));
		
		boolean selected2 = age.isSelected();
	     
		if(selected2 == true)
			
			System.out.println("Age Radio Button is selected by defualt");
		
		else
			
			age.click();
		
		 System.out.println("Age Radio Button is selected");
		
		
		driver.close();
		
	}
	
	
	
	
	
}
