import java.util.Arrays;

public class Knapsack {
    public static void main(String args[]) {
        int w = 10;
        int n = 4;
        int[] val = {10, 40, 30, 50};
        int[] wt = {5, 4, 6, 3};

        int[][] mat = new int[n + 1][w + 1];
        for (int r = 0; r < w + 1; r++) {
            mat[0][r] = 0;
        }
        for (int c = 0; c < n + 1; c++) {
            mat[c][0] = 0;
        }
        
        for (int item = 1; item <= n; item++) {
            for (int capacity = 1; capacity <= w; capacity++) {
                int maxValWithoutCurr = mat[item - 1][capacity];
                int maxValWithCurr = 0;
                
                int weightOfCurr = wt[item - 1];
                if (capacity >= weightOfCurr) {
                    maxValWithCurr = val[item - 1];
                    
                    int remainingCapacity = capacity - weightOfCurr;
                    maxValWithCurr += mat[item - 1][remainingCapacity];
                }
                
                mat[item][capacity] = Math.max(maxValWithoutCurr, maxValWithCurr);
            }
        }
        System.out.println(mat[n][w]);
        System.out.println(Arrays.deepToString(mat));
    }
}
