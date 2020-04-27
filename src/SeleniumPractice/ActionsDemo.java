package SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class ActionsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:/Users/Rita/Pictures/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");	
		
		//we create Actions object for mouse actions
		Actions a=new Actions(driver);//we put driver object in arguments for driver to know Actions capabilities
		
		//this action locates to a specific element
		WebElement move=driver.findElement(By.cssSelector("a[id='nav-link-accountList']"));//accounts and lists button
		
		//this action moves to 'move' element and hovers over, (optional) contextClick performs right click button action
		a.moveToElement(move).contextClick().build().perform();
		
		//moves to Search box and holding shift button enters the hello word, it will insert capital letters, (optional) double click highlights the words
		a.moveToElement(driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"))).
		                                                     click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
		
		//drag and drop action

		

	}

}
