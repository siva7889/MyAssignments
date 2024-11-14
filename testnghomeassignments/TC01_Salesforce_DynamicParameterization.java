package testnghomeassignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC01_Salesforce_DynamicParameterization extends ProjectSpecificMethod {

	
	
	@Test(dataProvider="EntityName")
	public void tc1Entityname(String ename) throws InterruptedException
	
	
	{
		
		driver.findElement(By.xpath("//button[@title='App Launcher']//div")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[@class='slds-button'])[2]")).click();
		Thread.sleep(2000);
		WebElement legal=driver.findElement(By.xpath("//p[text()='Legal Entities']"));
		driver.executeScript("arguments[0].click()", legal);
		
		driver.findElement(By.xpath("//div[@title='New']")).click();
		driver.findElement(By.xpath("//label[text()='Legal Entity Name']/following::input")).sendKeys(ename);
		driver.findElement(By.xpath("//button[@class='slds-button slds-button_brand']")).click();
		String entityName=driver.findElement(By.xpath("//lightning-formatted-text[@slot='outputField']")).getText();
		if(entityName.equalsIgnoreCase("Salesforce Automation by Sivasankari"))
			
		{
			
			System.out.println("Legal Entity Name is matched with the " +entityName);
			
		}
		
		else
			System.out.println("Legal Entity Name is unmatched with the " +entityName);
		
	}
	

	@DataProvider(name="EntityName")
	
	public String[][] entityName()
	
	{
		
		String [][] data = new String[1][1];
		data[0][0] = "Salesforce Automation by Sivasankari";
		return data;
		
		
	}
	
}
