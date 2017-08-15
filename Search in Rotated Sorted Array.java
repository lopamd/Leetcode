public class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 1 && nums[0] == target)
            return 0;
        if(nums.length == 0)
            return -1;
        int low = 0, high = nums.length - 1;
        while(low < high){
            int mid = (high + low)/2;
            if(nums[mid] == target)
                return mid;
            if(nums[mid] > nums[high])
                low = mid + 1;
            else
                high = mid;
        }
        int rotation = low;
        int low1 = 0; int high1 = nums.length - 1;
        if(target > nums[high1])
                high1 = rotation - 1;
            else
                low1 = rotation;
        while(low1 <= high1){
            int mid = (high1 + low1)/2;
            if(target == nums[mid])
                return mid;
            if(target < nums[mid])
                high1 = mid - 1;
            else
                low1 = mid + 1;
            
        }
        return -1;
    }
}