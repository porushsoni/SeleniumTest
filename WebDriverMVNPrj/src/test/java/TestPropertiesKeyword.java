// 1st June Day 6 (for Keyword Driven Design Pattern) AND 2nd June Day 7 (For Log4J) AND 2nd June Day 7 (For Mail)

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.MonitoringMail;
import utilities.TestConfig;

public class TestPropertiesKeyword {
	
		public static WebDriver driver;
		public static Properties OR = new Properties();
		public static Properties Config = new Properties();
		public static FileInputStream fis;
		public static WebDriverWait wait;
		public static Logger log = Logger.getLogger(TestPropertiesKeyword.class.getName()); //from Apache
		public static MonitoringMail mail = new MonitoringMail();
		//Creating keywords (methods)
		
		public static void type (String key, String value) throws AddressException, MessagingException 
		{
			
			try{
			
			if (key.endsWith("_XPATH"))
			{
			driver.findElement(By.xpath(OR.getProperty(key))).sendKeys(value);
			} 
			
			else if (key.endsWith("_ID"))
			{
			driver.findElement(By.id(OR.getProperty(key))).sendKeys(value);
			} 
			
			else if (key.endsWith("_CSS"))
			{
			driver.findElement(By.cssSelector(OR.getProperty(key))).sendKeys(value);
			}
			} catch (Throwable t)
				{
				log.error(t.getMessage());
				mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject, t.getMessage(), TestConfig.attachmentPath, TestConfig.attachmentName);
				}
			
			log.info("Typing in an element "+key+" with entered value as "+value);
		}
		public static void click (String key) throws AddressException, MessagingException
		{
			
			try {
			if (key.endsWith("_XPATH"))
			{
			driver.findElement(By.xpath(OR.getProperty(key))).click();
			} 
			
			else if (key.endsWith("_ID"))
			{
			driver.findElement(By.id(OR.getProperty(key))).click();
			} 
			
			else if (key.endsWith("_CSS"))
			{
			driver.findElement(By.cssSelector(OR.getProperty(key))).click();
			}
			} catch (Throwable t)
				{
				log.error(t.getMessage());
				mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject, t.getMessage(), TestConfig.attachmentPath, TestConfig.attachmentName);
				}
			
			log.info("Click on an element: "+key);
		}
		
		public static void main(String[] args) throws IOException, InterruptedException, AddressException, MessagingException {
		
			PropertyConfigurator.configure("./src/test/resources/properties/log4j.properties");   // Giving the path of Log4j Property File
			
			fis = new FileInputStream("./src/test/resources/properties/OR.properties");
			OR.load(fis);    // Loading OR.properties file 
			log.info("OR properties Loaded");
					
			fis = new FileInputStream("./src/test/resources/properties/Config.properties");
			Config.load(fis);    // Loading Config.properties file
			log.info("Config properties Loaded");
			
			// Using OR.properties and Config.properties files to load elements/configurations
			
			if (Config.getProperty("browser").equals("chrome"))
			{
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				log.info("Chrome Browser Launched !!!!");
			} else if (Config.getProperty("browser").equals("firefox"))
			
			{
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				log.info("Firefox Browser Launched !!!!");
			}
			else if (Config.getProperty("browser").equals("ie"))
				
			{
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
				log.info("Internet Explorer Browser Launched !!!!");
			}
			
			driver.get(Config.getProperty("testsite.url"));    // Using testsite.url property from config file
			log.info("Navigated to : "+Config.getProperty("testsite.url"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(Config.getProperty("implicit.wait")), TimeUnit.SECONDS); // First Argument of this method excepts Integer value
			
			type("username_XPATH","priyankaverma1210@gmail.com"); // Calling the type keyword which will type user id in the field
			click("userBtn_XPATH"); // Calling the click keyword which will click on Next button
			type("password_XPATH","****");
			wait = new WebDriverWait(driver,Integer.parseInt(Config.getProperty("explicit.wait")));
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("pwdBtn_XPATH"))));
			click("pwdBtn_XPATH");
			/*driver.findElement(By.xpath(OR.getProperty("password_XPATH"))).sendKeys("hellos");
			WebDriverWait wait = new WebDriverWait(driver,Integer.parseInt(Config.getProperty("explicit.wait"))); // Second argument of this method accepts Integer
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("pwdBtn_XPATH"))));
			driver.findElement(By.xpath(OR.getProperty("pwdBtn_XPATH"))).click();*/

			Thread.sleep(5000);
			driver.close();
			log.info("Test Execution Completed !!!!");


	}

}
