package SeleniumPractice;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Screenshot {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		

		System.setProperty("webdriver.chrome.driver", "C:/Users/Rita/Pictures/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");	
		
		//we casting driver to TakesScreenshot
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		//now we need to give path to see that file with the screenshot 
		FileUtils.copyFile(src,new File("C:\\Users\\Rita\\screenshot.png"));
		//go to that file to view screenshot

	}

}
