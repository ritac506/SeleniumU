package SeleniumPractice;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Synchronization {

	public static void main(String[] args) {

		// we will copy the AddingItemsIntoCart.java class to add more code with waits

		System.setProperty("webdriver.chrome.driver", "C:/Users/Rita/Pictures/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// apply implicit wait method ----> it is applied on global level (for all
		// webelements) only once
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// lets apply explicit wait because it takes time to load promoCode
		// we create object
		WebDriverWait w = new WebDriverWait(driver, 5);

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

		// expected array
		String[] itemsNeeded = { "Cucumber", "Brocolli", "Beetroot", "Carrot" };// array is declared, items can be added
																				// any time

		addItems(driver, itemsNeeded);

		// clicking the cart buttonn
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();

		driver.findElement(By.xpath("//*[text()='PROCEED TO CHECKOUT']")).click();

		// putting condition for element to be visible
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));

		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");

		// click on Apply button
		driver.findElement(By.cssSelector("button.promoBtn")).click();

		// applying condition for element to be visible (explicit wait)
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".promoInfo")));

		System.out.println(driver.findElement(By.cssSelector(".promoInfo")).getText());

	}

	// keeping all the code in addItems method
	public static void addItems(WebDriver driver, String[] itemsNeeded) {

		int j = 0;// this is how many items get in the cart

		// getting array of products into cart, finding one common element
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));// using plural elements
																							// list,
		// will give you all the matching results

		// we will iterate through the elements to find the item we declared in array
		for (int i = 0; i < products.size(); i++) {
			// since on web page the name of the vegetable comes with other symbols, we need
			// to separate the item name
			String[] name = products.get(i).getText().split("-");// Cucumber-1 kg==> Cucmber, 1 kg
			// remove space
			String formattedName = name[0].trim();

			// format it to get actual vegetable name because it has additional 1 kg worlds
			// (Cucumber-1 kg), we need to separate it
			// check if the name you exctracted is present in array or not
			// convert array list for easy search

			List itemsNeededList = Arrays.asList(itemsNeeded);

			if (itemsNeededList.contains(formattedName)) {

				j++;
				// click on Add to cart
				driver.findElements(By.xpath("//div[@class='product-action']")).get(i).click();// use multiple elements
				// our code needs to come here only 3 times because there are only three items
				// needed
				if (j == itemsNeeded.length) // size of the array
				{
					break;
				}
			}

		}

		driver.close();

	}

}
