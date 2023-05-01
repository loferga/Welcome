package ilu2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class WelcomeTest {
	
	private static final String BOB = "Bob";
	private static final String JERRY = "Jerry";

	@Test
	void test_ex01() {
		assertEquals("Hello, Bob", Welcome.welcome(BOB));
		assertEquals("Hello, Jerry", Welcome.welcome(JERRY));
	}
	
	@Test
	void test_ex02() {
		final String RETOUR_ATTENDU = "Hello, my friend";
		assertEquals(RETOUR_ATTENDU, Welcome.welcome(null));
		assertEquals(RETOUR_ATTENDU, Welcome.welcome(""));
		assertEquals(RETOUR_ATTENDU, Welcome.welcome(" "));
		assertEquals(RETOUR_ATTENDU, Welcome.welcome("       "));
	}
	
	@Test
	void test_ex03() {
		assertEquals("HELLO, BOB !", Welcome.welcome(BOB.toUpperCase()));
		assertEquals("HELLO, JERRY !", Welcome.welcome(JERRY.toUpperCase()));
	}
	
	@Test
	void test_ex04() {
		assertEquals("Hello, Bob and Jerry", Welcome.welcome("bob,jerry"));
	}
	
	@Test
	void test_ex05() {
		assertEquals("Hello, Amy, Bob and Jerry", Welcome.welcome("amy, bob, jerry"));
	}
	
	@Test
	void test_ex06() {
		assertEquals(
				"Hello, Amy and Jerry. AND HELLO, BOB !",
				Welcome.welcome("amy, BOB, jerry")
			);
	}
	
	@Test
	void test_ex07() {
		assertEquals(
				"Hello, Bob, Amy and Jerry",
				Welcome.welcome("Bob, Amy, Jerry")
			);
		assertEquals(
				"Hello, Bob and Jerry. AND HELLO, AMY AND JACK !",
				Welcome.welcome("Bob, AMY, Jerry, JACK")
			);
	}
	
	@Test
	void test_ex08() {
		assertEquals(
				"Hello, Bob and Amy",
				Welcome.welcome("Bob        , Amy    ")
			); 
	}
	
	@Test
	void test_ex09() {
		assertEquals(
				"Hello, Bob (x3) and Amy. AND HELLO, JERRY (x2) !",
				Welcome.welcome("Bob, JERRY, Amy, Bob, JERRY, Bob")
			);
		assertEquals(
				"Hello, Bob (x2). AND HELLO, BOB (x2) AND JERRY (x2) !",
				Welcome.welcome(BOB + ", " + BOB.toUpperCase() + ", " + JERRY.toUpperCase() + ", " + BOB + ", " + JERRY.toUpperCase() + ", " + BOB.toUpperCase())
			);
		assertEquals(
				"Hello, Bob (x2). AND HELLO, JERRY (x2) AND BOB (x2) !",
				Welcome.welcome(BOB + ", " + JERRY.toUpperCase() + ", " + BOB.toUpperCase() + ", " + BOB + ", " + JERRY.toUpperCase() + ", " + BOB.toUpperCase())
			);
	}
	
	@Test
	void test_ex10() {
		// "Amy, Yoda, and Bob, Hello. AND HELLO JERRY !" -> "Bob, Yoda and Amy, Hello. AND HELLO, JERRY !"
		//           ^                          ^                      ^                         ^
		// Yoda change l'ordre des noms donc l'ordre des nom est celui inverse de celui de leur apparition
		assertEquals(
				"Amy, Yoda and Bob, Hello. AND HELLO, JERRY !",
				Welcome.welcome("Bob, Yoda, Amy, JERRY")
			);
		// "Hello, Bob and Amy. AND YODA (X2) AND JERRY HELLO !" -> "Hello, Bob and Amy. AND JERRY AND YODA (x2), HELLO !"
		//                                ^            ^                                                     ^  ^
		// YODA vient avant JERRY dans la liste des noms et comme YODA inverse le sens des noms donc YODA doit être placé après JERRY
		assertEquals(
				"Hello, Bob and Amy. AND JERRY AND YODA (x2), HELLO !",
				Welcome.welcome("Bob, YODA, Amy, JERRY, YODA")
			);
	}

}
