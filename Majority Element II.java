public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();

        if(nums.length == 0)
            return result;
        
        int count1 = 0, count2 = 0;
        int major1 = 0;
        int major2 = 0;
        for (int num : nums){
            if(num == major1)
                count1++;
            else if(num == major2)
                count2++;
            else if(count1 == 0){
                major1 = num;
                count1 = 1;
                continue;
            }
            else if(count2 == 0){
                major2 = num;
                count2 = 1;
                continue;
            }
            else{
                count1--;
                count2--;
                //System.out.println("***");
            }
        }
        
        count1 = count2 = 0;
        for(int num: nums){
            if(num == major1)
                count1++;
            else if(num == major2)
                count2++;
        }
        if(count1 > nums.length/3)
            result.add(major1);
        if(count2 > nums.length/3)
            result.add(major2);
        return result;
    }
}