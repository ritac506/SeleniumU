
package SeleniumPractice;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChildWindows {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:/Users/Rita/Pictures/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
        driver.get("http://the-internet.herokuapp.com/windows");	

		
		driver.findElement(By.xpath("//a[text()='Click Here']")).click();
		
		//before switching
		System.out.println("Before Switching");
		//when request getTitle, it gives only parent window title, not child window
		System.out.println(driver.getTitle());
		
		//to handle child windows we set Set of Strings with their ids
		Set <String> ids=driver.getWindowHandles();
		
		
		//for that we use Iterator to traverse inside the set from parent to child window
		Iterator<String> it=ids.iterator();
		
		//we are triversing and declaring ids to the windows
		String parentId=it.next();
		
		String childId=it.next();
		
		//switch from parent to child window, we put id of the window
		driver.switchTo().window(childId);
		
		System.out.println("After Switching");
		
		//now we can print getTitle of child window
		System.out.println(driver.getTitle());
		
		//going back to parent window
		driver.switchTo().window(parentId);
		System.out.println("Switching back to parent");
		System.out.println(driver.getTitle());

		
		//driver.quit();

		

	}

}
