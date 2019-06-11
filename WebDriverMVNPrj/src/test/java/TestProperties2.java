// 1st June Day 6

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestProperties2 {
	

	public static WebDriver driver;
	public static Properties OR = new Properties();
	public static Properties Config = new Properties();
	public static FileInputStream fis;
	
	public static void main(String[] args) throws IOException, InterruptedException {

		
		
		fis = new FileInputStream("./src/test/resources/properties/OR.properties");
		OR.load(fis);    // Loading OR.properties file 
				
		fis = new FileInputStream("./src/test/resources/properties/Config.properties");
		Config.load(fis);    // Loading Config.properties file
		
		// Using OR.properties and Config.properties files to load elements/configurations
		
		if (Config.getProperty("browser").equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (Config.getProperty("browser").equals("firefox"))
		
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if (Config.getProperty("browser").equals("ie"))
			
		{
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		
		driver.get(Config.getProperty("testsite.url"));    // Using testsite.url property from config file
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(Config.getProperty("implicit.wait")), TimeUnit.SECONDS); // First Argument of this method excepts Integer value
		driver.findElement(By.id(OR.getProperty("username_ID"))).sendKeys("porush.verma@gmail.com");;
		driver.findElement(By.xpath(OR.getProperty("userBtn_XPATH"))).click();
		driver.findElement(By.xpath(OR.getProperty("password_XPATH"))).sendKeys("hellos");
		WebDriverWait wait = new WebDriverWait(driver,Integer.parseInt(Config.getProperty("explicit.wait"))); // Second argument of this method accepts Integer
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("pwdBtn_XPATH"))));
		driver.findElement(By.xpath(OR.getProperty("pwdBtn_XPATH"))).click();

		Thread.sleep(5000);
		driver.close();
		
	}

}
