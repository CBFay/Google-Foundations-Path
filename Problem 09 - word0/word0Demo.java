/**
 * Problem 9
 * from https://techdevguide.withgoogle.com/paths/foundational/
 * created 12.02.2017 by CB Fay
 */

/**
 * Given an array of strings, return a Map<String, Integer> containing a key for every different string in the array, always with the value 0. For example the string "hello" makes the pair "hello":0. We'll do more complicated counting later, but for this problem the value is simply 0.
 * word0(["a", "b", "a", "b"]) → {"a": 0, "b": 0}
 * word0(["a", "b", "a", "c", "b"]) → {"a": 0, "b": 0, "c": 0}
 * word0(["c", "b", "a"]) → {"a": 0, "b": 0, "c": 0}
 */

import java.util.*;

class word0Demo {
	public static void main(String[] args) {
		String[] testCase1 = new String[] { "a", "b", "a", "b" };
		String[] testCase2 = new String[] { "a", "b", "a", "c", "b" };
		String[] testCase3 = new String[] { "c", "b", "a" };
		
		System.out.println(Arrays.asList(word0(testCase1)));
		System.out.println(Arrays.asList(word0(testCase2)));
		System.out.println(Arrays.asList(word0(testCase3)));
	}
	
	static Map<String, Integer> word0(String[] strings) {
		Map<String, Integer> result = new HashMap<String,Integer>();
		
		for (String x : strings) {
			result.put(x, 0);
		}
		return result;
	}
}