import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestLogin {

	public static void main(String[] args) throws InterruptedException{

	//Ctrl + Shft + O	
	//WebDriverManager.chromedriver().setup();
	//WebDriverManager.iedriver().setup();
	WebDriverManager.firefoxdriver().setup();
	WebDriver driver = new FirefoxDriver();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get("http://gmail.com");
    WebDriverWait wait = new WebDriverWait(driver, 5);
	
   /* Options man = driver.manage();
    Window win = man.window();
    win.maximize();
    */
    
	driver.manage().window().maximize();
	//driver.findElement(By.id("identifierId")).sendKeys("porush.verma@gmail.com");
	WebElement username = driver.findElement(By.id("identifierId"));
	username.sendKeys("porush.verma@gmail.com");

	WebElement nextbutton = driver.findElement(By.xpath("//*[@id='identifierNext']/content/span"));
	//WebElement nextbutton = driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/content/span")); 
	nextbutton.click();
	
	//Thread.sleep(3000);
	
	wait.until(ExpectedConditions.elementToBeClickable(By.name("password"))).sendKeys("hellow");
	//driver.findElement(By.name("password")).sendKeys("hellow");
	WebElement nextbtn = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div[1]/div/content/span"));
	nextbtn.click();
	
	}

}
