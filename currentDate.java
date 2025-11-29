package hectorproject;

import java.text.SimpleDateFormat;
import java.util.Date;

public class currentDate {

	public static void main(String[] args) {
		// https://docs.oracle.com/javase/8/docs/api/java/text/SimpleDateFormat.html
		Date currentDate = new Date();
		System.out.println(currentDate);
		
		SimpleDateFormat timeformat = new SimpleDateFormat("hh:mm:ss:aa");
		System.out.println(timeformat.format(currentDate));
		
		SimpleDateFormat dateformat = new SimpleDateFormat("MM/dd/yyyy");
		System.out.println(dateformat.format(currentDate));
		
		SimpleDateFormat dayOfTheWeekFormat = new SimpleDateFormat("EEEE");
		System.out.println(dayOfTheWeekFormat.format(currentDate));
		
		SimpleDateFormat clockFormat = new SimpleDateFormat("h:mm a");
		System.out.println(clockFormat.format(currentDate));
		
		
	}

}
