package testnglearning;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCase1 {
	
	@BeforeTest
	public void creatingDBConn() 
	{
		System.out.println("Creating DB Connection");
	}
	
	@AfterTest
	public void closingDBConn() 
	{
		System.out.println("Closing DB Connection");
	}
	
	@BeforeMethod
	public void launchBrowser() 
	{
		System.out.println("Launching the Browser");
	}
	
	@AfterMethod
	public void closeBrowser ()
	{
		System.out.println("Closing the Browser");
	}
	
	
	@Test (priority = 1)
	public void doUserReg()
	
	{
		System.out.println("Executing User Registration Test");
	}
	
	@Test (priority = 2)
	public void doLogin ()
	{
		System.out.println("Executing User Login Test");
	}
	
	
}
