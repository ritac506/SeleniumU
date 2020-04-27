package SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestiveDropdown {
	public static void main(String[] args) throws InterruptedException {
		
		  System.setProperty("webdriver.chrome.driver", "C:/Users/Rita/Pictures/chromedriver.exe");
	        WebDriver driver=new ChromeDriver();
	        driver.get("https://www.spicejet.com/");
	        
	     // choosing where from
			driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
			WebElement from = driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT"));

			from.sendKeys("MUMbai");
			from.sendKeys(Keys.ARROW_DOWN);
			from.sendKeys(Keys.ENTER);

			// choosing where to
			// it goes straight to TO search box
			driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();
			WebElement to = driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT"));

			to.sendKeys("RAJ");
			// to.sendKeys(Keys.ARROW_DOWN);
			to.sendKeys(Keys.ENTER);
	   
	        
	       Thread.sleep(2000L);
	        driver.close();
	}

}
