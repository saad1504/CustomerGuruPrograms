package com.saad.algorithms.mostrepeated;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FiveMostRepeatedwordsTest {

	@Test
	public void multiplicationOfZeroIntegersShouldReturnZero() {
		FiveMostRepeatedWords tester = new FiveMostRepeatedWords();

		String[] strArray = new String[] { "XXX", "BBB", "BBB", "BBB", "XXX", "AAA", "XXX", "AAA", "XXX", "PP", "QQ",
				"CC", "CC","AAA","DDDD" };
		tester.MostRepeatedWords(strArray);

	}

}
