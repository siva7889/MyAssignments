package week4;

import javax.xml.xpath.XPath;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frames {
	
	
	public static void main(String[] args) {
		
		
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
		driver.manage().window().maximize();
		
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	String text=driver.findElement(By.xpath("//p[@id='demo']")).getText();
	
	System.out.println(text);
	
	if(text.equalsIgnoreCase("You pressed OK!"))
		
	{
		System.out.println("Its expected, yes you're pressed");
	}
	
	else
		
		System.out.println("Sorry, you're not pressed");
	
	
	}
	
	
	
}
