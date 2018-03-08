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

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
				{ new DateRange("2016-09-11", "2016-10-06"), new DateRange("2016-09-01", "2016-10-31") },
				{ new DateRange("2016-05-16", "2016-08-06"), new DateRange("2016-05-01", "2016-08-31") }}); 
	}

	@Test
	public void test() {
		DateRange actualOutput = CalculateDateRange.getDateRange(this.input);
		assertEquals(actualOutput.fromDate, this.expected.fromDate);
		assertEquals(actualOutput.toDate, this.expected.toDate);
	}

}
