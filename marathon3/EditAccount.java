package marathon3;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import week6.ReadExcel;

import java.io.IOException;
import java.time.Duration;

public class EditAccount extends ProjectSpecificMethod {

@Test(dataProvider="testData",dependsOnMethods = {"marathon3.CreateAccount.createAccounts"})
	 public  void editAccounts(String accountName ,String bilingStreet, String shipingStreet)throws InterruptedException {
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
        WebElement accountsTab = driver.findElement(By.xpath("//a[@title='Accounts']"));
        driver.executeScript("arguments[0].click()",accountsTab);
        driver.findElement(By.xpath("//input[@placeholder='Search this list...']")).sendKeys(accountName+ Keys.ENTER);
        Thread.sleep(3000);
        driver.findElement(By.xpath("//table[contains(@class,'slds-table forceRecordLayout')]/tbody[1]/tr[1]/th[1]/span[1]/a[1]")).click();
        driver.findElement(By.xpath("//span[text()='Show more actions']/parent::button")).click();
       
        driver.findElement(By.xpath("//span[text()='Edit']")).click();
        WebElement typeDD = driver.findElement(By.xpath("//button[@aria-label='Type']"));
        driver.executeScript("arguments[0].click()",typeDD);
        driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Technology Partner']")).click();
        WebElement industryDD = driver.findElement(By.xpath("//button[@aria-label='Industry']"));
        driver.executeScript("arguments[0].click()",industryDD);
        driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Healthcare']")).click();
        WebElement biilingStreet = driver.findElement(By.xpath("//label[text()='Billing Street']/following::textarea"));
        biilingStreet.clear();
        biilingStreet.sendKeys(bilingStreet);
        WebElement shippingStreet = driver.findElement(By.xpath("//label[text()='Shipping Street']/following::textarea"));
        shippingStreet.clear();
        shippingStreet.sendKeys(shipingStreet);
        WebElement priorityDD = driver.findElement(By.xpath("//button[@aria-label='Customer Priority']"));
        driver.executeScript("arguments[0].click()",priorityDD);
        driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Low']")).click();
        driver.findElement(By.xpath("//button[@aria-label='SLA']")).click();
        driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Silver']")).click();
        WebElement activeDD = driver.findElement(By.xpath("//button[@aria-label='Active']"));
        driver.executeScript("arguments[0].click()",activeDD);
        driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='No']")).click();
        int randomNum1 = (int)(Math.random()*999999);
        int randomNum2 = (int)(Math.random()*999999);
        String phno = ""+randomNum1+randomNum2;
        phno = phno.substring(0,10);
        System.out.println(phno);
        WebElement phnoField = driver.findElement(By.xpath("//input[@name='Phone']"));
        phnoField.clear();
        phnoField.sendKeys(phno);
        
        WebElement upsellOpportunityDD = driver.findElement(By.xpath("//button[@aria-label='Upsell Opportunity']"));
        driver.executeScript("arguments[0].click()",upsellOpportunityDD);
        driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='No']")).click();
        driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
        String phnoStr = driver.findElement(By.xpath("//table/tbody/tr[1]/td[4]")).getText();
        System.out.println(phnoStr);
        Assert.assertFalse(phnoStr.equalsIgnoreCase(phno),"verify the mobileNumber");



    }

@DataProvider(name="testData")

public String[][] sendData() throws InvalidFormatException, IOException

{
	
	String [][] data = ReadExcel2.readExcelData();
	return data;
	
	
	
}

}
