import java.util.Arrays;

class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        
        boolean done = false;
        for (int i=n-2;i>=0;--i) {
        	if (nums[i+1] > nums[i]) {
        		int ind = -1;
        		int tmp = Integer.MAX_VALUE;
        		
        		for (int j=i;j<n;++j) {
        			if (nums[j] > nums[i] && nums[j]<= tmp) {
        				tmp = nums[j];
        				ind = j;
        			}
        		}
        		
        		tmp = nums[i];
        		nums[i] = nums[ind];
        		nums[ind] = tmp;
        		
        		Arrays.sort(nums, i+1, nums.length);
        		
        		done =true;
        		break;
        	}
        }
        if (!done) Arrays.sort(nums);
    }
}