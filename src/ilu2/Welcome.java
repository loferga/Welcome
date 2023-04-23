package ilu2;

public class Welcome {
	
	private static final String WELCOME_ANY = "Hello, my friend";
	
	private static String firstLetterUpperCase(String input) {
		return input.substring(0, 1).toUpperCase() .concat(input.substring(1));
	}
	
	public static String welcome(String input) {
		if (input == null || input.trim().equals("")) return WELCOME_ANY;
		
		String[] split = input.split(",");
		
		StringBuilder sb = new StringBuilder();
		if (input.toUpperCase().equals(input)) { // upperCase mode
			sb.append("HELLO");
			for (int i = 0; i<split.length; i++)
				sb.append(", " + split[i].trim());
			sb.append(" !");
		} else {
			sb.append("Hello");
			for (int i = 0; i<split.length; i++)
				sb.append(", " + firstLetterUpperCase(split[i].trim()));
		}
		return sb.toString();
	}
	
}