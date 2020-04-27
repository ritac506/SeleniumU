package TestNG;

//here we go

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Day1 {
	
	@BeforeSuite
	public void Initial() {
		System.out.println("I am # 1");
	}
	@AfterTest 
	public void afterTest() {
		System.out.println("I will execute after tests");
	}
	@Test (enabled=false)     //we are excluding this test for running
	public void Test1() {
		System.out.println("PersonalLoan1");
	}
	@BeforeClass
	public void befClass() {
		System.out.println("I will run before all the methods in the class");//only class level
	}
	@AfterClass
	public void afClass() {
		System.out.println("I will run after all the methods in the class");
	}
	@Parameters({"URL","Username"})//we put url info in xml file
	@Test (groups= {"Smoke"})
	public void Test2(String uname,String username) {
		System.out.println("PersonalLoan2");
		System.out.println(uname+" "+username);
		
	}
	@Test(dataProvider="getData")
	public void PersonalLoanSIGNIN(String username, String password) {
		System.out.println("awesome");	
		System.out.println(username+" "+password);
		
	}
	@DataProvider
	public Object[][] getData() {
		//we provide three different sets of data
		//1  username and password-good credit
		//2  username and password-bad credit
		//3  username and password-fradulent credit
		Object[][]data=new Object[3][2];//we providing 3 combinations with 2 values (three raws and two columns)
		
		//1st set
		data[0][0]="firstUserName";
		data[0][1]="firstPassword";
		
		//2nd set
		data[1][0]="secondUser";
		data[1][1]="secondPassword";
		
		//3rd set
		data[2][0]="thirdUser";
		data[2][1]="thirdPassword";
		
		return data;
	}
	//to see report go to project name, right click, refresh, then open test-output folder, click on index.html 
}
