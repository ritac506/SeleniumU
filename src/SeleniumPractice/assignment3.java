package SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class assignment3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		System.setProperty("webdriver.chrome.driver", "C:/Users/Rita/Pictures/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		WebDriverWait w = new WebDriverWait(driver, 5);
		
		driver.get("http://www.itgeared.com/demo/1506-ajax-loading.html");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[text()='Click to load get data via Ajax!']")).click();
		System.out.println(w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='results']"))).getText());
		driver.close();
	}

}
