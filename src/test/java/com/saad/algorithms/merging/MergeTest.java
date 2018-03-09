package com.saad.algorithms.merging;

import static org.junit.Assert.assertArrayEquals;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class MergeTest {

	private int input1[];
	private int input2[];
	private int expected[];
	

	public MergeTest(int input1[],int input2[],int output[]) {
		this.input1 = input1;
		this.input2 = input2;
		this.expected = output;
	}

	//Array for test cases
	@Parameters
	public static Collection<int[][]> data() {
		return Arrays.asList(new int[][][] {
			
			{{},{},{}},
			{{1,2,3,4},{},{1,2,3,4}},
			{{1,2,3,4},{1,2,3,4},{1,1,2,2,3,3,4,4}},
			{{-1,0,4,8},{-2,0,9},{-2,-1,0,0,4,8,9}}
			});
				
	}
	//Testing of expected output with actual output 
	@Test
	public void test() {
		int []actualOutput = MergeTwoArrays.MergeOutput(this.input1,this.input2);
		assertArrayEquals(actualOutput,this.expected);
		//assertEquals(actualOutput.toDate, this.expected.toDate);
	}

}
