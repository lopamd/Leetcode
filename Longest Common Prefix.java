public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0)
            return "";
        int i = 1;
        String pre = strs[0];
        while(i < strs.length){
            while(strs[i].indexOf(pre) != 0){
                pre = pre.substring(0,pre.length() - 1);
                System.out.println(pre);
            }
            i++;
            System.out.println(i);
        }
        return pre;
    }
}