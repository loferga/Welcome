package ilu2;

public class Welcome {
	
	private static String firstLetterUpperCase(String input) {
		return input.substring(0, 1).toUpperCase() .concat(input.substring(1));
	}
	
	public static String welcome(String input) {
		StringBuilder sb = new StringBuilder();
		sb.append("Hello, ");
		sb.append(firstLetterUpperCase(input));
		return sb.toString();
	}
	
}