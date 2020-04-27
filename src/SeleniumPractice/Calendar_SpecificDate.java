package SeleniumPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calendar_SpecificDate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		 System.setProperty("webdriver.chrome.driver", "C:/Users/Rita/Pictures/chromedriver.exe");
	        WebDriver driver=new ChromeDriver();
	        driver.get("https://www.path2usa.com/travel-companions");
	        driver.manage().window().maximize();
	        
	        //click on calendar
	        driver.findElement(By.id("travel_date")).click();
	        
	        //locating month (april)
	        while(!driver.findElement(By.cssSelector("th[class='datepicker-switch']")).getText().contains("May")){
	        	
	        	driver.findElement(By.cssSelector("th[class='next']")).click();
	        }
	        
	        //we find common class name for all days and put in list and iterate
	    //  List< WebElement> dates= (List<WebElement>) driver.findElement(By.className("day"));
	       
	       //lets say we want August18th
	       //go through each date
	       
	       int count=driver.findElements(By.className("day")).size();
	       for(int i=0;i<count;i++) {
	    	  String dateText=driver.findElements(By.className("day")).get(i).getText();
	    	   if(dateText.equalsIgnoreCase("21")) {
	    		   
	    		   driver.findElements(By.className("day")).get(i).click();
	    		   break;
	    	   }
	       }
	       driver.close();

	}

}
