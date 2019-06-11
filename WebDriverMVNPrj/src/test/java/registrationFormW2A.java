import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class registrationFormW2A {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("http://way2automation.com/way2auto_jquery/index.php");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("#load_form > fieldset:nth-child(5) > input[type=text]")).sendKeys("Porush");
	}

}
