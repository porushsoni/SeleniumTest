import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestMouseOver {

	public static WebDriver driver;
	public static boolean isElementPresent(By by) 
	{

		int size = driver.findElements(by).size();
			if (size == 0){
				return true;
			}else {
					return false;
					}
					
	}
	
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		
		driver.findElement(By.xpath("/html/body/div[2]/div/div/button")).click();
				
		int i=1;
		int count=0;
		while(isElementPresent(By.xpath("//*[@id='container']/div/div[2]/div/ul/li[i]/span")))
		{
			i++;
			count++;
		}
		
		System.out.println("There are "+count+" elements in this menu bar");
		/*for (WebElement menu:menus)
		{
			System.out.println(menus.);
		}*/
//Moving mouse over links like Men, Women etc and selecting/clicking one item from them		
		
		Actions actionmen = new Actions(driver);
	//Capturing "Men" web element
		WebElement men = driver.findElement(By.xpath("//*[@id='container']/div/div[2]/div/ul/li[3]/span"));
		actionmen.moveToElement(men).perform();
		driver.findElement(By.linkText("Shirts")).click();
				
	//Getting location of "Women"
		Thread.sleep(5000);
		WebElement women = driver.findElement(By.xpath("//*[@id='container']/div/div[2]/div/ul/li[4]/span"));
		Actions actionwomen = new Actions(driver);
		actionwomen.moveToElement(women).perform();
		driver.findElement(By.linkText("Blouse")).click();
		
	//Getting location of "Baby & Kids"
		Thread.sleep(5000);
		WebElement baby = driver.findElement(By.xpath("//*[@id='container']/div/div[2]/div/ul/li[5]/span"));
		Actions actionbaby = new Actions(driver);
		actionbaby.moveToElement(baby).perform();
		driver.findElement(By.linkText("Puzzles")).click();
		
	
	//Getting location of "Home and Furnitures"
		Thread.sleep(5000);
		WebElement home = driver.findElement(By.xpath("//*[@id='container']/div/div[2]/div/ul/li[6]/span"));
		Actions actionhome = new Actions(driver);
		actionhome.moveToElement(home).perform();
		driver.findElement(By.linkText("Clocks")).click();
				
				
	}
}