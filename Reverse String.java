public class Solution {
    public String reverseString(String s) {
        if(s == null || s.length() == 0)
            return "";
        int length = s.length();
        char arr[] = s.toCharArray();
        for(int i = 0,j = length - 1; i < length/2; i++,j--){
            //swap(s.charAt(i),s.charAt(length - 1));
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        s = new String(arr);
        return s;
    }
}