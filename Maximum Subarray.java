public class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length == 0)
            return 0;
        if(nums.length == 1)
            return nums[0];
        int max_curr = nums[0];
        int max_prev = nums[0];
        for (int i = 1; i < nums.length ; i++){
            max_curr = max_curr + nums[i];
            max_curr = Math.max(nums[i],max_curr);
            max_prev = Math.max(max_curr,max_prev);
            
        }
        return max_prev;
    }
}