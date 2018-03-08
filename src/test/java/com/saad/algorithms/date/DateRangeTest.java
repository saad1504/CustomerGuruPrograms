package com.saad.algorithms.date;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class DateRangeTest {

	private DateRange input;
	private DateRange expected;

	public DateRangeTest(DateRange input, DateRange expected) {
		this.input = input;
		this.expected = expected;
	}

	//Array for test cases
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
				{ new DateRange("2016-09-11", "2016-10-06"), new DateRange("2016-09-01", "2016-10-31") },
				{ new DateRange("2016-05-16", "2016-08-06"), new DateRange("2016-05-01", "2016-08-31") },
				{ new DateRange("2018-02-11", "2018-02-06"), new DateRange("2018-02-01", "2018-02-28") },
				{ new DateRange("2016-01-25", "2016-02-16"), new DateRange("2016-01-01", "2016-02-29") },
				{ new DateRange("2018-03-07", "2018-03-14"), new DateRange("2018-03-01", "2018-03-08") },
				{ new DateRange("2018-02-11", "2019-02-06"), new DateRange("2018-02-01", "2018-03-08") }});
				
	}
	//Testing of expected output with actual output 
	@Test
	public void test() {
		DateRange actualOutput = CalculateDateRange.getDateRange(this.input);
		assertEquals(actualOutput.fromDate, this.expected.fromDate);
		assertEquals(actualOutput.toDate, this.expected.toDate);
	}

}
