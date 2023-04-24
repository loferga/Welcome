package ilu2;

import java.util.Arrays;

public class CounterHolder {
	
	private Counter[] couples;
	private int nbCouples = 0;
	
	public CounterHolder(int maxCouples) {
		couples = new Counter[maxCouples];
	}
	
	public void addName(String name) {
		for (int i = 0; i<nbCouples; i++)
			if (couples[i].getName().equalsIgnoreCase(name)) {
				couples[i].addOccurence();
				return;
			}
		couples[nbCouples++] = new Counter(name);
	}
	
	public Counter[] cut() {
		return Arrays.copyOf(couples, nbCouples);
	}
	
}