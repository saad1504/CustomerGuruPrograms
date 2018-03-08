package com.saad.algorithms.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalculateDateRange {
	public static DateRange getDateRange(DateRange input) {
		boolean flag=false;//Flag to check if current date is crossed by toDate
		String fDay = input.fromDate.substring(0, 8);//FromDate's day is extracted
		String fDate = fDay + "01";
		String tYear = input.toDate.substring(0, 4); //toDate's year is extracted
		String tMonth = input.toDate.substring(5, 7);//toDate's month is extracted
		String tDay = null;
		Calendar cal = Calendar.getInstance(); // Calendar object used to get current date
		Date date = cal.getTime();             
		SimpleDateFormat reqFormat = new SimpleDateFormat("yyyy-MM-dd"); // Used to get current date into required format          
		String curDate = null;
		curDate = reqFormat.format(date);
		String cYear= curDate.substring(0, 4); //curDate's year is extracted
		String cMonth= curDate.substring(5, 7);//curDate's month is extracted
		
		//Conversion from String to Integer to perform calculations
		int cyrint=Integer.parseInt(cYear);
		int cmint=Integer.parseInt(cMonth);
		int tint = Integer.parseInt(tMonth);
		int tyrint=Integer.parseInt(tYear);
		//Conditions to check if current date is crossed by toDate
		if(cyrint<=tyrint)
		{
			if(cyrint==tyrint)
			{
				if(cmint<=tint)
				{
					flag=true;
					
				}
			}
			if(cyrint <tyrint)
			{
				flag=true;
			}
		}
		// To get accurate last day of fromDate's month 
		switch (tint) {
		//January,March,May,July,August,October,December have 31 days
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12: {
			
			tDay = "31";
			break;
		}
		//April,June,September,November have 30 days
		case 4:
		case 6:
		case 9:
		case 11: {
			tDay = "30";
			break;
		}
		case 2: {
			//February has only 28 days when not a leap year or else it has 29 days
			if (((tyrint % 4 == 0) && !(tyrint % 100 == 0)) || (tyrint % 400 == 0))
				tDay = "29";
			else
				tDay = "28";
			break;
		}
		}
		String tDate = tYear + "-" + tMonth + "-" + tDay;
		
		
	
		if(flag)
			return new DateRange(fDate,curDate);
		else
			
			return new DateRange(fDate, tDate);
	}
}
