public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int length = nums.length;
        int result = 0;
        int min = Integer.MAX_VALUE;
        if(length == 0 || length < 3)
            return 0;
        Arrays.sort(nums);
        for(int i = 0; i < length - 2; i++){
           int left = i + 1, right = length -1;
               while(left < right){
                   int sum = nums[i]+nums[left]+nums[right];
                   if(sum == target)
                        return sum;
                    int diff = Math.abs(target - sum);
                    if(diff < min){
                        min = diff;
                        result = sum;
                    }
                    if(sum <= target)
                        left++;
                    else
                        right--;
               }
           }
        
        return result;
    }
}