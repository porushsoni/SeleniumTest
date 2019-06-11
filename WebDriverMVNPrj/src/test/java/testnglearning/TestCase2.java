package testnglearning;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestCase2 {
	
	@Test
	public void validateTitles()
	{
		String expected_title = "yahoo.com";
		String actual_title = "yahoo.com";
		
		SoftAssert softAssert = new SoftAssert();
		
		softAssert.assertEquals(actual_title, expected_title);
		softAssert.assertEquals("Porush", "Porush");
		//softAssert.assertTrue(false, "Assert Being True");
		
		softAssert.assertAll();
		//Assert.fail("Failing the assert");
		
		//Assert.assertEquals(expected_title, actual_title);
		
		/*if (expected_title.equals(actual_title))
		{
			System.out.println("Test Case is Passed");
		} else {
		    System.out.print("Test Case is Failed");	
		}*/
	}

}
