package ilu2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class WelcomeTest {

	@Test
	void test_ex1() {
		assertEquals("Hello, Bob", Welcome.welcome("bob"));
		assertEquals("Hello, Jerry", Welcome.welcome("jerry"));
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
		final String BOB = "bob";
		final String JERRY = "jerry";
		assertEquals("HELLO, " + BOB.toUpperCase() + " !", Welcome.welcome(BOB.toUpperCase()));
		assertEquals("HELLO, " + JERRY.toUpperCase() + " !", Welcome.welcome(JERRY.toUpperCase()));
	}
	
	@Test
	void test_ex4() {
		final String BOB = "Bob";
		final String JERRY = "Jerry";
		assertEquals("Hello, " + BOB + ", " + JERRY, Welcome.welcome(BOB + "," + JERRY));
	}
	
	@Test
	void test_ex5() {
		final String AMY = "Amy";
		final String BOB = "Bob";
		final String JERRY = "Jerry";
		assertEquals("Hello, " + AMY + ", " + BOB + ", " + JERRY, Welcome.welcome(AMY + ", " + BOB + "," + JERRY));
	}

}
