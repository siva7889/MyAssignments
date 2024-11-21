package marathon3;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import week6.ReadExcel;

import java.io.IOException;
import java.time.Duration;

public class CreateAccount extends ProjectSpecificMethod {

	@Test(dataProvider="testData")
    public  void createAccounts(String accountName)throws InterruptedException {
        /*ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://login.salesforce.com/");
        driver.findElement(By.id("username")).sendKeys("dilip@testleaf.com");
        driver.findElement(By.id("password")).sendKeys("leaf@2024");
        driver.findElement(By.id("Login")).click();*/
        driver.findElement(By.xpath("//button[@title='App Launcher']//div")).click();
        driver.findElement(By.xpath("//button[text()='View All']")).click();
        driver.findElement(By.xpath("//p[text()='Sales']/ancestor::a")).click();
        Thread.sleep(2000);
       WebElement account= driver.findElement(By.xpath("//span[text()='Accounts']/parent::a"));
       driver.executeScript("arguments[0].click()", account);
		Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@title='New']")).click();
       // String accountName = "Gokul";
        driver.findElement(By.xpath("//label[text()='Account Name']/following::input")).sendKeys(accountName);
        WebElement ownershipDD = driver.findElement(By.xpath("//button[@aria-label='Ownership']"));
        driver.executeScript("arguments[0].click()",ownershipDD);
        driver.findElement(By.xpath("//span[text()='Public']")).click();
        driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
        String toastMessage = driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")).getText();
        System.out.println(toastMessage);
        Assert.assertTrue(toastMessage.contains(accountName),"Verify the Account name");
    }

    
  @DataProvider(name="testData")

    public String[][] sendData() throws InvalidFormatException, IOException

    {
    	
    	String [][] data = ReadExcel.readExcelData();
    	return data;
    	
    	
    	
    }
    
}
