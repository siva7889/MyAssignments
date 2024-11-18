package stepdef;

import org.openqa.selenium.By;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateLead extends ProjectSpecificMethod{

	@When("Click on the cmsrf link")
	public void click_on_the_cmsrf_link() {
		driver.findElement(By.linkText("CRM/SFA")).click();
        

	}

	@When("Click on Lead")
	public void click_on_lead() {
		driver.findElement(By.linkText("Leads")).click();
	   
	}

	@When("Click on CreateLead")
	public void click_on_create_lead() {
		driver.findElement(By.linkText("Create Lead")).click();
	    
	}

	@Given("Enter the fname as {string}")
	public void enter_the_fname_as_siva(String fname) {
		driver.findElement(By.xpath("//input[@id='createLeadForm_firstName']")).sendKeys(fname);	   
	}

	@Given("Enter the lname as {string}")
	public void enter_the_lname_as_sankari(String lname) {
		driver.findElement(By.xpath("//input[@id='createLeadForm_lastName']")).sendKeys(lname);
	   
	}

	@Given("Enter the cname as {string}")
	public void enter_the_cname_as_testleaf(String cname) {
		driver.findElement(By.xpath("//input[@id='createLeadForm_companyName']")).sendKeys(cname);
	   
	}
	
	@Given("Enter the phno as {string}")
	public void enter_the_phno_as_testleaf(String phno) {
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(phno);
	   
	}

	@When("Click on submit")
	public void click_on_submit() {
		driver.findElement(By.name("submitButton")).click(); 
	  
	}

	@Then("Verify the leadid and verify the fname as {string}")
	public void verify_the_leadid(String fname) {
		String leadid = driver.findElement(By.id("viewLead_companyName_sp")).getText().replaceAll("[^0-9]", "");
		System.out.println(leadid);
		String fnameActual=driver.findElement(By.id("viewLead_firstName_sp")).getText();
		if(fname.contains(fnameActual))
			
		{
			System.out.println("valid fname " +fnameActual);
			
		}
		else
			
			System.out.println("valid fname " +fnameActual);
		
	   
	}
	
	
}
	
	

