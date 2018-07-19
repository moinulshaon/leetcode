import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.function.BiFunction;

class Solution {
	
	Map<Character, String> map = new HashMap<Character, String>() {{
		put('2', "abc");
		put('3', "def");
		put('4', "ghi");
		put('5', "jkl");
		put('6', "mno");
		put('7', "pqrs");
		put('8', "tuv");
		put('9', "wxyz");
	}};
	
	private List<String> ans;
	
	private void calc(String digits, int ind, Stack<Character> stk) {
		if (ind == digits.length()) {
			ans.add(
					stk.stream().reduce(new StringBuilder(), 
							(sb, c) -> sb.append(c), 
							(sb, c) -> sb.append(c)).toString());
			return;
		}
		
		for (char c: map.get(digits.charAt(ind)).toCharArray()) {
			stk.push(c);
			calc(digits, ind+1, stk);
			stk.pop();
		}
	}
	
    public List<String> letterCombinations(String digits) {
    	
    	if (digits.isEmpty())return Collections.emptyList();
    	
        ans = new ArrayList<>();
    	calc(digits, 0, new Stack<Character>());
    	return ans;
    }
}