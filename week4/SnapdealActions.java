package week4;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SnapdealActions {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
	    ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.snapdeal.com/");
		WebElement menu=driver.findElement(By.xpath("(//span[@class='catText'])[1]"));
		Actions action = new Actions(driver);
		action.moveToElement(menu).pause(2000).click().perform();
		driver.findElement(By.xpath("(//span[text()='Sports Shoes'])[1]")).click();
		String countOfshoes =driver.findElement(By.xpath("//span[@class='category-name category-count']")).getText();
		System.out.println("Total Count of Sports Shoes : "+countOfshoes);
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='sort-drop clearfix']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//ul[@class='sort-value']/li[2]")).click();
		
		List<String> price = new ArrayList<String>();
		Thread.sleep(5000);
		List<WebElement> sorted = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
		for(WebElement ele : sorted)
		{
			price.add(ele.getText());
			
			
		}
		System.out.println(price);
		
		    WebElement slider = driver.findElement(By.xpath("//div[@class='filter-price-slider ui-slider ui-slider-horizontal ui-widget ui-widget-content ui-corner-all']"));
		    Actions action1 = new Actions(driver);
		   action1.dragAndDropBy(slider, 30, 0).build().perform();
		  WebElement brand= driver.findElement(By.xpath("//a[text()=' White & Blue']"));
		  driver.executeScript("arguments[0].click()", brand);
		   Actions action2 = new Actions(driver);
		   Thread.sleep(5000);
		   
		   String pricefilter=driver.findElement(By.xpath("(//a[@class='clear-filter-pill'])[1]")).getText();
		   System.out.println(pricefilter);
		   String colorfilter=driver.findElement(By.xpath("(//a[@class='clear-filter-pill  '])[1]")).getText();
		   System.out.println(colorfilter);
		   
		   if(pricefilter.contains("Rs. 2407 - Rs. 3550")&& colorfilter.contains("White & Blue"))
			   
		  {
			   System.out.println("Filters are selected successfully");
			   
		   }
		   
		   
		   WebElement quicklinks=driver.findElement(By.xpath("(//div[contains(@class,'clearfix row-disc')])[1]"));
		   Thread.sleep(5000);
		   action2.moveToElement(quicklinks).pause(2000).click().perform();
		   Thread.sleep(3000);
		   String tprice =driver.findElement(By.xpath("//span[@class='payBlkBig']")).getText();
		   System.out.println("Total price : "+tprice);
		   Thread.sleep(2000);
		   String offer =driver.findElement(By.xpath("//span[@class='percent-desc ']")).getText();
		   System.out.println("offer percentage : "+offer);
		   WebElement shoeSnap= driver.findElement(By.xpath("//ul[@id='bx-slider-qv-image-panel']"));
		   File screenshotAs = shoeSnap.getScreenshotAs(OutputType.FILE);
		   File desc= new File("./snaps/shoes.png");
		   FileUtils.copyFile(screenshotAs, desc);
		   System.out.println("Screenshot is captured successfully");
		    driver.close();
		    driver.quit();
		   
		   
		
		
	}
		

	}
