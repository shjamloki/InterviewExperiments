package org.sj.java.collections.experiments;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ArrayValueCounter {
	
	/**
	 * This program is to find how many times a value in a array occurred.
	 * String arr[] ={"Ram","world,"Ram"};
	 * The output should be Ram -2 and World -1
	 */
	public static void getArrayValuesCountLegacy(){
		String arrp[] ={"ram", "world","ram","world","world"};
		Map<String,Integer> arrValueCounter =new HashMap<String, Integer>();
		for(String value: arrp){
			
			if(arrValueCounter.containsKey(value)){
				arrValueCounter.put(value,arrValueCounter.get(value)+1);
			}
			else
			{
				arrValueCounter.put(value, 1);
			}
		}
		
		System.out.println(arrValueCounter.toString());
		
		arrValueCounter.forEach( (k,v) -> System.out.println("Key: " + k + ": Value: " + v));
		
		for(Map.Entry<String, Integer> entry:arrValueCounter.entrySet()){
		System.out.println(entry.getKey() + "/" + entry.getValue());
		}
	}
	public static void getArrayValueCountUtilities(){
		String arrp[] ={"ram", "world","ram","world","world"};
		Map<String, Long> map = Arrays.stream(arrp)
			    .collect(Collectors.groupingBy(s -> s, Collectors.counting()));
		System.out.println("1st Method : "+map.toString());
		
		List<String> asList = Arrays.asList(arrp);
		Set<String> mySet = new HashSet<String>(asList);
		for(String s: mySet){
		System.out.println(s + " " +Collections.frequency(asList,s));
		}
		
		


	}
	public  static void main(String args[]){
		//getArrayValuesCountLegacy();
		getArrayValueCountUtilities();
	}

}
