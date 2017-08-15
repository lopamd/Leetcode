public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        int length = nums.length;
        if( length == 0 || length < 3)
            return list;
        Arrays.sort(nums);
        for(int i = 0; i < length - 2; i++){
            
            if(i == 0 || nums[i] > nums[i-1])
            {
                int l = i + 1;
                int r = length - 1;
            while(l < r){
                if(nums[i] + nums[l] + nums[r] == 0 ){
                    List<Integer> res = new ArrayList<Integer>();
                    res.add(nums[i]);
                    res.add(nums[l]);
                    res.add(nums[r]);
                    list.add(res);
                    l++;
                    r--;
                    while(l < r && nums[l] == nums[l - 1])
                        l++;
                    while(l < r && nums[r] == nums[r + 1])
                        r--;
                }
                else if(nums[i] + nums[l] + nums[r] < 0)
                    l++;
                else
                    r--;
            }
            }
        }
        return list;
    }
}