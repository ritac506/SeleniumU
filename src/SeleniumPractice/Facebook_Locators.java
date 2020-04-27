package SeleniumPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Facebook_Locators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// "C:\Users\Rita\Pictures\chromedriver.exe" it is where the file is saved

		// these steps are responsible for invoking the chrome browser
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rita\\Pictures\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("http://facebook.com");
		System.out.println(driver.getTitle());// validation the page title is correct
		System.out.println(driver.getCurrentUrl());// validation you landed on right url
		// driver.findElement(By.xpath("//*[@id='login-popup']/form/div[2]/a").click();
		driver.findElement(By.cssSelector("#loginbutton")).click();
		// System.out.println(driver.getPageSource()); // if right click is disabled to
		// inspect page sourse, print it in console
		// driver.get("http://google.com");
		// driver.navigate().back();
		// driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// driver.close();//closes current browser

		driver.quit();// closes all the browsers

	}

}
