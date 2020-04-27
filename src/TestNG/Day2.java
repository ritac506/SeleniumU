package TestNG;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Result;

public class Day2 {
	

	@Test(groups= {"Smoke"})
	public void PersonalLoan() {
		System.out.println("Hi");
		Assert.assertTrue(false);
		
	}
	
	
	@BeforeTest
	public void Prerequisite() {
		System.out.println("I will execute before test");
	}

}
