public class Solution {
    public int missingNumber(int[] nums) {
        if(nums.length == 0)
            return -1;
        int length = nums.length;
         System.out.println(length);
        int sum = length * (length + 1)/2;
        System.out.println(sum);
        for(int i = 0; i < length ; i++){
            sum -= nums[i];
        }
        return sum;
    }
}