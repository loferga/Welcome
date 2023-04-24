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
	
	public static String welcome(String input) {
		if (input == null || input.trim().equals("")) return WELCOME_ANY;
		
		String[] split = input.split(",");
		
		String[][] sortedNames = sortByCase(split);
		String[] lowerCaseNames = sortedNames[0];
		String[] upperCaseNames = sortedNames[1];
		
		boolean containLowerCaseNames = lowerCaseNames.length > 0;
		
		StringBuilder sb = new StringBuilder();
		if (containLowerCaseNames) {
			sb.append("Hello");
			for (int i = 0; i<lowerCaseNames.length; i++)
				sb.append(", " + firstLetterUpperCase(lowerCaseNames[i].trim()));
		}
		if (upperCaseNames.length > 0) {
			if (containLowerCaseNames) sb.append(". AND ");
			sb.append("HELLO");
			for (int i = 0; i<upperCaseNames.length; i++)
				sb.append(", " + upperCaseNames[i].trim());
			sb.append(" !");
		}
		return sb.toString();
	}
	
}