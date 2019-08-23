package co.sree.seleniumTestNG;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class   currentTimeStamp {
	
	public static String gettime() {
	SimpleDateFormat formater = new SimpleDateFormat("dd-MMM-yyyy hh_mm_ss a");
	formater.setTimeZone(TimeZone.getTimeZone("America/New_York"));
	Date date = new Date();	
	return formater.format(date)+ "..EST";
}
}