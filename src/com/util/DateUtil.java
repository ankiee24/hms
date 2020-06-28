package com.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
	public static Date convertStringtodate(String dateInstring,String format)
	{
		SimpleDateFormat formatter=new SimpleDateFormat(format);
		Date date=null;
		System.out.print("Date in String:"+dateInstring);
		try {
			date=formatter.parse(dateInstring);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
		
		
	}

}
