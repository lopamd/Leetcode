public class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        if(nums.length == 0)
            return -1;
        else
            for(int i = 0; i < nums.length; i++){
                res ^= nums[i];
            }
        return res;
    }
}