package JavaSols;

import java.util.Arrays;
import java.util.Scanner;

public class JewelMaze {
    static int ans, n;
    static int[] dirX = {1,0,-1,0};
    static int[] dirY = {0,1,0,-1};
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 1; i <= t; i++) {
            n = scanner.nextInt();
            int[][] maze = new int[n+1][n+1];
            int[][] visited = new int[n+1][n+1];
            int[][] path = new int[n+1][n+1];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    maze[j][k] = scanner.nextInt();
                }
            }
            ans = Integer.MIN_VALUE;
            int sx = 0, sy = 0;
            visited[sx][sy] = 1;
            if (maze[sx][sy] == 2) {
                jewelMaze(maze, sx, sy, 1, visited, path);
            } else {
                jewelMaze(maze, sx, sy, 0, visited, path);
            }
            System.out.println("Jewel Collected " +" #"+i + " " + ans);
            System.out.println("Path Traversed: ");
            System.out.println(Arrays.deepToString(path));
        }
        scanner.close();
    }

    static void jewelMaze(int[][] maze, int x, int y, int value, int[][] visited, int[][] path) {
        if (x == n-1 && y == n-1) {
            if (value >= ans) {
                ans = value;
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (visited[i][j] != 0) {
                            path[i][j] = 3;
                        } else {
                            path[i][j] = maze[i][j];
                        }
                    }
                }
            }

        }
        for (int i = 0; i < 4; i++) {
            int new_x = x + dirX[i];
            int new_y = y + dirY[i];
            if (isValid(new_x, new_y)){
                if (visited[new_x][new_y] == 0 && maze[new_x][new_y] == 0) {
                    visited[new_x][new_y] = 1;
                    jewelMaze(maze, new_x, new_y, value, visited, path);
                    visited[new_x][new_y] = 0;
                }

                if (visited[new_x][new_y] == 0 && maze[new_x][new_y] == 2) {
                    visited[new_x][new_y] = 1;
                    jewelMaze(maze, new_x, new_y, value+1, visited, path);
                    visited[new_x][new_y] = 0;
                }
            }
        }

    }

    static boolean isValid(int new_x, int new_y) {
        return (new_x>=0 && new_x<n) && (new_y>=0&&new_y<n);
    }
}
