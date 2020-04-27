package SeleniumGrid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class RemoteTest {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub		
		
		//Desired Capabilities sets properties on which browser and on which operating system should we run the remote tests
		
		DesiredCapabilities dc=new DesiredCapabilities();//it is used when we run our test cases remotedly
		dc.setBrowserName("rediff.com");
		dc.setPlatform(Platform.WINDOWS);
		
		//now set the remote driver object
		WebDriver driver=new RemoteWebDriver(new URL("http://localhost:7777/wd/hub"),dc);//pass dc variable, so remote driver what browser and platform is used
		
		driver.get("http://google.com");
		
		//before we write any codes above, lets register hub and chrome node in cmd window
		
		//command in cmd   --->   java -jar selenium-server-standalone-3.141.59.jar -role hub -port 7777
		//nodes should register to nodes --->      http://192.168.0.27:7777/grid/register/
		
		//then open another cmd and do again  --->   
		//java -jar selenium-server-standalone-3.141.59.jar -role webdriver -hub http://192.168.0.27:7777/grid/register/
		// Nodes should register to http://192.168.0.27:7777/grid/register/
		
		//now pass chromedriver.exe file path to your remote node ---> it can be any browser
		//java -Dwebdriver.chrome.driver="chromedriver.exe" -jar selenium-server-standalone-3.141.59.jar -role webdriver -hub http://192.168.0.27:7777/grid/register/
		//The node is registered to the hub and ready to use
		
		//http://192.168.0.27:7777/grid/console  ---> put it in browser, you should see all the browsers instances in grid console
		                                                      // 11 instances (5 firefox, 5 chrome, 1 IE)
		
		//we add chromedriver.exe to the library
		//now we can run test
		//it will not in console but the link supposed to show in the node
		
		
		

	}

}
