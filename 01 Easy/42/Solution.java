class Solution {
    public int trap(int[] height) {
        int n = height.length;
        
        if (n<=1)return 0;
        
        int []fromLeft = new int[n];
        int []fromRight = new int[n];
        
        fromLeft[0] = height[0];
        for (int i=1;i<n;++i) {
        	fromLeft[i] = Math.max(fromLeft[i-1], height[i]);
        }
        
        fromRight[n-1] = height[n-1];
        for (int i=n-2;i>=0;--i) {
        	fromRight[i] = Math.max(fromRight[i+1], height[i]);
        }
        
        int ans = 0;
        for (int i=0;i<n;++i) {
        	ans += Math.min(fromLeft[i], fromRight[i]) - height[i];
        }
        return ans;
    }
}