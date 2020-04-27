package SeleniumPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class HTTPS_Certifications {

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		

		System.setProperty("webdriver.chrome.driver", "C:/Users/Rita/Pictures/chromedriver.exe");
		
		
		//ssl certifications (when there is as additional action to be needed before page is loaded, ex:accept on warning to proceed anyway)
		
		//general profile
		DesiredCapabilities dc= DesiredCapabilities.chrome();
		dc.acceptInsecureCerts();
		//or
		//dc.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);
		//dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		
		//create chromeOptions object
		//belongs to local browser and gives all the options to chrome browser
		ChromeOptions co=new ChromeOptions();
		co.merge(dc);
		
		WebDriver driver = new ChromeDriver(co);
		driver.get("");	
		
		//Below link has detailed information on how to handle SSL certification in multiple browsers
		//http://learn-automation.com/handle-untrusted-certificate-selenium/

	}

}
