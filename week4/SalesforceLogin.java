package week4;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SalesforceLogin {

	public static void main(String[] args) throws IOException {
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		WebElement usernameFiled = driver.findElement(By.id("username"));
		WebElement passwordField = driver.findElement(By.id("password"));
		
		usernameFiled.sendKeys("gokul.sekar@testleaf.com");
		passwordField.sendKeys("Leaf@123");
		
		String enteredUsername = usernameFiled.getAttribute("value");
		String enteredPassword = passwordField.getAttribute("value");
		System.out.println("Username is "+enteredUsername);
		System.out.println("Password is "+enteredPassword);
		
		if(enteredUsername.equals("gokul.sekar@testleaf.com")) {
			System.out.println("The username is enterted correctly");
		}else {
			System.out.println("The username is invalid ");
		}

		if(enteredPassword.equals("Leaf@123")) {
			System.out.println("The password is enterted correctly");
		}else {
			System.out.println("The password is invalid ");
		}
		
		
		//Take Snap of the entire WebPage
		//step1: take snapshot
		File src = driver.getScreenshotAs(OutputType.FILE);
		//step2: location for the snapshot to store
		File desc = new File("./snaps/image2.png"); // .(dot) ---> represent current project
		//step3: move the snapshot to the file location
		FileUtils.copyFile(src, desc);
		
		WebElement loginField = driver.findElement(By.id("content"));
		File screenshotAs = loginField.getScreenshotAs(OutputType.FILE);
		File des = new File("./snaps/image1.png");
		FileUtils.copyFile(screenshotAs, des);
	}
	
}
