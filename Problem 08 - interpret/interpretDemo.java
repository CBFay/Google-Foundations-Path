/*
 * Problem 8
 * from https://techdevguide.withgoogle.com/paths/foundational/
 * created 10.24.2017 by CB Fay
 */

/*
 Write a simple interpreter which understands "+", "-", and "*" operations.
 Apply the operations in order using command/arg pairs starting with the 
 initial value of `value`. If you encounter an unknown command, return -1.
 class Interpreter {
 */
 
class interpretDemo {
	
	public int interpret(int value, String[] commands, int[] args) {		
		if (commands.length != args.length) return -1; // prevents an IndexOutOfBoundsException
		
		int result = value;
		
		for (int i = 0; i < commands.length; i++) {
			switch(commands[i]) {
				case "+" :
					result += args[i];
					break;
				case "-" :
					result -= args[i];
					break;
				case "*" :
					result *= args[i];
					break;
				default :
					return -1;
			}
		}
		return result;
	} // <- interpret method
	
} // <- interpretDemo class