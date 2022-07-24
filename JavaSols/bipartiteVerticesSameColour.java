// import java.io.*;
package JavaSols;
import java.util.Scanner;

/**
 * bipartiteVerticesSameColour
 */
public class bipartiteVerticesSameColour {
    static int n;
    static int[][] arr = new int[100][100];

    public static boolean isBipartite(int i, int color[]) {
        boolean flag = true;
        for (int j = 0; j < n; j++) {
            if (arr[i][j] == 1) {
                if (color[j] == -1) {
                    color[j] = 1 - color[i];
                    flag = flag && isBipartite(j, color);
                } else if (color[i] == color[j]) {
                    return false;
                }
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int[] color = new int[n];
        for (int i = 0; i < n; i++) {
            color[i] = -1;
            for (int j = 0; j < n; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        scanner.close();

        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                color[i] = 0;
                if (!isBipartite(i, color)) {
                    System.out.println(-1);
                    System.exit(0);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (color[i] == 0) {
                System.out.print(i + " ");
            }
        }
    }
}
