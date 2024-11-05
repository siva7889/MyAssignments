package week4;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnWebElementMethods {

	public static void main(String[] args) {
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/input.xhtml");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		String placeholder = driver.findElement(By.id("j_idt88:name")).getAttribute("placeholder");
		System.out.println("Placeholder is "+placeholder);
		
		boolean enabled = driver.findElement(By.xpath("//h5[text()='Verify if text box is disabled']/following::div")).isEnabled();
		System.out.println("The text field is enabled "+enabled);
		
		
		WebElement textEditor = driver.findElement(By.xpath("//h5[text()='Text Editor']/following::input"));
		boolean displayed = textEditor.isDisplayed();
		System.out.println("The Text editor element is displayed? "+displayed);
//		textEditor.click();
		
		driver.get("https://www.amazon.in/");
		
		driver.findElement(By.linkText("About Amazon")).click();
		
		driver.get("https://www.leafground.com/checkbox.xhtml");
		WebElement basicCheckBox = driver.findElement(By.id("j_idt87:j_idt89_input"));
		boolean selected = basicCheckBox.isSelected();
		System.out.println("Is the checkbox selected? "+selected);
		WebElement ajaxCheckBox = driver.findElement(By.id("j_idt87:j_idt91_input"));
		//JavaScript Click
		driver.executeScript("arguments[0].click()",ajaxCheckBox );
		System.out.println("<-----------------After Click------------>");
		selected = basicCheckBox.isSelected();
		System.out.println("Is the checkbox selected? "+selected);
		

	
	
	}
}
