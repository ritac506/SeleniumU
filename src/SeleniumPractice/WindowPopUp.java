package SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class WindowPopUp {
	
	public static void main(String[] args) {//difference between window authentification pop up and alert:
		//alert handled with driver.switchTo().alert().(accept(), dissmiss(),getText and so on)
		//window authentication: credentiials provided in url that are then passed to pop up window.
		
		
		
		System.setProperty("webdriver.chrome.driver", "C:/Users/Rita/Pictures/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://admin:admin@the-internet.herokuapp.com/");	
		driver.findElement(By.linkText("Basic Auth")).click();
		WebElement message=driver.findElement(By.xpath("//p[contains(text(),'Congratulations! You must have the proper credenti')]"));
		Assert.assertEquals(message, "Congratulations! You must have the proper credentials.");
	} 

}
