package marathon3;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import testnghomeassignments.ProjectSpecificMethod;
import week6.ReadExcel;

import java.io.IOException;
import java.time.Duration;

public class DeleteAccount extends ProjectSpecificMethod {

@Test(dataProvider="testData",dependsOnMethods = {"marathon3.CreateAccount.createAccounts","marathon3.EditAccount.editAccounts"})

    public void deleteAccounts(String AccountName) throws InterruptedException {
      /*  ChromeOptions options = new ChromeOptions();
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
        driver.findElement(By.xpath("//input[@placeholder='Search this list...']")).sendKeys(AccountName+ Keys.ENTER);
        Thread.sleep(2000);
        String noOfItems = driver.findElement(By.xpath("//span[@aria-label='Recently Viewed']")).getText();
        String[] s = noOfItems.split(" ");
        int countBeforeDelete = Integer.parseInt(s[0]);
        driver.findElement(By.xpath("//table/tbody/tr[1]/td[6]")).click();
        Thread.sleep(2000);
        WebElement delete=driver.findElement(By.xpath("//div[text()='Delete']"));
        driver.executeScript("arguments[0].click()", delete);
		Thread.sleep(2000);
        
        
        driver.findElement(By.xpath("//button[@title='Delete']")).click();
        Thread.sleep(2000);
        noOfItems = driver.findElement(By.xpath("//span[@aria-label='Recently Viewed']")).getText();
        s = noOfItems.split(" ");
        System.out.println(s[0]);
        int countAfterDelete = Integer.parseInt(s[0]);

        Assert.assertTrue(countBeforeDelete==(countAfterDelete+1),"Verify the account has deleted");

    }

@DataProvider(name="testData")

public String[][] sendData() throws InvalidFormatException, IOException

{
	
	String [][] data = ReadExcel.readExcelData();
	return data;
	
	
	
}


}
