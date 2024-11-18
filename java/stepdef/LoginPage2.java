package stepdef;

import org.openqa.selenium.By;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class LoginPage2 extends ProjectSpecificMethod {
	
	
	
	@Given("Enter the username as demo123")
	public void enterUsername() {
	    driver.findElement(By.id("username")).sendKeys("demo123");
	}   
	    @Given("Enter the password as crmsfa")
	    public void enter_the_password_as_crmsfa() {
	    	driver.findElement(By.id("password")).sendKeys("crmsfa");
	        
	    
	}
	
	@Then("Verify the login is Unsuccessful")
	public void verifyLogin() {
		  System.out.println(driver.getTitle());
	   
	}


}
