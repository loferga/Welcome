package ilu2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class WelcomeTest {
	
	private static final String AMY = "Amy";
	private static final String BOB = "Bob";
	private static final String JERRY = "Jerry";
	private static final String JACK = "Jack";
	private static final String YODA = "Yoda";

	@Test
	void test_ex01() {
		assertEquals("Hello, " + BOB, Welcome.welcome(BOB));
		assertEquals("Hello, " + JERRY, Welcome.welcome(JERRY));
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
		assertEquals("HELLO, " + BOB.toUpperCase() + " !", Welcome.welcome(BOB.toUpperCase()));
		assertEquals("HELLO, " + JERRY.toUpperCase() + " !", Welcome.welcome(JERRY.toUpperCase()));
	}
	
	@Test
	void test_ex04() {
		assertEquals("Hello, " + BOB + " and " + JERRY, Welcome.welcome(BOB + "," + JERRY));
	}
	
	@Test
	void test_ex05() {
		assertEquals("Hello, " + AMY + ", " + BOB + " and " + JERRY, Welcome.welcome(AMY + ", " + BOB + "," + JERRY));
	}
	
	@Test
	void test_ex06() {
		assertEquals(
				"Hello, " + AMY + " and " + JERRY + ". AND HELLO, " + BOB.toUpperCase() + " !",
				Welcome.welcome(AMY + ", " + BOB.toUpperCase() + ", " + JERRY)
			);
	}
	
	@Test
	void test_ex07() {
		assertEquals(
				"Hello, " + BOB + ", " + AMY + " and " + JERRY,
				Welcome.welcome(BOB + ", " + AMY + "," + JERRY)
			);
		assertEquals(
				"Hello, " + BOB + " and " + JERRY + ". AND HELLO, " + AMY.toUpperCase() + " AND " + JACK.toUpperCase() + " !",
				Welcome.welcome(BOB + ", " + AMY.toUpperCase() + ", " + JERRY + ", " + JACK.toUpperCase())
			);
	}
	
	@Test
	void test_ex08() {
		assertEquals(
				"Hello, " + BOB + " and " + AMY,
				Welcome.welcome(BOB + "        , " + AMY + "    ")
			); 
	}
	
	@Test
	void test_ex09() {
		assertEquals(
				"Hello, " + BOB + " (x3) and " + AMY + ". AND HELLO, " + JERRY.toUpperCase() + " (x2) !",
				Welcome.welcome(BOB + ", " + JERRY.toUpperCase() + ", " + AMY + ", " + BOB + ", " + JERRY.toUpperCase() + ", " + BOB)
			);
		assertEquals(
				"Hello, " + BOB + " (x2). AND HELLO, " + BOB.toUpperCase() + " (x2) AND " + JERRY.toUpperCase() + " (x2) !",
				Welcome.welcome(BOB + ", " + BOB.toUpperCase() + ", " + JERRY.toUpperCase() + ", " + BOB + ", " + JERRY.toUpperCase() + ", " + BOB.toUpperCase())
			);
		assertEquals(
				"Hello, " + BOB + " (x2). AND HELLO, " + JERRY.toUpperCase() + " (x2) AND " + BOB.toUpperCase() + " (x2) !",
				Welcome.welcome(BOB + ", " + JERRY.toUpperCase() + ", " + BOB.toUpperCase() + ", " + BOB + ", " + JERRY.toUpperCase() + ", " + BOB.toUpperCase())
			);
	}
	
	@Test
	void test_ex10() {
		// "Amy, Yoda, and Bob, Hello. AND HELLO JERRY !" -> "Bob, Yoda and Amy, Hello. AND HELLO, JERRY !"
		//           ^                          ^                      ^                         ^
		// Yoda change l'ordre des noms donc l'ordre des nom est celui inverse de celui de leur apparition
		assertEquals(
				AMY + ", " + YODA + " and " + BOB + ", Hello. AND HELLO, " + JERRY.toUpperCase() + " !",
				Welcome.welcome(BOB + ", " + YODA + ", " + AMY + ", " + JERRY.toUpperCase())
			);
		// "Hello, Bob and Amy. AND YODA (X2) AND JERRY HELLO !" -> "Hello, Bob and Amy. AND JERRY AND YODA (x2), HELLO !"
		//                                ^            ^                                                     ^  ^
		// YODA vient avant JERRY dans la liste des noms et comme YODA inverse le sens des noms donc YODA doit être placé après JERRY
		assertEquals(
				"Hello, " + BOB + " and " + AMY + ". AND " + JERRY.toUpperCase() + " AND " + YODA.toUpperCase() + " (x2), HELLO !",
				Welcome.welcome(BOB + ", " + YODA.toUpperCase() + ", " + AMY + ", " + JERRY.toUpperCase() + ", " + YODA.toUpperCase())
			);
	}

}
