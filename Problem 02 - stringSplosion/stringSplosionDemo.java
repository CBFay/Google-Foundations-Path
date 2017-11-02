/*
 * Problem 2
 * from https://techdevguide.withgoogle.com/paths/foundational/
 * created 10.11.2017 by CB Fay
 * updated 10.18.2017 by CB Fay
 */

// Given a non-empty string like "Code" return a string like "CCoCodCode"

class Explode {

  // solution method
  public String stringSplosion(String str) {
    String exp = "";

    for (int i = 0; i < str.length(); i++) {
      for(int j = 0; j <= i; j++) {
        exp += str.charAt(j);
      }
    }

    return exp;
  }

  // this is the way CodingBat solved the problem
  public String stringSplosion2(String str) {
    String result = "";
    // On each iteration, add the substring of the chars 0..i
    for (int i=0; i<str.length(); i++) {
      //this is similar to slicing in Python
      result = result + str.substring(0, i+1);
    }
    return result;
  }

}

class stringSplosionDemo {

  public static void main(String[] args) {

    Explode exp = new Explode();
    System.out.println(exp.stringSplosion("Cats"));
    System.out.println(exp.stringSplosion2("Cats"));
  }

}
