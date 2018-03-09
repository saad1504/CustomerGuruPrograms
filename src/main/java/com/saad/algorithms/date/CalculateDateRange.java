package com.saad.algorithms.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalculateDateRange {
	public static DateRange getDateRange(DateRange input) {
		boolean dateCrossed=false;
		String fromDateDay = input.fromDate.substring(0, 8);
		String fromDate = fromDateDay + "01";
		String toDateYear = input.toDate.substring(0, 4); 
		String toDateMonth = input.toDate.substring(5, 7);
		String toDateDay = null;
		Calendar cal = Calendar.getInstance(); // Calendar object used to get current date
		Date date = cal.getTime();             
		SimpleDateFormat reqFormat = new SimpleDateFormat("yyyy-MM-dd");          
		String curDate = null;
		curDate = reqFormat.format(date);
		String currentDateYear= curDate.substring(0, 4); 
		String cuurentDateMonth= curDate.substring(5, 7);
		
		//Conversion from String to Integer to perform calculations
		int currentYearInt=Integer.parseInt(currentDateYear);
		int currentMonthInt=Integer.parseInt(cuurentDateMonth);
		int toMonthInt = Integer.parseInt(toDateMonth);
		int toYearInt=Integer.parseInt(toDateYear);
		if(currentYearInt<=toYearInt)
		{
			if(currentYearInt==toYearInt)
			{
				if(currentMonthInt<=toMonthInt)
				{
					dateCrossed=true;
					
				}
			}
			if(currentYearInt <toYearInt)
			{
				dateCrossed=true;
			}
		}
		// To get accurate last day of fromDate's month 
		switch (toMonthInt) {
		//January,March,May,July,August,October,December have 31 days
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12: {
			
			toDateDay = "31";
			break;
		}
		//April,June,September,November have 30 days
		case 4:
		case 6:
		case 9:
		case 11: {
			toDateDay = "30";
			break;
		}
		case 2: {
			//February has only 28 days when not a leap year or else it has 29 days
			if (((toYearInt % 4 == 0) && !(toYearInt % 100 == 0)) || (toYearInt % 400 == 0))
				toDateDay = "29";
			else
				toDateDay = "28";
			break;
		}
		}
		String tDate = toDateYear + "-" + toDateMonth + "-" + toDateDay;
		
		
	
		if(dateCrossed)
			return new DateRange(fromDate,curDate);
		else
			
			return new DateRange(fromDate, tDate);
	}
}
