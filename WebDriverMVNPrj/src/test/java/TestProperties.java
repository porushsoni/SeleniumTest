// 1st June Day 6

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestProperties {

	public static void main(String[] args) throws IOException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.gmail.com/");
						
		Properties OR = new Properties();
		FileInputStream fis = new FileInputStream("./src/test/resources/properties/OR.properties");
		OR.load(fis);    // Loading OR.properties file 
		
		// Using OR.properties file to load element properties
		
		driver.findElement(By.id(OR.getProperty("username_ID"))).sendKeys("porushsteria@gmail.com");;
		driver.findElement(By.xpath(OR.getProperty("userBtn_XPATH"))).click();
		driver.findElement(By.xpath(OR.getProperty("password_XPATH"))).sendKeys("hellos");
		WebDriverWait wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("pwdBtn_XPATH"))));
		driver.findElement(By.xpath(OR.getProperty("pwdBtn_XPATH"))).click();
		
	}

}
