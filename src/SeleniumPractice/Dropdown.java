package SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Dropdown {
	


public static void main(String[] args) throws InterruptedException{		

	
	        System.setProperty("webdriver.chrome.driver", "C:/Users/Rita/Pictures/chromedriver.exe");
	        WebDriver driver=new ChromeDriver();
	        driver.get("https://www.spicejet.com/");
	        
	       
	        //dropdown currency
	       Select s =new Select(driver.findElement(By.xpath("//select[@name='ctl00$mainContent$DropDownListCurrency']")));
	       
	        s.selectByValue("USD");
	        //s.selectByIndex(2);
	        //s.selectByVisibleText("AED");
	     
	        
	        //dropdodwn passengers
	        driver.findElement(By.id("divpaxinfo")).click();
	        Thread.sleep(2000L);

	        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());//before
	        
	        Select s1=new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Adult")));
	        s1.selectByValue("4");
	        
	        /*
	         if there is option to choose number by clicking a few times, use while, forloop
	         int i=1;
	         while(i<5){
	         driver.findElement(By.id("...").click();
	         i++;
	         }
	         or
	         for(int i=1; i<5;i++){
	         driver.findElement(By.id("...").click();
	         }
	         */
	        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());//after
	        
	        //lets assert
	        Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "4 Adult");
	        
	        Thread.sleep(2000L);
	        driver.close();
	        

	    }

	}


