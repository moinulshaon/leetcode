import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
	
	private static Stack<Character> stk = new Stack<>();
	private List<String> ans = new ArrayList<>();;
	
	private void backtrack(int low,int high,int count) {
		if (count<0)return;
		if (low ==0 && high==0) {
			ans.add(
					stk.stream().reduce(new StringBuilder(), (sb, c) -> sb.append(c), (sb, c) -> sb.append(c)).toString()
					);
			return;
		}
		if (low>0) {
			stk.push('(');
			backtrack(low-1,high, count+1);
			stk.pop();
		}
		if (high>0 && count-1>=0) {
			stk.push(')');
			backtrack(low,high-1, count-1);
			stk.pop();
		}
	}
	
    public List<String> generateParenthesis(int n) {
        ans.clear();
        backtrack(n,n,0);
        return ans;
    }
}