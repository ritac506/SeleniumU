package SeleniumPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class miscelaneous {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		System.setProperty("webdriver.chrome.driver", "C:/Users/Rita/Pictures/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");	
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//delete just one cookie give name of the cookie
		driver.manage().deleteCookieNamed("123");

	}

}
