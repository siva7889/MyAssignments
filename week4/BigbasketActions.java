package week4;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class BigbasketActions {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
    ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.bigbasket.com/");
		driver.findElement(By.xpath("(//span[text()='Category'])[2]")).click();
		Thread.sleep(3000);
		WebElement food = driver.findElement(By.linkText("Foodgrains, Oil & Masala"));
		Actions action = new Actions(driver);	
		action.moveToElement(food).pause(3000).click().perform();
		Thread.sleep(5000);
		WebElement rice = driver.findElement(By.xpath("//a[text()='Rice & Rice Products']"));
		action.moveToElement(rice).pause(3000).click().perform();
		Thread.sleep(2000);
		WebElement ricetype = driver.findElement(By.linkText("Boiled & Steam Rice"));
		action.moveToElement(ricetype).pause(2000).click().perform();
		Thread.sleep(3000);
		WebElement click =driver.findElement(By.xpath("//input[@id='i-BBRoyal']"));
		driver.executeScript("arguments[0].click()",click);
		Thread.sleep(3000);
		WebElement boiledrice= driver.findElement(By.xpath("//h3[text()='Tamil Ponni Boiled Rice']"));
		driver.executeScript("arguments[0].click()",boiledrice);
		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> iterator = windowHandles.iterator();
		String parentwindohandle=iterator.next();
		System.out.println("parentwindowhandle " +parentwindohandle);
		String childwindohandle=iterator.next();
		System.out.println("childwindowhandle " +childwindohandle);
		driver.switchTo().window(childwindohandle);
		Thread.sleep(3000);
		WebElement item =driver.findElement(By.xpath("(//div[@class='flex flex-col items-start justify-start w-full p-2.5'])[5]"));
		driver.executeScript("arguments[0].click()",item);
		Thread.sleep(3000);
		String price = driver.findElement(By.xpath("//table/tr[1]/td[1]")).getText();
		System.out.println("Price of the rice " +price);
		driver.findElement(By.xpath("(//button[text()='Add to basket'])[1]")).click();
		Thread.sleep(3000);
		String message =driver.findElement(By.xpath("//p[@class='mx-4 flex-1']")).getText();
		System.out.println(message);
		Thread.sleep(2000);
		File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
	    File dest= new File("./snaps/rice.png");
	    FileUtils.copyFile(screenshotAs, dest);
	    System.out.println("Screenshot is captured successfully");
	    driver.close();
	    driver.quit();
		
		
		
		
		

	}

}