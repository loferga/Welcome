package ilu2;

public class Welcome {
	
	private static final String WELCOME_ANY = "Hello, my friend";
	
	private static String firstLetterUpperCase(String input) {
		return input.substring(0, 1).toUpperCase() .concat(input.substring(1));
	}
	
	public static String welcome(String input) {
		if (input == null || input.trim().equals("")) return WELCOME_ANY;
		
		StringBuilder sb = new StringBuilder();
		sb.append("Hello, ");
		sb.append(firstLetterUpperCase(input));
		return sb.toString();
	}
	
}