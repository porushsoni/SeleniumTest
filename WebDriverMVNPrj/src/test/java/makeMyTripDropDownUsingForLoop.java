import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class makeMyTripDropDownUsingForLoop {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com/");
		driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div/div[2]/div[1]/div[1]/label/span")).click();
		WebElement cities = driver.findElement(By.xpath("//*[@id='react-autowhatever-1']/div/div/p"));
		System.out.println("*******"+cities.getText()+"*******");

		int citiesCount = driver.findElements(By.xpath("//*[contains(@id, 'react-autowhatever-1-section-0-item-')]")).size();
		
		//String str = driver.findElement(By.xpath("//div/div[1]/p[1]")).getText();
		System.out.println("******" + citiesCount + "******");
		for (int i = 0; i < citiesCount; i++) {
			String airportCode = driver
					.findElement(
							By.xpath("//*[contains(@id, 'react-autowhatever-1-section-0-item-" + i + "')]"))
					.getText();
			String airportName = driver
					.findElement(By.xpath(
							"//*[contains(@id, 'react-autowhatever-1-section-0-item-" + i + "')]"))
					.getText();
			System.out.println("Airport Code:-" + airportCode + "| Airport Name:-" + airportName);
		}

		Thread.sleep(2000);
		driver.quit();
		}

}
