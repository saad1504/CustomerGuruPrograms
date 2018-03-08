package com.saad.algorithms.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalculateDateRange {

	public static DateRange getDateRange(DateRange input) {
		boolean flag=false;
		String fDay = input.fromDate.substring(0, 8);
		String fDate = fDay + "01";
		String tYear = input.toDate.substring(0, 4);
		String tMonth = input.toDate.substring(5, 7);
		String tDay = null;
		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();             
		SimpleDateFormat reqFormat = new SimpleDateFormat("yyyy-MM-dd");          
		String curDate = null;
		curDate = reqFormat.format(date);
		String cYear= curDate.substring(0, 4);
		String cMonth= curDate.substring(5, 7);
		int cyrint=Integer.parseInt(cYear);
		int cmint=Integer.parseInt(cMonth);
		
		int tint = Integer.parseInt(tMonth);
		int tyrint=Integer.parseInt(tYear);
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
		switch (tint) {
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
		case 4:
		case 6:
		case 9:
		case 11: {
			tDay = "30";
			break;
		}
		case 2: {
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
