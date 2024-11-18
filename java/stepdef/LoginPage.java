package stepdef;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPage extends ProjectSpecificMethod {
	
	//ChromeDriver driver;
	
	@Given("Set the Environment")
	public void set_the_environment() {
		driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/");
		    driver.manage().window().maximize();
	 
	}

	@Given("Enter the username as {string}")
	public void enteusernameCred(String uname) {
		  driver.findElement(By.id("username")).sendKeys(uname);
	   
	}

	@Given("Enter the password as {string}")
	public void enterpasswordCred(String pwd) {
		driver.findElement(By.id("password")).sendKeys(pwd);
	   
	}

	@When("Click on the login button")
	public void clickloginButton() {
		driver.findElement(By.className("decorativeSubmit")).click();
	  
	}

	@Then("Verify the login is successful")
	public void verifyLogin() {
		  System.out.println(driver.getTitle());
	   
	}

	
	
	
	
}
