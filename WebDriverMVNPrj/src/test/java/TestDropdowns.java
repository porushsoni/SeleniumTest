
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestDropdowns {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.wikipedia.org/");
		//WebElement dropdown = driver.findElement(By.xpath("//*[@id='searchLanguage']"));
		//Select dropdown = new Select(dropdown);
		//dropdown.selectByVisibleText("Italiano");
		//drodown.selectByValue("es");
		//dropdown.selectByVisibleText("Milk");
		List<WebElement> options = driver.findElements(By.tagName("option"));
		System.out.println(options.size());
		
		for (int i=0;i<options.size();i++)
			
		{
			//Printing attribute "value" for all elements from the drop down
			System.out.println(options.get(i).getAttribute("value"));
			//Printing attribute "lang" for all elements from the drop down
			System.out.println(options.get(i).getAttribute("lang"));
			//Printing Text of all elements from the drop down
			System.out.println(options.get(i).getText());
		}
		         //another way of above loop
		
				/*for (WebElement opt: options)
		      	{
				System.out.println(opt.getAttribute("value"));
		      	}*/
		
		    List<WebElement> links = driver.findElements(By.tagName("a"));
		  
		
		     System.out.println("There are "+links.size()+" number of links available on this page");
		     //To print all links available on the page
		      for (int i=0; i<links.size();i++)
		        {
			      System.out.println(links.get(i).getAttribute("href"));
		         }
		      
		      //Getting links from a particular section
		      
		      WebElement block = driver.findElement(By.xpath("//*[@id='www-wikipedia-org']/div[6]/div[3]"));
		      List<WebElement> links2 = block.findElements(By.tagName("a"));
		      System.out.println("Links with in the Block are "+links2.size());
		      System.out.println("----------");
		      
		      for (WebElement link: links2)
		      {
		    	  System.out.println("Links with in the Block are "+link.getAttribute("href"));
		      }
		}

}
