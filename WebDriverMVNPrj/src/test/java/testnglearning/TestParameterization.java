package testnglearning;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ExcelReader;

public class TestParameterization {

	public static WebDriver driver;
	public static WebDriverWait wait;
	
	@BeforeTest
	public void setup() {
	
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver,5);
	}
	
	@AfterTest
	public void tearDown (){
		driver.quit();
	}
	
	@BeforeMethod
	public void navigateURL() {
		
		driver.get("https://login.globalglaze.in/");
	}
	
	@Test (dataProvider="getData")
	public void doLogin(String username, String password)
	{
		driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_usernm']")).sendKeys(username);
		driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_adminpassword']")).sendKeys(password);
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='u_0_2']"))).click();
		driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_btn_go']")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();

		
	}
	
	@DataProvider
	public Object[][] getData()
	{
		ExcelReader excel = new ExcelReader("./src/test/resources/excel/testdata.xlsx");
		
		String sheetName = "LoginTest";
		
		int rowNum = excel.getRowCount(sheetName);
		int colNum = excel.getColumnCount(sheetName);
		
		System.out.println("Number of rows: "+rowNum+" And number of columns: "+colNum);
		
		//System.out.println(excel.getCellData(sheetName, 1, 1));
		
		Object[][] data = new Object[rowNum-1][colNum];
		
/*		data[0][0] = excel.getCellData(sheetName, 0, 2);  // SheetName, Col, Row
		data[0][1] = excel.getCellData(sheetName, 1, 2);
		
		data[1][0] = excel.getCellData(sheetName, 0, 3);
		data[1][1] = excel.getCellData(sheetName, 1, 3);
		
		data[2][0] = excel.getCellData(sheetName, 0, 4);
		data[2][1] = excel.getCellData(sheetName, 1, 4);     */
		
		for(int rows=2; rows<=rowNum;rows++) {
			for(int cols=0;cols<colNum;cols++) {
				data[rows-2][cols] = excel.getCellData(sheetName, cols, rows);
			}
		}
			
		

 		
		return data;
	}
	
}
