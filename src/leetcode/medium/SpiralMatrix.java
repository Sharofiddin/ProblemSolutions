package leetcode.medium;
public class SpiralMatrix{
        public static int[][] generateMatrix(int n) {
         int[][] ret = new int[n][n];    
         int i = 0;
         int right = n-1;
         int left = 0;
         int bottom = n-1;
         int top = 0;
         while(i < n*n){
            for(int j = left; j <= right; j++){
                ret[top][j] = ++i;
            }
            top++;
            for(int j = top; j <= bottom; j++){
                ret[j][right] = ++i;
            }
            right--;
            
    
            for(int j = right; j >= left; j--){
                ret[bottom][j] = ++i;
            }
            bottom--;
            for(int j = bottom; j>=top; j--){
                ret[j][left] = ++i;
            }
            left++;
         }
         return ret;
        }
    public static void main(String[] args) {
        printMatrix(generateMatrix(5));
        printMatrix(generateMatrix(1));
        printMatrix(generateMatrix(4));
    }

    public static void printMatrix(int[][] mat){
        for (int i = 0; i <  mat.length;i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
            
        }
    }
}