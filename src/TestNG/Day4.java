package TestNG;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Day4 {
	@Test (enabled=false) // excluded from executing
	public void WebLoginHomeLoan() {
		System.out.println("WebLoginHomeLoan");
	}
	@Parameters({"URL"})//we put url info in xml file
	@Test(groups= {"Smoke"})
	public void MobileLoginHomeLoan(String urname) {
		System.out.println("MobileLoginHomeLoan");
		System.out.println(urname);
	}
	@AfterSuite 
	public void ending() {
		System.out.println("I am the last one");
	}
	@Test(dependsOnMethods= {"MobileLoginHomeLoan"})//since normally testcases executed by alphabetical order, 
	                                                   //we can depend one test on another, MobileLoginHomeLoan will execute before API
	public void APILoginHomeLoan() {
		System.out.println("APILoginHomeLoan");
	}
	

}
