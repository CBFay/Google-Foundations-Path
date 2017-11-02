/*
 * Problem 6
 * from https://techdevguide.withgoogle.com/paths/foundational/
 * created 10.19.2017 by CB Fay
 */

/*
Modify and return the given map as follows: if the key "a" has a value,
set the key "b" to have that same value. In all cases remove the key "c",
leaving the rest of the map unchanged.
*/

import java.util.Map;
import java.util.HashMap;

class mapShareDemo {
	
	public static void main(String[] arg) {
		
		Map<String, String> MyMap = new HashMap<String, String>();
		
			MyMap.put("a", "aaa");
			MyMap.put("b", "bbb");
			MyMap.put("c", "ccc");
			
		System.out.println("pre-method: " + MyMap);
		mapShareDemo.mapShare(MyMap);
		System.out.println("post-method: " + MyMap);
	}

	public static Map<String, String> mapShare(Map<String, String> MyMap) {
		
		if (MyMap.get("a") != null)
			MyMap.put("b", MyMap.get("a"));
			
		MyMap.remove("c");
		
		return MyMap;
	}
	
}

