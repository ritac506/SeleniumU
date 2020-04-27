package TestNG;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Day3 {

	@Test(groups= {"Smoke"})
	public void WebLoginCarLoan() {
		System.out.println("WebLoginCarLoan");
	}

	@BeforeMethod
	public void befMeth() {
		System.out.println("I will print before each method");//lets say we can use to delete cookies
	}
	@AfterMethod
	public void afMeth() {
		System.out.println("I will print after each method");
	}
	
	@Test(timeOut=4000)//it tells java to wait for 40 seconds before throwing error, if this particular test takes more time to execute
	public void MobileLoginCarLoan() {
		System.out.println("MobileLoginCarLoan");
	}
	@Parameters({"URL"})//we put url info in xml file
	@Test
	public void APILoginCarLoan(String urlname) {
		System.out.println("APILoginCarLoan");
		System.out.println(urlname);
	}


}
