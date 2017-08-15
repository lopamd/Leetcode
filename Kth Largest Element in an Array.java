public class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(k < 1 || nums.length == 0)
            return 0;
        return findK(nums.length - k + 1, nums, 0, nums.length - 1);
    }
    public static int findK(int k, int[] nums, int start, int end){
        int left = start;
        int right = end;
        int pivot = nums[end];
        while(true){
            while(nums[left] < pivot && left < right)
                left++;
            while(nums[right] >= pivot && left < right )
                right--;
            if(left == right)
                break;
            swap(nums,left,right);
        }
        swap(nums,left,end);
        if( k == left + 1)
            return pivot;
        else if( k < left+1)
            return findK(k, nums, 0, left - 1);
        else return findK(k, nums, left + 1, end);
    }
    
    public static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    
    //using minheap
    /*public int findKthLargest(int[] nums, int k) {
        if(nums.length == 0)
            return 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int num : nums){
            queue.add(num);
            if(queue.size() > k)
                queue.remove();
                
        }
        return queue.peek();
    }*/
}