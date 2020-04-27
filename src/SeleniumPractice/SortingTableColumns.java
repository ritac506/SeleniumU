package SeleniumPractice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class SortingTableColumns {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		System.setProperty("webdriver.chrome.driver", "C:/Users/Rita/Pictures/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");	
		
		//locate arrow on page
		driver.findElement(By.cssSelector("tr th:nth-child(2)")).click();
		driver.findElement(By.cssSelector("tr th:nth-child(2)")).click();//when clicked second time, it shows items in ascending order
		                                                           //so it matches validation at the end and test passes
		//if we don't click second time then test fail, or we do collections.reverse(copiedArray) to pass
		
		//retrieve all the webelements of fruit columns
		List<WebElement> firstColList=driver.findElements(By.cssSelector("tr td:nth-child(2)"));
		
		//grab text value
		ArrayList<String>originalArrayList=new ArrayList<String>();
		
		for(int i=0;i<firstColList.size();i++) {
			//grab each value of the list and put in original list //put everything in arraylist
			originalArrayList.add(firstColList.get(i).getText());
		}		
		
		//copy first arraylist1 and put in second arraylist2
		ArrayList<String>copiedList=new ArrayList<String>();
		
		for(int i=0;i<originalArrayList.size();i++) {
			copiedList.add(originalArrayList.get(i));
		}
		
		//sort second arraylist2  TO SORT WE USE COLLECTIONS METHOD
		Collections.sort(copiedList);
		//to reverse Array
		//Collections.reverse(copiedList);
	System.out.println("================================================copiedArray-sorted");	
	//enhanced loop is the same as forloop
		//try to use enhanced forloop for second array to compare with original
		for(String s: copiedList) {
			System.out.println(s); 
		}
		System.out.println("============================================originalArray");
		//enhanced loop for original array
		for(String s: originalArrayList) {
			System.out.println(s);
		}
		
		//validate second arraylist1 equals to first arraylist
		Assert.assertTrue(originalArrayList.equals(copiedList));
		
		
			
			

	}

}
