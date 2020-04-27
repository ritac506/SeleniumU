package SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class assignment {
	public static void main(String[] args) throws InterruptedException {
		
		
		System.setProperty("webdriver.chrome.driver", "C:/Users/Rita/Pictures/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	        
	        driver.findElement(By.id("checkBoxOption1")).click();
	        Assert.assertTrue(driver.findElement(By.id("checkBoxOption1")).isSelected());
	        Thread.sleep(2000L);
	        
	        driver.findElement(By.id("checkBoxOption1")).click();
	        Assert.assertFalse(driver.findElement(By.id("checkBoxOption1")).isSelected());
	        
	        
	        //to count all checkboxes
	        System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
	        
	        driver.close();
	       
	        
	}

}
