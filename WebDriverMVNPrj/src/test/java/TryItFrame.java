import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TryItFrame {

	public static WebDriver driver;
	//creating a utility to capture screenshot
	
	public static void captureScreenshot() throws IOException{
		Date d = new Date();
		//Output comes like Wed Jun 05 19:21:32 IST 2019
		//Replacing all : and spaces with _
		String filename = d.toString().replace(":", "_").replace(" ", "_")+".jpg";
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File("./screenshots/"+filename));
	}
	
	public static void main(String[] args) throws IOException {


		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_submit_get");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		
		driver.switchTo().frame("iframeResult");
		
		//handling the button without clicking (through Java Script)
		((JavascriptExecutor) driver).executeScript("myFunction()");
		
		captureScreenshot();
		
		((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'", driver.findElement(By.xpath("//*[@id='mySubmit']")));
		//driver.findElement(By.xpath("/html/body/button")).click();
		captureScreenshot();
		
		//As in above case, the focus has come to the frame, so we need to come out of this otherwise we can work
		//on outside of this frame
		
		driver.switchTo().defaultContent();
		
		List<WebElement> frames = driver.findElements(By.tagName("iframe"));
		System.out.println("There are total "+frames.size()+" number of frames present on this page");
		System.out.println("-----------------------------------------------");		
		for(WebElement frame: frames) {
			
			System.out.println(frame.getAttribute("id"));
		
		
		}
		
	}

}
