import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestKeyboardKeys {

	public static void main(String[] args) {


		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.get("http://gmail.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.findElement(By.id("identifierId")).sendKeys(Keys.ENTER);
		
		Actions action = new Actions(driver);
		
		driver.findElement(By.xpath("//*[@id=\"view_container\"]/div/div")).click();
		//action.sendKeys(Keys.ENTER).sendKeys(Keys.PAGE_UP).perform();
		action.sendKeys(Keys.chord(Keys.CONTROL+"a")).sendKeys(Keys.chord(Keys.CONTROL+"c")).perform();
		driver.findElement(By.id("identifierId")).click();
		action.sendKeys(Keys.chord(Keys.CONTROL+"v")).perform();
		//action.sendKeys(Keys.ENTER).perform();

	}

}