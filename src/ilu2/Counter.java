package ilu2;

public class Counter {
	
	private String name;
	private int occurences = 1;
	
	public Counter(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public int getOccurences() {
		return occurences;
	}
	
	public void addOccurence() {
		this.occurences++;
	}
	
}