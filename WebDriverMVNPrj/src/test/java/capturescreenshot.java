import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class capturescreenshot {

	public static WebDriver driver;
	public static void main(String[] args) throws IOException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.gmail.com/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Date d = new Date();
		//Output comes like Wed Jun 05 19:21:32 IST 2019
		//Replacing all : and spaces with _
		String filename = d.toString().replace(":", "_").replace(" ", "_")+".jpg"; 
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File("./screenshots/"+filename));
	}

}
