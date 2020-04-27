package SeleniumPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Frames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:/Users/Rita/Pictures/chromedriver.exe");
		WebDriver driver = new ChromeDriver();		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);		
        driver.get("https://jqueryui.com/droppable/");	
        
        
        //to know how many frames are on HTML page
        System.out.println(driver.findElements(By.tagName("iframe")).size());//findElementS plural   
        
        
        //if there are more than one iframe, to switch to iframe use index (starts with 0, 1, 2...)
        driver.switchTo().frame(0);//0 is our first and only frame        
     
        
        //we locate the frame our locator is in first
        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class='demo-frame']")));
    
        //now we identify our draggable webelement we want to drag
        WebElement draggable=driver.findElement(By.cssSelector("div[id='draggable']"));
        
        //identify droppable webelement 
       WebElement droppable= driver.findElement(By.id("droppable"));          
        
        //now we create the object to perform drag and drop of our webelement
        Actions a=new Actions(driver);
        
        a.dragAndDrop(draggable, droppable).build().perform();
        
        //if we want to perform outside the frame, switch to default content
        driver.switchTo().defaultContent();
        
        
     driver.close();
        


	}

}
