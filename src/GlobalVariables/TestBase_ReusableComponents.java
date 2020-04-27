package GlobalVariables;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestBase_ReusableComponents {
	public WebDriver driver = null;

	@Test
	public void Login() throws IOException {

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\Rita\\eclipse-workspace\\IntroductionOfSeleniumUdemy\\src\\testNG_files\\datadriven.properties");
		prop.load(fis);
		System.out.println("I am first");
		
		if (prop.getProperty("browser").equals("chrome")) {
			driver = new ChromeDriver();
		} else if (prop.getProperty("browser").equals("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new InternetExplorerDriver();		
			
		}
		driver.get(prop.getProperty("URL"));
		
	}

	@Test
	public void Software() {
		System.out.println("I am the test");
	}

	@AfterSuite
	public void deinstall() {
		System.out.println("I am the last");
	}

}
