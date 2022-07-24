package JavaSols;

import java.util.Scanner;

public class SpaceShip {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[][] grid = new char[n][5];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                grid[i][j] = sc.next().charAt(0);
            }
        }
        sc.close();
        int ans = helper(grid, n - 1, 2, false, -1);
        System.out.println(ans);
    }

    static int helper(char[][] arr, int row, int col, boolean bombUsed, int bombUsedIndex) {
        if (row < 0 || col < 0 || col >= 5) {
            return 0;
        }
        if (arr[row][col] == '2') {
            if (bombUsed) {
                if (row >= bombUsedIndex - 5) {
                    int up = helper(arr, row - 1, col, bombUsed, bombUsedIndex);
                    int left_up = helper(arr, row - 1, col - 1, bombUsed, bombUsedIndex);
                    int right_up = helper(arr, row - 1, col + 1, bombUsed, bombUsedIndex);
                    return Math.max(up, Math.max(left_up, right_up));
                } else {
                    return 0;
                }
            } else {
                int up = helper(arr, row - 1, col, true, row);
                int left_up = helper(arr, row - 1, col - 1, true, row);
                int right_up = helper(arr, row - 1, col + 1, true, row);
                return Math.max(up, Math.max(left_up, right_up));
            }
        }
        int up = helper(arr, row - 1, col, bombUsed, bombUsedIndex);
        int left_up = helper(arr, row - 1, col - 1, bombUsed, bombUsedIndex);
        int right_up = helper(arr, row - 1, col + 1, bombUsed, bombUsedIndex);
        return arr[row][col] == '1' ? Math.max(up, Math.max(left_up, right_up)) + 1: Math.max(up, Math.max(left_up, right_up));
    }
}