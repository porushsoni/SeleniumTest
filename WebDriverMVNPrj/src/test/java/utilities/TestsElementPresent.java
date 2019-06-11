package utilities;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestsElementPresent {

	public static WebDriver driver;
	public static boolean isElementPresent(By by) 
	{
			/*try{
				driver.findElement(By.id(id));
				return true;
			}catch (Throwable t){
				return false;
			}*/
		
		//Another way of doing it
		int size = driver.findElements(by).size();
			if (size == 0){
				return true;
			}else {
					return false;
					}
			
		
	}
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://gmail.com");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		System.out.println(isElementPresent(By.id("identifierid"))); 
		

	}

}
