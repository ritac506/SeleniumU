package SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alert_RahulPracticeSite {

	public static void main(String[] args) throws InterruptedException {

		String text = "Rita";// this text I will send into alert box

		System.setProperty("webdriver.chrome.driver", "C:/Users/Rita/Pictures/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		driver.findElement(By.id("name")).sendKeys(text);
		driver.findElement(By.cssSelector("#alertbtn")).click();

		// handle alerts, when accepting
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		Thread.sleep(2000L);

		// dismissing alert
		driver.findElement(By.id("confirmbtn")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().dismiss();
		Thread.sleep(2000L);

		driver.close();

	}
}
