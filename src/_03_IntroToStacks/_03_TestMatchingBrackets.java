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

	// USE A STACK TO COMPLETE THE METHOD FOR CHECKING IF EVERY OPENING BRACKET HAS A MATCHING CLOSING BRACKET
	private boolean doBracketsMatch(String b) {
		boolean matchingBrackets=false;
		Stack <Character> brackets=new Stack<Character>();
		for (int i = 0; i<b.length(); i++) {
			char letter=b.charAt(i);
			brackets.push(letter);
		}
		for(int i=0; i<b.length(); i++) {
			Character newBracket=brackets.pop();
			if(newBracket=='{') {
				brackets.push(newBracket);
			}
			else if(newBracket=='}') {
				brackets.pop();
			}
			if(brackets.isEmpty()) {
				matchingBrackets=true;
			}
			}
	System.out.println(matchingBrackets);
		System.out.println(matchingBrackets);
		return matchingBrackets;
		}
	}