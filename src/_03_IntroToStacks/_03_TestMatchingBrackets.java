package _03_IntroToStacks;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Stack;

import org.junit.Test;

public class _03_TestMatchingBrackets {

	@Test
	public void testMatchingBrackets() {
		assertTrue(doBracketsMatch("{}"));
		assertTrue(doBracketsMatch("{{}}"));
		assertTrue(doBracketsMatch("{}{}{{}}"));
		assertFalse(doBracketsMatch("{{}"));
		assertFalse(doBracketsMatch("}{"));
	}

	// USE A STACK TO COMPLETE THE METHOD FOR CHECKING IF EVERY OPENING BRACKET HAS
	// A MATCHING CLOSING BRACKET
	private boolean doBracketsMatch(String b) {
		boolean matchingBrackets = false;
		Stack<Character> brackets = new Stack<Character>();
		Stack<Character> check = new Stack<Character>();
		for (int i = 0; i < b.length(); i++) {
			char letter = b.charAt(i);
			brackets.push(letter);
		}
		for (int i = 0; i < b.length(); i++) {
			if (!brackets.isEmpty()) {
				Character newBracket = brackets.pop();
				if (newBracket == '}') {
					check.push(newBracket);
				} else if (!check.isEmpty() && newBracket == '{') {
					check.pop();
				} else if (check.isEmpty() && newBracket == '{') {
					matchingBrackets = false;
					check.push(newBracket);
					break;
				}
			}
		}
		if (check.isEmpty()) {
			matchingBrackets = true;
		}
		System.out.println(matchingBrackets);
		return matchingBrackets;
	}
}