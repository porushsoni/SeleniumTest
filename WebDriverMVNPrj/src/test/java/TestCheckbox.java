import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCheckbox {
	
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
				return false;
			}else {
					return true;
					}
			
		
	}

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://www.tizag.com/htmlT/htmlcheckboxes.php");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		//WebElement CkBox1 = driver.findElement(By.xpath("//div[4]/input[1]"));
		// Xpath of one checkbox = /html/body/table[3]/tbody/tr[1]/td[2]/table/tbody/tr/td/div[4]/input[1]
		// Taking partial Xpath from this = //div[4]/input[1]
		/*int count =0;
		for (int i=1;i<=4;i++)
		{
			driver.findElement(By.xpath("//div[4]/input["+i+"]")).click();
			count ++;
		}
		System.out.println("There are "+count+" checkboxes present on this page");
		*/
		
		// When we dont know the number of check boxes present
	/*	int i=1;
		int count=0;
		
		while(isElementPresent(By.xpath("//div[4]/input["+i+"]")))
		{
			driver.findElement(By.xpath("//div[4]/input["+i+"]")).click();
			i++;
			count ++;
		}
		
		System.out.println("There are "+count+" check boxes present on this page");
		*/
		/*List<WebElement> checkboxes = driver.findElements(By.name("sports"));
		int count = 0;
		for (WebElement checkbox: checkboxes)
		{
			checkbox.click();
			count ++;
		}
		
		System.out.println("There are "+count+" check boxes present on this page");
		*/
		
		WebElement block = driver.findElement(By.xpath("/html/body/table[3]/tbody/tr[1]/td[2]/table/tbody/tr/td/div[4]"));
		
		List<WebElement> checkboxes = block.findElements(By.name("sports"));
		
		System.out.println("Total checkboxes : "+checkboxes.size());

		for(WebElement checkbox: checkboxes) {
			
			checkbox.click();
		}
			
	}

}
