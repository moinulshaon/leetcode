import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

class Solution {

	private static Set<Character> leftBraces = new HashSet<Character>() {
		{
			add('(');
			add('{');
			add('[');
		}
	};

	private static boolean isLeft(char c) {
		return leftBraces.contains(c);
	}

	private static char getAlter(char c) {
		switch (c) {
		case '(':
		case ')':
			return (char) ('(' + ')' - c);
		case '{':
		case '}':
			return (char) ('{' + '}' - c);
		case '[':
		case ']':
			return (char) ('[' + ']' - c);
		default:
			return '\0';
		}
	}

	public boolean isValid(String s) {
		Stack<Character> stk = new Stack<>();
		for (char c : s.toCharArray()) {
			if (isLeft(c)) {
				stk.push(c);
			} else {
				if (stk.empty()) {
					return false;
				}
				char left = stk.pop();
				if (getAlter(c) != left) {
					return false;
				}
			}
		}
		return stk.isEmpty();
	}
}