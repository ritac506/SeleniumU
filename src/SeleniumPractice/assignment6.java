package SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class assignment6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:/Users/Rita/Pictures/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
		//1.select any checkbox
		  String option=driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[2]")).getText();
		  driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[2]/input")).click();

		
		//2. grab the label if the selected checkbox// put into variable
		  WebElement dropdown=driver.findElement(By.id("dropdown-class-example"));
		  
		
		//3. select an option in dropdown. Here option to select should come from step2
		  Select s=new Select(dropdown);
		
		//4. enter the step2 grabbed label text in editbox
		    s.selectByVisibleText(option);
		    
		    //entering text of the option into text box
		    driver.findElement(By.name("enter-name")).sendKeys(option);

		
		//5. click alert and then certify if text grabbed from step3 is present in the pop up message
		    
	        driver.findElement(By.id("alertbtn")).click();

	     String text=driver.switchTo().alert().getText();

	     if(text.contains(option))

	     {

	    System.out.println("Alert message success");

	     }

	     else

	    System.out.println("Something wrong with execution");

	}

	       

	       

	     //  System.out.println( driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[2]")).getText());   

	       

	}


