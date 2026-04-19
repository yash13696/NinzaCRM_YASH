package genericUtility;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	public String randomAlphabet()
	{
		Random r=new Random();
		char upper= (char)('A'+r.nextInt(25));
		char upper1=(char)('B'+r.nextInt(24));
		String alpha=""+upper+upper1;
		return alpha;
	}
	
	public int randomNumber()
	{
		Random r= new Random();
		int randonNum=r.nextInt(1000);
		return randonNum;
	}
	
	public String currentDate()
	{
		Date d= new Date();
		SimpleDateFormat sim=new SimpleDateFormat("MM-dd-yyyy");
		String currentDate=sim.format(d);
		return currentDate;
	}
	
	@SuppressWarnings("static-access")
	public String expectedDate()
	{
		Date d = new Date();
		SimpleDateFormat sim = new SimpleDateFormat("MM-dd-yyyy");
		@SuppressWarnings("unused")
		String currentDate = sim.format(d);
		Calendar cal=sim.getCalendar();
		cal.add(cal.DAY_OF_MONTH,30);
		String expDate=sim.format(cal.getTime());
		return expDate;
	}

}
