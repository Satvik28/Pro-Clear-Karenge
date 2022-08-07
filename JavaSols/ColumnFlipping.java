package JavaSols;

import java.util.Scanner;

public class ColumnFlipping {
    static int n, m, ans = -1;
    static int[][] matrix;
    static int[] vis_col;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int test_case = 1; test_case <= t; test_case++) {
            n = scanner.nextInt();
            m = scanner.nextInt();
            int k = scanner.nextInt();
            matrix = new int[n][m];
            vis_col = new int[m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            solve(k,0);
            System.out.println("#"+test_case+" "+ans);
        }
    }

    static void solve(int k, int j) {
        if (j>=m)
            return;
        if (k==0){
            int max =0;
            for (int i = 0; i < n; i++) {
                int sum = 0;
                for (int l = 0; l < m; l++) {
                    sum += matrix[i][l];
                }
                if (sum>max){
                    max = sum;
                }
            }
            ans = Math.max(ans, max);
            return;
        }
        invert(j);
        solve(k-1, j);
        invert(j);
        solve(k, j+1);

    }

    static void invert(int j) {
        for (int i = 0; i < n; i++) {
            matrix[i][j] = 1-matrix[i][j];
        }
    }
}


