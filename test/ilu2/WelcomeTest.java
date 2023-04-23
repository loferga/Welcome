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

}
