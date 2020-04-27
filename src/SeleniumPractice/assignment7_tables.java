package SeleniumPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class assignment7_tables {
	
	public static void main(String[] args) {
		
	
	
	System.setProperty("webdriver.chrome.driver", "C:/Users/Rita/Pictures/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");	
	
	WebElement table=driver.findElement(By.id("product"));
	System.out.println(table.findElements(By.cssSelector("table[id='product'] tbody tr")).size());//number of rows
	
	System.out.println(table.findElements(By.cssSelector("table[id='product'] tbody tr th")).size());//number of columns
	
	WebElement secondRow=table.findElement(By.xpath("//table[@id='product']/tbody"));
      System.out.println(secondRow.findElement(By.xpath("//table[@id='product']/tbody/tr[3]/td[1]")).getText());
      System.out.println(secondRow.findElement(By.xpath("//table[@id='product']/tbody/tr[3]/td[1]/following-sibling::td[1]")).getText());
      System.out.println(secondRow.findElement(By.xpath("//table[@id='product']/tbody/tr[3]/td[1]/following-sibling::td[1]/following-sibling::td")).getText());
      
      
      
      //rahul
      WebElement table1=driver.findElement(By.id("product"));

      System.out.println(table1.findElements(By.tagName("tr")).size());

      System.out.println(table1.findElements(By.tagName("tr")).get(0).findElements(By.tagName("th")).size());

      List<WebElement> secondrow=table1.findElements(By.tagName("tr")).get(2).findElements(By.tagName("td"));
      
      System.out.println(secondrow.get(0).getText());

      System.out.println(secondrow.get(1).getText());

      System.out.println(secondrow.get(2).getText());
      }
      {
}
}
