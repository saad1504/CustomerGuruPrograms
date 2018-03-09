package com.saad.algorithms.mostrepeated;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class FiveMostRepeatedWords {

	public void MostRepeatedWords(String[] StringList) {

		Map<String, Integer> mapOfRepeatedWords = new HashMap<String, Integer>();

		for (String word : StringList) {
			if (mapOfRepeatedWords.containsKey(word)) {
				mapOfRepeatedWords.put(word, mapOfRepeatedWords.get(word) + 1);

			} else {
				mapOfRepeatedWords.put(word, 1);
			}
		}
		Map<String, Integer> SortedDescendingMap = sortByCountValue(mapOfRepeatedWords);
		int wordCounter=0;
		for(Map.Entry<String, Integer> entry : SortedDescendingMap.entrySet()){
			if(wordCounter<5) {
				System.out.println(entry.getKey());
	            wordCounter++;	
			}
			else {
				break;
			}
            
        }

	}

	private static Map<String, Integer> sortByCountValue(Map<String, Integer> mapOfRepeatedWords) {

		Set<Map.Entry<String, Integer>> setOfWords = mapOfRepeatedWords.entrySet();
		List<Map.Entry<String, Integer>> listOfWords = new ArrayList<Map.Entry<String, Integer>>(setOfWords);
		Collections.sort(listOfWords, new Comparator<Map.Entry<String, Integer>>() {

			public int compare(Entry<String, Integer> value1, Entry<String, Integer> value2) {
				return value2.getValue().compareTo(value1.getValue());

			}
		});

		Map<String, Integer> linkedHashMapOfWords = 
                new LinkedHashMap<String, Integer>();
		for(Map.Entry<String, Integer> map : listOfWords){
			linkedHashMapOfWords.put(map.getKey(), map.getValue());
        }
		
		return linkedHashMapOfWords;
		
	}

	
}
