package SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class e2e {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:/Users/Rita/Pictures/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.spicejet.com/");
		driver.manage().window().maximize();

		// choosing where from
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		WebElement from = driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT"));

		from.sendKeys("MUMbai");
		from.sendKeys(Keys.ARROW_DOWN);
		from.sendKeys(Keys.ENTER);

		// choosing where to
		// it goes straight to TO search box
		driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();
		WebElement to = driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT"));

		to.sendKeys("RAJ");
		// to.sendKeys(Keys.ARROW_DOWN);
		to.sendKeys(Keys.ENTER);

		// select current date in calendar
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();

		// select round trip calendar radio button,we asserting that when one way is
		// selected second calendar is Not Enabled
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
		if ((driver.findElement(By.id("Div1")).getAttribute("style")).contains("1")) {
			Assert.assertTrue(true);
			System.out.println("passed");
		} else {
			Assert.assertTrue(false);
			System.out.println("failed");
		}
		Thread.sleep(2000L);

		// dropdodwn passengers
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000L);

		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());// before

		Select s = new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Adult")));
		s.selectByValue("4");

		// dropdown currency
		Select s1 = new Select(
				driver.findElement(By.xpath("//select[@name='ctl00$mainContent$DropDownListCurrency']")));

		s1.selectByValue("USD");
		// s1.selectByIndex(2);
		// s1.selectByVisibleText("AED");

		// in css selector, * shows the the value contains this text, but it is not
		// complete
		// we verify that checkbox is selected

		// lets use assertions, inside the parenthesis is expected false, if true than
		// code fails
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());// before-false
		driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());// after-true

		// count number of all checkboxes
		// first find common locator and then count

		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());// 6 plural elementS

		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());// after

		// lets assert
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "4 Adult");

		Thread.sleep(2000L);

		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();

		driver.close();

	}

}
