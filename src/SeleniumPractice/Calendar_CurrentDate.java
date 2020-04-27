package SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Calendar_CurrentDate {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		 System.setProperty("webdriver.chrome.driver", "C:/Users/Rita/Pictures/chromedriver.exe");
	        WebDriver driver=new ChromeDriver();
	        driver.get("https://www.spicejet.com/");
	        driver.manage().window().maximize();
	        
	        driver.findElement(By.className("ui-datepicker-trigger")).click();
	        
	        //select current date in calendar
		       driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
		       
		       //select round trip calendar radio button,we asserting that when one way is selected second calendar is Not Enabled
		       driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		       System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
		       if((driver.findElement(By.id("Div1")).getAttribute("style")).contains("1")) {
		    	   Assert.assertTrue(true);
		    	   System.out.println("passed");
		       }
		       else {
		    	   Assert.assertTrue(false);
		    	   System.out.println("failed");
		       }
		       Thread.sleep(2000L);
		    	   
		    	   //select again one way ticket radio button
		       //asserting again second calendar disabled
		    	   driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();
		    	   if((driver.findElement(By.id("Div1")).getAttribute("style")).contains("1")) {
			    	   Assert.assertTrue(false);
			    	   System.out.println("failed");
			       }
			       else {
			    	   Assert.assertTrue(true);
			    	   System.out.println("passed");
			       }
		    	   
		           
			        Thread.sleep(2000L);
			        
			       driver.close();

		    	   
		       }
		       
		
	}



