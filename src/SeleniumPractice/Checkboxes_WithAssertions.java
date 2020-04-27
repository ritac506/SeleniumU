package SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Checkboxes_WithAssertions {
	public static void main(String[] args) throws InterruptedException {
		
		//Assertions are brought by TestNG, to verift actual and expected results
		
		  System.setProperty("webdriver.chrome.driver", "C:/Users/Rita/Pictures/chromedriver.exe");
	        WebDriver driver=new ChromeDriver();
	        driver.get("https://www.spicejet.com/");
	        driver.manage().window().maximize();
	        
	        // in css selector, * shows the the value contains this text, but it is not complete
	        //we verify that checkbox is selected
	        
	        //lets use assertions, inside the parenthesis is expected false, if true than code fails
	        Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
	        System.out.println( driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());//before-false
	        driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
	        Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
	        System.out.println( driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());//after-true
	        
	        //count number of all checkboxes
	        //first find common locator and then count
	   
	        System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());//6 plural elementS
	        
	        Thread.sleep(2000L);
	        
	        driver.close();
	}

}
