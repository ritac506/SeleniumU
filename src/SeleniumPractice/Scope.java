package SeleniumPractice;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scope {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:/Users/Rita/Pictures/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
		//this code here is not hardcoded and depended on linknames, it is written on tagnames, 
		                                //so changing the content of the page won't affect the code
		
		//1. How to calculate the links count on the ENTIRE page 
		//a
		System.out.println(driver.findElements(By.tagName("a")).size());//27
		
		//count the links located in the foot section (the bottom)
		//i need to limit the scope to that section
		//create subset of the driver
		
		//2. First locate element of entire foot section and assign to footerDriver variable.  We have foot scope now	
		WebElement footerDriver=driver.findElement(By.id("gf-BIG"));
		
		//now we count links in foot section, footDriver is now sub driver (our limited scope)
		System.out.println(footerDriver.findElements(By.tagName("a")).size());//20
		
		//3. Count the links only in the first column of the footer section
		//first locate the whole column from sub driver (footerDriver)
		//and traverse down to the links, then assign to another sub sub driver (columnDriver- inside the footer), then count links		
		
		WebElement columnDriver=footerDriver.findElement(By.cssSelector("div[id='gf-BIG'] table tbody tr td "));
		System.out.println(columnDriver.findElements(By.tagName("a")).size());
		
		//4. Click on each link in the column and check if the pages opening
		//assume the section is dynamic, it can change the number of links anytime
		for(int i=1; i<columnDriver.findElements(By.tagName("a")).size();i++) {
			
			
			//this optimization concept will let you to click on all links and open them in separate tabs
			String clickOnLinksTab=Keys.chord(Keys.CONTROL,Keys.ENTER);
			columnDriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinksTab);
		}
			//now go to each tab and print the title
			Set<String>tabs=driver.getWindowHandles();
			
			//iterator will help to move from wondow to window and print title		
			Iterator<String> it=tabs.iterator();
			
			while(it.hasNext()) {
				
				driver.switchTo().window(it.next());
				System.out.println(driver.getTitle());
				
			}
			driver.quit();
			
		}
		
		
		

	}


