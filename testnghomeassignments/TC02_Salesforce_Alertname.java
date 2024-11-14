package testnghomeassignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TC02_Salesforce_Alertname extends ProjectSpecificMethod {

	
	
	@Test
	public void tc2Alert() throws InterruptedException
	
	
	{
		driver.findElement(By.xpath("//button[@title='App Launcher']//div")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//button[@class='slds-button'])[2]")).click();
		Thread.sleep(3000);
		
		
		WebElement legal=driver.findElement(By.xpath("//p[text()='Legal Entities']"));
		driver.executeScript("arguments[0].click()", legal);
		Thread.sleep(3000);
		WebElement upron=driver.findElement(By.xpath("//span[text()='Legal Entities List']/parent::a"));
		upron.click();
		//driver.executeScript("arguments[0].click()", upron);
		
		
		
		WebElement legalEntity=driver.findElement(By.xpath("//span[text()='New Legal Entity']"));
		driver.executeScript("arguments[0].click()", legalEntity);
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@class='slds-input'])[3]")).sendKeys("Testleaf");
		driver.findElement(By.xpath("(//textarea[@part='textarea'])[2]")).sendKeys("Salesforces");
		WebElement status=driver.findElement(By.xpath("//button[contains(@class,'slds-combobox__input slds-input_faux')]"));
		driver.executeScript("arguments[0].click()", status);
	    driver.findElement(By.xpath("//span[@title='Active']")).click();
		driver.findElement(By.xpath("//button[@class='slds-button slds-button_brand']")).click();
		String alertMessage = driver.findElement(By.xpath("//div[text()='Complete this field.']")).getText();
		String message=alertMessage.stripLeading();
		System.out.println(message);
		
		String alertMessage1 = message.replaceAll("^(.*\\n){1}", "");
		System.out.println(alertMessage1);
						
		if(alertMessage1.equalsIgnoreCase("Complete this field."))
			
		{
			System.out.println("This is valid alert Message : " +alertMessage1);
		}
		
		else
			
			System.out.println("Oops ! Please check your code : " +alertMessage1);
	}
	
	
	
	
}
