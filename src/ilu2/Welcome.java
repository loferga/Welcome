package ilu2;

import java.util.function.UnaryOperator;

public class Welcome {
	
	private static final String WELCOME_ANY = "Hello, my friend";
	
	private static String firstLetterUpperCase(String input) {
		return input.substring(0, 1).toUpperCase() .concat(input.substring(1));
	}
	
	private static Counter[][] sortByCase(String[] names) {
		CounterHolder lowerCase = new CounterHolder(names.length);
		CounterHolder upperCase = new CounterHolder(names.length);
		
		for (int i = 0; i<names.length; i++) {
			String name = names[i].trim();
			if (name.toUpperCase().equals(name))
				upperCase.addName(name);
			else lowerCase.addName(name);
		}
		
		return new Counter[][] { lowerCase.cut(), upperCase.cut() };
	}
	
	/**
	 * @param names names to process
	 * @param mode give what to add to the sentence, suit the following format:
	 * mode[0]: start the sentence with
	 * mode[1]: "and" keyword
	 * mode[2]: end the sentence with
	 * @param format function that tell what to do to every names before adding it in the sentence
	 * @return the welcome String
	 */
	private static String welcomeNames(Counter[] names, String[] mode, UnaryOperator<String> format) {
		if (names.length == 0) return "";
		
		StringBuilder sb = new StringBuilder();
		sb.append(mode[0]); // start
		
		for (int i = 0; i<names.length; i++) {
			if (names.length > 1 && i == names.length-1)
				sb.append(mode[1]); // and keyword
			else sb.append(", ");
			
			sb.append( format.apply(names[i].getName()) ); // apply format to the name then add it
			
			int occurences = names[i].getOccurences();
			if (occurences > 1) sb.append(" (x" + occurences + ')');
		}
		sb.append(mode[2]); // end
		
		return sb.toString();
	}
	
	private static final String[] LOWER_MODE_FORMAT = {"Hello", " and ", ""};
	private static String welcomeLowerNames(Counter[] names) {
		return welcomeNames(names, LOWER_MODE_FORMAT, Welcome::firstLetterUpperCase);
	}
	
	private static final String[] UPPER_MODE_FORMAT = {"HELLO", " AND ", " !"};
	private static String welcomeUpperNames(Counter[] names) {
		return welcomeNames(names, UPPER_MODE_FORMAT, e -> e);
	}
	
	public static String welcome(String input) {
		if (input == null || (input = input.trim()).equals("")) return WELCOME_ANY;
		
		String[] split = input.split(",");
		
		Counter[][] sortedNames = sortByCase(split);
		Counter[] lowerCaseNames = sortedNames[0];
		Counter[] upperCaseNames = sortedNames[1];
		
		StringBuilder sb = new StringBuilder();
		sb.append(welcomeLowerNames(lowerCaseNames));
		if (upperCaseNames.length > 0) {
			if (lowerCaseNames.length > 0) sb.append(". AND ");
			sb.append(welcomeUpperNames(upperCaseNames));
		}
		return sb.toString();
	}
	
}