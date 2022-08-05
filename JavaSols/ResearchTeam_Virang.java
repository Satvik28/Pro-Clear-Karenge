package JavaSols;

import java.util.Scanner;


public class ResearchTeam_Virang {
    static int n, sol;
    static int[][] arr, visited, location;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int test_case = 1; test_case <= t; test_case++) {
            n = scanner.nextInt();
            arr = new int[n][n];
            visited = new int[n][n];
            int m = scanner.nextInt();
            location = new int[m][2];
            for (int i = 0; i < m; i++) {
                location[i][0] = scanner.nextInt();
                location[i][1] = scanner.nextInt();
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = scanner.nextInt();
                }
            }
            int longest = 0, flag = 0, long_index = 0;
            int sol = Integer.MAX_VALUE;
            int[] maxdist = new int[n * n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[i][j] == 1) {
                        for (int k = 0; k < m; k++) {
                            if (research(location[k][0], location[k][1], i, j, 0)) {
                                if (longest < sol) {
                                    longest = sol;
                                }
                                sol = Integer.MAX_VALUE;
                            } else {
                                flag = 1;
                                break;
                            }
                            for(int a=0;a<n;a++) {
                                for(int b=0;b<n;b++) {
                                    visited[a][b]=0;
                                }
                            }
                        }
                        if (flag == 0) {
                            maxdist[long_index] = longest;
                            long_index++;
                        } else {
                            flag = 0;
                        }
                        longest = 0;
                    }
                }

            }
            int j = 0;
            for (int i = 0; i < long_index; i++) {
                if (maxdist[i] < maxdist[j]) {
                    j = i;
                }
            }
            System.out.println("#" + test_case + " " + maxdist[j]);
        }
        scanner.close();

    }

    static boolean research(int x, int y, int x1, int y1, int count) {
        if (x==x1 && y == y1){
            visited[x][y] = 1;
            if (sol<count) {
                sol = count;
            }
            return true;
        }
        if (isSafe(x, y)) {
            visited[x][y] = 1;
            if (research(x, y - 1, x1, y1, count + 1) || research(x, y + 1, x1, y1, count + 1) || research(x - 1, y, x1, y1, count + 1) || research(x + 1, y, x1, y1, count + 1)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isSafe(int x, int y) {
        return (x>=0 && x<n) && (y>=0 && y<n) && (arr[x][y] == 1 && visited[x][y] == 0);
    }
}



