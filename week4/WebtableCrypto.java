package week4;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class WebtableCrypto {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
    ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://finance.yahoo.com/");
		Thread.sleep(3000);
		WebElement market= driver.findElement(By.linkText("Markets"));
		Thread.sleep(3000);
		Actions action = new Actions(driver);
		action.moveToElement(market).perform();
		Thread.sleep(3000);
		WebElement crypto = driver.findElement(By.xpath("//div[@class='_yb_7zamgg' and text()='Crypto']"));
		action.click(crypto).perform();

		Thread.sleep(3000);
		List<WebElement> rowtotal = driver.findElements(By.xpath("//table[@class='markets-table freeze-col yf-paf8n5 fixedLayout']/tbody/tr"));
		int rowCount = rowtotal.size();
		System.out.println("The Row Count is  "+rowCount);
		System.out.println("*****Names******");
		List<WebElement> cryptoNames = driver.findElements(By.xpath("//table[@class='markets-table freeze-col yf-paf8n5 fixedLayout']/tbody/tr/td[2]"));

		for (WebElement element : cryptoNames) {
			System.out.println(element.getText());
		}
		
		
		
		
		

	}

}