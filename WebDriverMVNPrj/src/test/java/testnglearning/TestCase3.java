package testnglearning;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class TestCase3 {
	
	@Test (priority = 1)
	public void doUserReg()
	
	{
		
		Assert.fail("Failing the Assert");
		//System.out.println("Executing User Registration Test");
	}
	
	@Test (priority = 2,dependsOnMethods="doUserReg")
	public void doLogin ()
	{
		System.out.println("Executing User Login Test");
	}
	
	@Test (priority=3)
	public void isSkip()
	{
		throw new SkipException("Skipping the test as the Condition is not met");
	}

}
