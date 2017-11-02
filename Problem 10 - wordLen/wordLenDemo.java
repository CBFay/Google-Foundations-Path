/*
 * Problem 10
 * from https://techdevguide.withgoogle.com/paths/foundational/
 * created 11.02.2017 by CB Fay
 */
 
/*
 * Given an array of strings, return a Map<String, Integer> containing a key for every different string in the array, and the value is that string's length.
 * wordLen(["a", "bb", "a", "bb"]) → {"bb": 2, "a": 1}
 * wordLen(["this", "and", "that", "and"]) → {"that": 4, "and": 3, "this": 4} 
 * wordLen(["code", "code", "code", "bug"]) → {"code": 4, "bug": 3}
 */
import java.util.*; 
 
class wordLenDemo {
	public static void main(String[] args) {
		String[] testCase1 = new String[] { "a", "bb", "a", "bb" };
		String[] testCase2 = new String[] { "this", "and", "that" };
		String[] testCase3 = new String[] { "code", "code", "code", "bug" };
		
		System.out.println(Arrays.asList(wordLen(testCase1)));
		System.out.println(Arrays.asList(wordLen(testCase2)));
		System.out.println(Arrays.asList(wordLen(testCase3)));
	}
	
	public static Map<String, Integer> wordLen(String[] strings) {
		Map<String, Integer> result = new HashMap<>();
		for (String x : strings) 
			result.put(x, x.length());
		return result;
	}
	
}