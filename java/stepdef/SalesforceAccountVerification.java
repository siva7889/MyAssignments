package stepdef;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SalesforceAccountVerification extends ProjectSpecificMethod{
	
	
	@Given("Set the Environments")
	public void set_the_environment() {
		
		options = new ChromeOptions();
		options.addArguments("disable-notifications");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.id("username")).sendKeys("dilip@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("leaf@2024");
		driver.findElement(By.id("Login")).click();
	 
	}


	@When("Click on toggele button")
	public void click_on_toggele_button() throws InterruptedException {
		driver.findElement(By.xpath("//button[@title='App Launcher']//div")).click();
		Thread.sleep(2000);
	}

	@When("Click on Viewall")
	public void click_on_viewall() throws InterruptedException {
		driver.findElement(By.xpath("(//button[@class='slds-button'])[2]")).click();
		Thread.sleep(2000);
	}

	@When("Click on Sales from Applauncher")
	public void click_on_sales_from_applauncher() throws InterruptedException {
		WebElement sales=driver.findElement(By.xpath("//p[text()='Manage your sales process with accounts, leads, opportunities, and more']"));
		driver.executeScript("arguments[0].click()", sales);
		Thread.sleep(3000);
	}

	@When("Click on Accounts tab")
	public void click_on_accounts_tab() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		WebElement accounts=driver.findElement(By.xpath("//span[text()='Accounts']/parent::a"));
		driver.executeScript("arguments[0].click()", accounts);
		Thread.sleep(2000);
	}

	@When("New button")
	public void new_button() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//div[@title='New']")).click();
		Thread.sleep(2000);
	}

	@Given("name as account name")
	public void name_as_account_name() throws InterruptedException {
		driver.findElement(By.xpath("//label[text()='Account Name']/following::input")).sendKeys("Siva sankari");
		Thread.sleep(3000);
	}

	@Given("Ownership as Public")
	public void ownership_as_public() throws InterruptedException {
		WebElement ownership=driver.findElement(By.xpath("(//button[contains(@class,'slds-combobox__input slds-input_faux')])[4]"));
		driver.executeScript("arguments[0].click()", ownership);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Public']")).click();
		Thread.sleep(5000);
	}

	@When("Click on Save")
	public void click_save() throws InterruptedException {
		WebElement save = driver.findElement(By.xpath("(//button[@class='slds-button slds-button_brand'])[3]"));
		//save.click();
	   driver.executeScript("arguments[0].click()",save);
		Thread.sleep(5000);
		
	}

	@Then("Verify Account Name")
	public void verify_account_name() {
		
		String Accountname=driver.findElement(By.xpath("//lightning-formatted-text[@slot='primaryField']")).getText();
		System.out.println("The account Name is "+Accountname);
		
		if(Accountname.equalsIgnoreCase("Siva sankari"))
		{
			System.out.println("Hurray  " +Accountname+ " is expected name !!");
			
		}
		else
		
			System.out.println("Oops " +Accountname+ "is incorrect.");
			
		
		
	}

	
	
}
	
	
	
	
	

