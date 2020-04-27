package SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class assignment_autosuggestiveDropDown_JS_Executor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:/Users/Rita/Pictures/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");

		driver.findElement(By.id("autocomplete")).sendKeys("ind");
		driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
		System.out.println(driver.findElement(By.id("autocomplete")).getText());

		JavascriptExecutor js = (JavascriptExecutor) driver;
		String script = "return document.getElementById(\"autocomplete\").value;";
		String text = (String) js.executeScript(script);
		System.out.println(text);

		int i = 0;

		while (!text.equalsIgnoreCase("INDia")) {
			driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);

			text = (String) js.executeScript(script);
			System.out.println(text);
			if (i > 10) {
				break;
			}
		}
		if (i > 10) {
			System.out.println("element not found");
		}

	}

}
