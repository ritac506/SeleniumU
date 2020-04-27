package SeleniumPractice;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class assignment4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:/Users/Rita/Pictures/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
        driver.get("http://the-internet.herokuapp.com/windows");
        
        driver.findElement(By.xpath("//a[text()='Click Here']")).click();
        
        Set <String> ids=driver.getWindowHandles();
        
        Iterator<String> it=ids.iterator();
        
        String parentId=it.next();
		
		String childId=it.next();
		
		driver.switchTo().window(childId);
		
		System.out.println(driver.findElement(By.xpath("//div[@class='example']/h3")).getText());
		
		driver.switchTo().window(parentId);
		
		System.out.println(driver.findElement(By.xpath("//*[@class='example']/h3")).getText());
		
		driver.close();
		
		
		
		

	}

}
