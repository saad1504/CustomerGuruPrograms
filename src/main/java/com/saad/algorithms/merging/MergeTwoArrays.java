package com.saad.algorithms.merging;

public class MergeTwoArrays {

	public static int[] MergeOutput(int array1[],int array2[]){
		
		int[] merged = new int[array1.length + array2.length];
	    int array1Tracker = 0, array2Tracker = 0, mergedArrayTracker = 0;
	    while (array1Tracker < array1.length && array2Tracker < array2.length){
	    	
	        if (array1[array1Tracker] < array2[array2Tracker]){
	            merged[mergedArrayTracker] = array1[array1Tracker];
	            array1Tracker++;
	        }
	        else{
	            merged[mergedArrayTracker] = array2[array2Tracker];
	            array2Tracker++;
	        }
	        mergedArrayTracker++;
	    }

	    while (array1Tracker < array1.length){
	        merged[mergedArrayTracker] = array1[array1Tracker];
	        array1Tracker++;
	        mergedArrayTracker++;
	    }

	    while (array2Tracker < array2.length){
	        merged[mergedArrayTracker] = array2[array2Tracker];
	        array2Tracker++;
	        mergedArrayTracker++;
	    }

	    return merged;
	}
}
