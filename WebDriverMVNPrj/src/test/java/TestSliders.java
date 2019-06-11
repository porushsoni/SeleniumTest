import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestSliders {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://jqueryui.com/resources/demos/slider/default.html");
		
		Thread.sleep(3000);
		Actions action = new Actions(driver);
		WebElement slider = driver.findElement(By.xpath("//*[@id='slider']"));
		action.dragAndDropBy(slider, 250, 0).perform();;
		

	}

}
