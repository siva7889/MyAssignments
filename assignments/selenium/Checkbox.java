package assignments.selenium;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Checkbox {

	
	public static void main(String[] args) throws InterruptedException {
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://leafground.com/checkbox.xhtml");
		driver.manage().window().maximize();
		WebElement basic = driver.findElement(By.xpath("//span[text()='Basic']"));
		basic.click();
		
		// To get the message of Notification checkbox
		
		
		WebElement notification = driver.findElement(By.xpath("//span[text()='Ajax']"));
		notification.click();
		Thread.sleep(5000);
		WebElement alert = driver.findElement(By.className("ui-growl-title"));
		System.out.println(alert.getText());
		if(alert.getText()== "Checked")
		{
        System.out.println("It is an expected message");
        
		}
        else
        {
        	System.out.println("It is an unexpected message");
        }
		// To get the tristate
		
		/*WebElement tristate = driver.findElement(By.xpath("(//div[@id='j_idt87:ajaxTriState']//div)[2]"));
		tristate.click();
		WebElement state = driver.findElement(By.xpath("//p[contains(text(),'State')]"));
		System.out.println(state.getText());
		*/
			
		
		// To select multiple checkbox
		
	
		
		WebElement checkbox = driver.findElement(By.xpath("//ul[@data-label='Cities']"));
	checkbox.click();
		/*WebElement miami = driver.findElement(By.xpath("//li[@data-item-value='Miami']"));
		miami.click();*///*[@id=\"j_idt87:multiple_panel\"]/div[2]/ul/li
		
		List<WebElement> elements = driver.findElements(By.xpath("ul[contains(@class,'ui-selectcheckboxmenu')]/li"));
		System.out.println(elements.size());
		
		

		
		for (int j = 0; j < elements.size(); j++) {
			String text2 = elements.get(j).getText();
			System.out.println(text2);

		}

		 
		
		
		
		
		
	}
	
	
	}
