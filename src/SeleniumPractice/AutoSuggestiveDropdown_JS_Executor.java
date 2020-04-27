package SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.w3c.dom.Document;

public class AutoSuggestiveDropdown_JS_Executor {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		System.setProperty("webdriver.chrome.driver", "C:/Users/Rita/Pictures/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://ksrtc.in/oprs-web/");	
		driver.manage().window().maximize();
		
		
		//locating textbox, sending letters in
		driver.findElement(By.name("fromPlaceName")).sendKeys("ben");
		Thread.sleep(2000L);
		
		//in autosuggestive menu going downs
		driver.findElement(By.id("fromPlaceName")).sendKeys(Keys.DOWN);
	
		System.out.println(	driver.findElement(By.id("fromPlaceName")).getText());
		
		//we cannot locate in HTML items in suggestive dropdown list, so we need JS Executor for HIDDEN elements
		//for that we use JavaScript DOM
		//first we investigate the object for hidden elements
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		//instead of driver we use document
		
		//also in order to print the string value put word 'return' in front
		String script="return document.getElementById(\"fromPlaceName\").value;";
		                                  //can't have double quotes inside double quotes
		                                  //value is instead of getText()
		String text=(String) js.executeScript(script);
		System.out.println(text);
		
		//in case there is no such name we use limit on the iteration
		int i=0;
		//now we need to validate that the text equals to BENGALURU INTERNATION AIPPORT
		while(!text.equalsIgnoreCase("BENGALURU INTERNATION AIRPORT")) {
			driver.findElement(By.id("fromPlaceName")).sendKeys(Keys.DOWN);		
			
			text=(String) js.executeScript(script);
			System.out.println(text);
			if(i>10) {
				break;
			}
		}
		if(i>10) {
			System.out.println("element not found");
		}
			
		}
		
		
	}


