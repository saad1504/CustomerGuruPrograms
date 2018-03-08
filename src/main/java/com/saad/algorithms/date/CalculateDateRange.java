package com.saad.algorithms.date;

public class CalculateDateRange {

	public static DateRange getDateRange(DateRange input) {
		String fDay = input.fromDate.substring(0, 8);
		String fDate = fDay + "01";
		String tYear = input.toDate.substring(0, 4);
		String tMonth = input.toDate.substring(5, 7);
		String tDay = null;
		int tint = Integer.parseInt(tMonth);
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
		}
		String tDate=tYear+"-"+tMonth+"-"+tDay;
		return new DateRange(fDate, tDate);
	}
}
