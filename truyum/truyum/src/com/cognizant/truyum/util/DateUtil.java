package com.cognizant.truyum.util;
import java.util.Date;
import java.text.SimpleDateFormat;  

public class DateUtil {
	public static Date convertToDate(String date) throws Exception {
		Date date1=new SimpleDateFormat("dd/MM/YYYY").parse(date);
		return date1;
	}

}
