import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogkeSearchCount {

	public static void main(String[] args) throws IOException, InterruptedException {

	
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.get("https://www.google.com/");
			String searchText="way2automation";
			Thread.sleep(3000);
			driver.findElement(By.xpath("//div/div[1]/div/div[1]/input")).sendKeys(searchText);
			int searchCount=driver.findElements(By.xpath("//div/div[1]/div/div[1]/input")).size();
			
			System.out.println(searchCount);
			/*for(int i=1;i<=searchCount;i++) {
				String searchListValue=driver.findElement(By.xpath("(//div[2]/div/div[2]/div[2]/ul//div/div/div/span)["+i+"]")).getText();
				System.out.println(searchListValue);
			}
			Thread.sleep(500);
			driver.close()*/;
		}
		
	}


