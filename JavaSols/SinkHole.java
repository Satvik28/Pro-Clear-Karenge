package JavaSols;

import java.util.Arrays;
import java.util.Scanner;

public class SinkHole {
    static int[][] plot;
    static int k, xb, yb, xt, yt;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        plot = new int[n][m];
        int k = scanner.nextInt();
        for (int i = 0; i < k; i++) {
            plot[scanner.nextInt() - 1][scanner.nextInt() - 1] = 1;
        }
        System.out.println(Arrays.deepToString(plot));
        int[][] dp = new int[1001][1001];
//        dp[i][j] is the sub matrix of top-left (0,0) to bottom-right(i, j)
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = dp[i-1][j]+dp[i][j-1]-dp[i-1][j-1]+plot[i-1][j-1];
            }
        }
        int l = 1, r = Math.min(m,n);
        int ones;
        while (l<r){
            int mid = (l+r)/2;
            ones = findOnes(dp, n, m, mid);
            if (ones>1){
                r = mid;
            } else {
                l = mid+1;
            }
        }
        System.out.println(xb+" "+yb+" "+xt+" "+yt);
    }

    private static int findOnes(int[][] dp, int n, int m, int k) {
        int msum = Integer.MAX_VALUE;
        for (int i = 0; i <= n-k; i++) {
            for (int j = 0; j <= m-k; j++) {
                int sum = dp[i+k][j+k]-dp[i+k][j]-dp[i][j+k]+dp[i][j];
                if (sum<msum){
                    msum = sum;
                    if (msum<=1){
                        xb = i+k;
                        yb = j+1;
                        xt = i+1;
                        yt = j+k;
                    }
                }
            }
        }
        return msum;
    }

}

