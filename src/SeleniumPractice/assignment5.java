package SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class assignment5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:/Users/Rita/Pictures/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/");	
		
		 
		
		driver.findElement(By.linkText("Nested Frames")).click();	
		
		driver.switchTo().frame("frame-top");
		
		driver.switchTo().frame("frame-middle");
		
	
		System.out.println(driver.findElement(By.xpath("//*[text()='MIDDLE']")).getText());	
		driver.close();

	}

}
