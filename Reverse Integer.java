public class Solution {
    public int reverse(int x) {
        int num = x, rem;
        long result = 0;
        while (num != 0){
            rem = num % 10;
            num = num / 10;
            result = result * 10 + rem;
            if( result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)
                return 0;
        }
        return (int)result;
    }
}