package SeleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tables {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:/Users/Rita/Pictures/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(
				"https://www.cricbuzz.com/live-cricket-scorecard/20752/bcbxi-vs-wi-two-day-practice-match-windies-tour-of-bangladesh-2018");
 int sum=0;
 
		// first find the parent of the specific table and put it in variable "table"
		WebElement table = driver.findElement(By.cssSelector("div[class='cb-col cb-col-100 cb-ltst-wgt-hdr']"));

		// here we use 'table' object to find common class element of that row in our
		// specific table
		int rowcount = table.findElements(By.className("div[class='cb-col cb-col-100 cb-scrd-itms']")).size();
		// System.out.println(rowcount);

		// now we traiverse to the nth child
		int count = table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)"))
				.size();
		System.out.println(count);// it gives us count of all the rows except the last two

		for (int i = 0; i < count - 2; i++) {// we add -2, to remove the last two outputs in console
			// we iterate through all the rows and third item R in each row
			System.out.println(
					table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)"))
							.get(i).getText());
			
				String value=table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)"))
							.get(i).getText();
				//to convert String to integer and sum up all the numbers in the R column and validating the sum
				int valueInteger=Integer.parseInt(value);
				sum=sum+valueInteger;
		}
		System.out.println(sum);//298
		

		// now we locate 'Extra' row and triverse to next sibling (the number 5 in that row)
		System.out.println(driver.findElement(By.xpath("//div[text()='Extras']/following-sibling::div")).getText());//5
		String extras=driver.findElement(By.xpath("//div[text()='Extras']/following-sibling::div")).getText();
		//convert string to integer
		int extrasValue=Integer.parseInt(extras);
		//now sum the rows and extras
		int totalValue=sum+extrasValue;
		System.out.println(totalValue);
		
		//locate 'total' and sibling (total number 303)
		System.out.println(driver.findElement(By.xpath("//div[text()='Total']/following-sibling::div")).getText());//303
		
		//to validate actual total value
		String actualValue=driver.findElement(By.xpath("//div[text()='Total']/following-sibling::div")).getText();
		int actualTotalValue=Integer.parseInt(actualValue);
		if(actualTotalValue==totalValue) {
			System.out.println("correct value");
		}
		else {
			System.out.println("wrong output");
		}
	}

}
