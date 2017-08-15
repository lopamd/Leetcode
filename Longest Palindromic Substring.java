public class Solution {
    public String longestPalindrome(String s) {
        if(s == null)
            return null;
        if(s.length() < 2)
            return s;
        int length = s.length();
        int max_length = 1;
        int start_point = 0;
        boolean[][] matrix = new boolean[length][length];
        for(int i = 0; i < length ; i++)
            matrix[i][i] = true;
        for(int i = 0; i < length - 1; i++){
            if(s.charAt(i) == s.charAt(i+1)){
                matrix[i][i+1] = true;
                start_point = i;
                max_length = 2;
            }
        }
        for(int k = 3; k <= length; k++){
            for(int i = 0; i < length - k + 1; i++){
                int j = i + k - 1;
                if(s.charAt(i) == s.charAt(j) && matrix[i+1][j-1]){
                    matrix[i][j] = true;
                    start_point = i;
                    max_length = k;
                }
                    
            }
        }
        return s.substring(start_point,max_length + start_point);
    }
}