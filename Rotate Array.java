public class Solution {
    public void rotate(int[] nums, int k) {
        if(nums.length == 0 || k < 0)
            return;
        int length = nums.length;
        k = k % length;
        rotate(nums,0,length - k - 1);
        rotate(nums,length - k, length - 1);
        rotate(nums,0,length - 1);
    }
    public static void rotate(int[] nums, int start, int end){
        if(nums == null || nums.length == 1)
            return;
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}