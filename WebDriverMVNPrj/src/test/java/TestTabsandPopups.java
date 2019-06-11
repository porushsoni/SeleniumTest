import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestTabsandPopups {
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.hdfcbank.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		System.out.println("-------------Generating First Window-------------");
		Set<String> winid = driver.getWindowHandles();
		Iterator <String> iterator = winid.iterator();
		
		String first_window = iterator.next();
		System.out.println(first_window);
		
		driver.findElement(By.className("popupCloseButton")).click();
		Thread.sleep(5000);
		
		driver.findElement(By.id("loginsubmit")).click();
		
		System.out.println("----Generating window ids from second window----");
		
		winid = driver.getWindowHandles();
		iterator = winid.iterator();
		System.out.println(iterator.next()); // 1st Window
		String second_window = iterator.next(); // Second Window
		System.out.println(second_window);
		driver.switchTo().window(second_window);
		
		//Clicking on "Know More" on second page
		driver.findElement(By.xpath("/html/body/div[4]/div[3]/div/div/div[1]/div/a")).click();
		//Clicking on Read More link
		driver.findElement(By.xpath("//*[@id='customertab1']/div[1]/div[2]/p[5]/strong/a")).click();
		
		System.out.println("----Generating window ids from third window----");
		winid = driver.getWindowHandles();
		iterator = winid.iterator();
		System.out.println(iterator.next());
		System.out.println(iterator.next());
		
		String third_window = iterator.next(); //3rd Window
		System.out.println(third_window);
		
		driver.switchTo().window(third_window);
		System.out.println(driver.getTitle().contains("HDFC Bank | "));
		
		driver.close(); //3rd window will be closed
		driver.switchTo().window(second_window);
		driver.close(); //2nd window will be closed
		driver.switchTo().window(first_window);
		driver.close();
		driver.quit(); // It will close all windows
	}

}
