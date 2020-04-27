package SeleniumPractice;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class Fluent_Wait {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 Sample usage:      interface Wait<> ------> implementing classes :FluentWait, WebDriverWait

   // Waiting 30 seconds for an element to be present on the page, checking
   // for its presence once every 5 seconds.
   Wait wait = new FluentWait(driver)
       .
   WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
     public WebElement apply(WebDriver driver) {
       return driver.findElement(By.id("foo"));
     }
   });
 
		 */
		
		System.setProperty("webdriver.chrome.driver", "C:/Users/Rita/Pictures/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/dynamic_loading/1");
		
		//So webdriver will look for 10 times for webelement during 30 seconds
		 Wait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(3)).
				                                               ignoring(NoSuchElementException.class);
		 
		
		driver.findElement(By.xpath("//*[@id='start']/button")).click();
		
		 //unlike Webdriver wait, we need to bild customize wait for fluent wait
		
		 WebElement foo = (WebElement) wait.until(new Function<WebDriver, WebElement>() {
			 
		 
		     public WebElement apply(WebDriver driver) {
		    	 
		       if( driver.findElement(By.xpath("//*[@id='finish']/h4")).isDisplayed()){
		    	   return driver.findElement(By.xpath("//*[@id='finish']/h4"));   //Hello world message
		       }else {
		    	   return null;
		       
		     }
		     
		     }});
		System.out.println(driver.findElement(By.xpath("//*[@id='finish']/h4")).getText());
		driver.close();
	

	}

}
