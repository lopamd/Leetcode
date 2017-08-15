public class Solution {
    public boolean isPalindrome(int x) {
        //all -ve numbers will not be in pallindrome and base case includes 10
        if(x < 0 || (x != 0 && x % 10 == 0))
            return false;
        int rev = 0;
        while(x > rev){
            //reverseing the integer
            rev = rev * 10 + x % 10;
            x /= 10;
        }
        return (x == rev || x == rev / 10);
    }    
}