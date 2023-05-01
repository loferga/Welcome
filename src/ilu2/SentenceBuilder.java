package ilu2;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.UnaryOperator;

public class SentenceBuilder {
	
	private String[] keywords;
	private String[] names;
	private int nbNames = 0;
	private boolean isReversed = false;
	
	public SentenceBuilder(int maxNames, String[] keywords) {
		names = new String[maxNames];
		this.keywords = keywords;
	}
	
	public void append(String name, int occ) {
		String toAdd = name
				+ (occ > 1 ?
						(" (x" + occ + ')')
						: ""
					);
		names[nbNames++] = toAdd;
	}
	
	public void append(String word) {
		names[nbNames++] = word;
	}
	
	public void setReverse(boolean isReversed) {
		this.isReversed = isReversed;
	}
	
	private Iterator<String> iterator() {
		return new Iterator<String>() {
			
			private int index = isReversed ? nbNames-1 : 0;
			private UnaryOperator<Integer> next = isReversed ? e -> e-1 : e -> e+1;
			
			@Override
			public boolean hasNext() {
				return (isReversed && index >= 0)
						|| (!isReversed && index < nbNames);
			}
			
			@Override
			public String next() {
				if (!hasNext()) throw new NoSuchElementException();
				String toReturn = names[index];
				index = next.apply(index);
				return toReturn;
			}
				
		};
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		if (!isReversed) sb.append(keywords[0] + ", ");
		
		Iterator<String> it = this.iterator();
		String current = it.next();
		String next = null;
		boolean hasNext = it.hasNext();
		while (hasNext) {
			next = it.next();
			sb.append(current);
			hasNext = it.hasNext();
			if (hasNext) sb.append(',');
			sb.append(' ');
			current = next;
		}
		if (next == null) sb.append(current);
		else sb.append(keywords[1] + ' ' + current);
		
		if (isReversed) sb.append(", " + keywords[0]);
		sb.append(keywords[2]);
		return sb.toString();
	}
	
}