/*
 * Problem 7
 * from https://techdevguide.withgoogle.com/paths/foundational/
 * created 10.20.2017 by CB Fay
 */
 
//Return an array that contains the sorted values from the input array with duplicates removed.

// Method sortRemove2 is more efficient and doesn't rely on an ArrayList

import java.util.*;

class SortArray {
	
	public static void main(String[] args) {
		
		int[] unsorted = new int[] { 5, 7, 1, 3, 2, 8, 5, 2, 4, 3, 8, 10 };
			
		System.out.print("Method 1: ");
		System.out.println(Arrays.toString(SortArray.sortRemove1(unsorted)));
		
		System.out.print("Method 2: ");
		System.out.println(Arrays.toString(SortArray.sortRemove2(unsorted)));
			
	}
	
	// solution 1
	static int[] sortRemove1(int[] unsorted) {
		
		// don't bother with arrays that have no elements
		if (unsorted.length == 0) return unsorted;
		
		// sort the array
		Arrays.sort(unsorted);
		
		// add elements of the array to sortedList, but not duplicates
		ArrayList<Integer> sortedList = new ArrayList<Integer>();
		
			for (int i = 0; i < unsorted.length-1; i++) {
				
				if (unsorted[i] != unsorted[i+1]) {
					sortedList.add(unsorted[i]);
				}
			}
			
			// add the final element of unsorted.
			sortedList.add(unsorted[unsorted.length-1]);

		// add the elements of sortedList back into an array
		int[] sorted = new int[sortedList.size()];
		
			for (int i = 0; i < sortedList.size(); i++) {
				sorted[i] = sortedList.get(i);
			}
			
		return sorted;
	}
	
	// solution 2
	static int[] sortRemove2(int[] unsorted) {
		
		// don't bother with arrays that have no elements
		if (unsorted.length == 0) return unsorted;
		
		// sort the array
		Arrays.sort(unsorted);
		
		// find the size of the array that will be returned
		int newSize = 1;

			for (int i = 0; i < unsorted.length-1; i++) {
				
				if (unsorted[i] != unsorted[i+1]) {
					newSize++;
				}
			}
		
		// create and fill the array that will be returned
		int[] sorted = new int[newSize];
			
			for (int i = 0, j = 0; i < unsorted.length-1; i++) {
				
				if (unsorted[i] != unsorted[i+1]) {
					sorted[j] = unsorted[i];
					j++;
				}
			}
			sorted[sorted.length-1] = unsorted[unsorted.length-1];
			
		return sorted;
	}
}