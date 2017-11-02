/*
 * Problem 3
 * from https://techdevguide.withgoogle.com/paths/foundational/
 * created 10.11.2017 by CB Fay
 * updated 10.18.2017 by CB Fay
 */

/*
Consider the leftmost and righmost appearances of some value in an array.
We'll say that the "span" is the number of elements between the two
inclusive. A single value has a span of 1. Returns the largest span found in
the given array. (Efficiency is not a priority.)
*/

class Stats {

   // solution method
   public int maxSpan(int[] nums) {

      int max = 1; // the highest total span
      int current; // keeps track of the current element's span
      int span; // the span between individual intances of each element

      // don't bother checking arrays with no elements
      if(nums.length == 0) return 0;

      // total passes
      for (int i = 0; i < nums.length; i++) {
         current = 0;
         span = 1;

         // individual passes
         for (int j = i+1; j < nums.length; j++) {
            span++;
            if (nums[j] == nums[i]) {
               current += span;
               span = 0;
            }
         }

         if (current > max) max = current;
      }

      return max;
   }

}

 class maxSpanDemo {

    public static void main(String[] args) {
      int[] numbers = {1, 0, 2, 3, 6,  3, 4, 7, 4, 5, 0, 0, 9, 7, 6, 3 };
      Stats finder = new Stats();

      System.out.println(finder.maxSpan(numbers));
    }
}
