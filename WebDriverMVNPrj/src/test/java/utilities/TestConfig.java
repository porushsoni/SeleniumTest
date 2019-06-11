package utilities;


public class TestConfig{


	
	public static String server="smtp.gmail.com";
	public static String from = "porushsteria@gmail.com";
	public static String password = "enteryourpasssword";
	public static String[] to ={"porush.verma@gmail.com","priyankaverma1210@gmail.com"};
	public static String subject = "Test Execution";
	
	public static String messageBody ="This is the sample of Java Email API";
	public static String attachmentPath="D:\\Test Automation\\Selenium\\Workspace\\WebDriverMVNPrj\\src\\test\\resources\\logs\\applog.txt";
	public static String attachmentName="ErrorLogFile.txt";
	
	
	
	//SQL DATABASE DETAILS	
	public static String driver="net.sourceforge.jtds.jdbc.Driver"; 
	public static String dbConnectionUrl="jdbc:jtds:sqlserver://192.101.44.22;DatabaseName=monitor_eval"; 
	public static String dbUserName="sa"; 
	public static String dbPassword="$ql$!!1"; 
	
	
	//MYSQL DATABASE DETAILS
	public static String mysqldriver="com.mysql.jdbc.Driver";
	public static String mysqluserName = "root";
	public static String mysqlpassword = "selenium";
	public static String mysqlurl = "jdbc:mysql://localhost:3306/7thapril2019";
	
	
	
	
	
	
	
	
	
}
