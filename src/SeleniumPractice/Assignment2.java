package SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment2 {
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:/Users/Rita/Pictures/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.cleartrip.com/");
		driver.manage().window().maximize();

		driver.findElement(By.id("DepartDate")).click();
		driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[1]/table/tbody/tr[6]/td[2]/a"))
				.sendKeys(Keys.ENTER);

		Select s = new Select(driver.findElement(By.id("Adults")));
		s.selectByValue("4");

		Select s2 = new Select(driver.findElement(By.id("Childrens")));
		s2.selectByValue("2");

		driver.findElement(By.xpath("//a[@id='MoreOptionsLink']")).click();

		driver.findElement(By.id("AirlineAutocomplete")).sendKeys("indigo");

		driver.findElement(By.id("SearchBtn")).click();

		System.out.println(driver.findElement(By.id("homeErrorMessage")).getText());

		Thread.sleep(2000L);
		driver.close();

	}

}
