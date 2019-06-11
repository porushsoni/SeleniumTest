import java.util.Date;

public class TimeStamp {

	public static void main(String[] args) {
		Date d = new Date();
		//Output comes like Wed Jun 05 19:21:32 IST 2019
		//Replacing all : and spaces with _
		System.out.println(d.toString().replace(":", "_").replace(" ", "_")+".jpg");
	}

}
