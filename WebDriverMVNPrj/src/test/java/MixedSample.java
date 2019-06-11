import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MixedSample {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://gmail.com");
		//driver.findElement(By.xpath("//*[@id='identifierId']")).sendKeys("porushsteria@gmail.com");
		//Through css
		//driver.findElement(By.cssSelector("*[id='identifierId']")).sendKeys("porushsteria@gmail.com");
		//OR concatinating the attributes in CSS to make it unique
		//driver.findElement(By.cssSelector("input[id='identifierId'][type='email'][name=identifier]")).sendKeys("porushsteria@gmail.com");
		driver.findElement(By.cssSelector("#identifierId")).sendKeys("Hello");
		driver.findElement(By.xpath("//*[@id='identifierNext']/content/span")).click();
		driver.findElement(By.xpath("//*[@id='password']/div[1]/div/div[1]/input")).sendKeys("smartsoni1914298912");
		//driver.findElement(By.xpath("//*[@id='passwordNext']/content/span")).click();
		Thread.sleep(3000);
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER);
		

	}

}
