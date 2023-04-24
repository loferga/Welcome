package ilu2;

import java.util.Arrays;

public class Welcome {
	
	private static final String WELCOME_ANY = "Hello, my friend";
	
	private static String firstLetterUpperCase(String input) {
		return input.substring(0, 1).toUpperCase() .concat(input.substring(1));
	}
	
	private static String[][] sortByCase(String[] names) {
		String[] upperCase = new String[names.length];
		int nbUpperCase = 0;
		String[] lowerCase = new String[names.length];
		int nbLowerCase = 0;
		
		for (String name : names) {
			if (name.toUpperCase().equals(name))
				upperCase[nbUpperCase++] = name;
			else lowerCase[nbLowerCase++] = name;
		}
		
		return new String[][] {
				Arrays.copyOf(lowerCase, nbLowerCase),
				Arrays.copyOf(upperCase, nbUpperCase)
			};
	}
	
	private static String welcomeNames(String[] names) {
		if (names.length == 0) return "";
		StringBuilder sb = new StringBuilder();
		sb.append("Hello");
		for (int i = 0; i<names.length; i++) {
			sb.append(", ");
			sb.append(firstLetterUpperCase(names[i].trim()));
		}
		return sb.toString();
	}
	
	public static String welcome(String input) {
		if (input == null || input.trim().equals("")) return WELCOME_ANY;
		
		String[] split = input.split(",");
		
		String[][] sortedNames = sortByCase(split);
		String[] lowerCaseNames = sortedNames[0];
		String[] upperCaseNames = sortedNames[1];
		
		StringBuilder sb = new StringBuilder();
		sb.append(welcomeNames(lowerCaseNames));
		if (upperCaseNames.length > 0) {
			if (lowerCaseNames.length > 0) sb.append(". AND ");
			sb.append(welcomeNames(upperCaseNames).toUpperCase());
			sb.append(" !");
		}
		return sb.toString();
	}
	
}