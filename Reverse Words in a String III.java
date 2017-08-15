public class Solution {
    public String reverseWords(String s) {
        if(s.length() == 0 || s == null)
            return "";
        String[] str = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i <= str.length - 1; i++)
        {
            String str2 = str[i];
            String reverse = "";
            for(int j = str2.length() - 1;  j >= 0; j--)
            {
                reverse = reverse + str2.charAt(j);   
            }
            sb.append(reverse).append(" ");
        }
        return sb.substring(0,sb.length() - 1);
    }
}