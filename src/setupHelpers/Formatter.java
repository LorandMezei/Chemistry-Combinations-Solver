package setupHelpers;

import java.util.HashMap;

public class Formatter {
	private static final HashMap<Character, Character> digitsToSubscripts = new HashMap<Character, Character>();
	private static final HashMap<Character, Character> subscriptsToDigits = new HashMap<Character, Character>();
	
	public static HashMap<Character, Character> getDigitsToSubscripts() {
		digitsToSubscripts.put('0', '\u2080');
		digitsToSubscripts.put('1', '\u2081');
		digitsToSubscripts.put('2', '\u2082');
		digitsToSubscripts.put('3', '\u2083');
		digitsToSubscripts.put('4', '\u2084');
		digitsToSubscripts.put('5', '\u2085');
		digitsToSubscripts.put('6', '\u2086');
		digitsToSubscripts.put('7', '\u2087');
		digitsToSubscripts.put('8', '\u2088');
		digitsToSubscripts.put('9', '\u2089');
		
		return digitsToSubscripts;
	}
	
	public static HashMap<Character, Character> getSubscriptsToDigits() {
		subscriptsToDigits.put('\u2080', '0');
		subscriptsToDigits.put('\u2081', '1');
		subscriptsToDigits.put('\u2082', '2');
		subscriptsToDigits.put('\u2083', '3');
		subscriptsToDigits.put('\u2084', '4');
		subscriptsToDigits.put('\u2085', '5');
		subscriptsToDigits.put('\u2086', '6');
		subscriptsToDigits.put('\u2087', '7');
		subscriptsToDigits.put('\u2088', '8');
		subscriptsToDigits.put('\u2089', '9');
		
		return subscriptsToDigits;
	}

}
