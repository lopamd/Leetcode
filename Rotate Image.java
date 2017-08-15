public class Solution {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)  
	        	return ;
	        int m = matrix.length, n = matrix[0].length;
	        int[][] rvalue = new int[n][m];
	        for (int i = 0; i < m; i++)
	            for (int j = 0; j < n; j++)
	                rvalue[i][j] = matrix[j][i];
	 
	        for (int i = 0; i < m; i++)
	            for (int j = 0; j < n / 2; j++) {
	                	rvalue[i][j] ^= rvalue[i][n-j-1];
	                	rvalue[i][n-j-1] ^= rvalue[i][j];
	                	rvalue[i][j] ^= rvalue[i][n-j-1];
	                }
	        for (int i = 0; i < m; i++)
	            for (int j = 0; j < n; j++)
	                matrix[i][j] = rvalue[i][j];
	        
    }
}