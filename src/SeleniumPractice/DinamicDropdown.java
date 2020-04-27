package SeleniumPractice;

import java.io.InterruptedIOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DinamicDropdown {
	public static void main(String[] args)throws InterruptedException {  //we use Thread.sleep(method);
		  System.setProperty("webdriver.chrome.driver", "C:/Users/Rita/Pictures/chromedriver.exe");
	        WebDriver driver=new ChromeDriver();
	        driver.get("https://www.spicejet.com/");
	        driver.manage().window().maximize();
	        
	        
	        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXTaction")).click();//FROM option
	        driver.findElement(By.xpath("//a[@value='KQH']")).click();
	      driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1"));//TO option,   Chenai exists in both FROM and TO
	        Thread.sleep(2000L);
	       driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();//if there are two same elements, put xpath in parenthesis and
	                                                    // add index of element you want in square brackets 
	       //or use parent chlid relationshiop xpath
	       // driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();  
	                                                                                       //there is space between parent and child
	       
	       //select current date in calendar
	       driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
	       
	        Thread.sleep(2000L);
	        driver.close();
	}
}
