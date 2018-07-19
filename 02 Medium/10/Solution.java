import java.util.Arrays;

public class Solution {

	private boolean isSame(char a, char b) {
		if (b == '.')
			return true;
		else
			return a == b;
	}

	int n;
	int m;

	int[][] dp;

	private int func(String s, int si, String p, int pi) {
		if (pi == p.length()) {
			return (si == s.length())?1:0;
		} else if (si == s.length()) {
			while (pi+1<p.length()) {
				if (p.charAt(pi+1) == '*') {
					pi += 2;
				} else {
					break;
				}
			}
			return (pi==p.length())?1:0;
		}

		int ret = dp[si][pi];
		if (ret != -1)
			return ret;

		if (isSame(s.charAt(si), p.charAt(pi)) && func(s, si + 1, p, pi + 1) > 0) {
			return dp[si][pi] = 1;
		}
		if (pi + 1 < p.length() && p.charAt(pi + 1) == '*') { 
			if ((isSame(s.charAt(si), p.charAt(pi)) && func(s, si+1, p, pi) > 0 )  || func(s, si, p, pi+2) > 0) {
				return dp[si][pi] = 1;
			}
		}
		return dp[si][pi] = 0;
	}

	public boolean isMatch(String s, String p) {
		n = s.length();
		m = p.length();

		dp = new int[n][m];
		for (int[] tmp : dp) {
			Arrays.fill(tmp, -1);
		}
		
		// System.out.println(func(s, 0, p, 0));
		return func(s, 0, p, 0) >0;
	}
}