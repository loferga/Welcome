package ilu2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class WelcomeTest {
	
	private static final String AMY = "Amy";
	private static final String BOB = "Bob";
	private static final String JERRY = "Jerry";

	@Test
	void test_ex1() {
		assertEquals("Hello, " + BOB, Welcome.welcome(BOB));
		assertEquals("Hello, " + JERRY, Welcome.welcome(JERRY));
	}
	
	@Test
	void test_ex2() {
		final String RETOUR_ATTENDU = "Hello, my friend";
		assertEquals(RETOUR_ATTENDU, Welcome.welcome(null));
		assertEquals(RETOUR_ATTENDU, Welcome.welcome(""));
		assertEquals(RETOUR_ATTENDU, Welcome.welcome(" "));
		assertEquals(RETOUR_ATTENDU, Welcome.welcome("       "));
	}
	
	@Test
	void test_ex3() {
		assertEquals("HELLO, " + BOB.toUpperCase() + " !", Welcome.welcome(BOB.toUpperCase()));
		assertEquals("HELLO, " + JERRY.toUpperCase() + " !", Welcome.welcome(JERRY.toUpperCase()));
	}
	
	@Test
	void test_ex4() {
		assertEquals("Hello, " + BOB + ", " + JERRY, Welcome.welcome(BOB + "," + JERRY));
	}
	
	@Test
	void test_ex5() {
		assertEquals("Hello, " + AMY + ", " + BOB + ", " + JERRY, Welcome.welcome(AMY + ", " + BOB + "," + JERRY));
	}
	
	@Test
	void test_ex6() {
		assertEquals(
				"Hello, " + AMY + ", " + JERRY + ". AND HELLO, " + BOB.toUpperCase() + " !",
				Welcome.welcome(AMY + ", " + BOB.toUpperCase() + ", " + JERRY)
			);
	}

}
