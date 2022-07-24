package JavaSols;
import java.util.Scanner;
import java.util.Vector;

/**
 * ChessPiece
 */

/*
 * https://www.cnblogs.com/kingshow123/p/practicec2.html
 * http://www.voidcn.com/article/p-mpfarobd-bgr.html
 */

/*
 * There is a mobile piece and a stationary piece on the N×M chessboard.
 * The available moves of the mobile piece are the same as set out in the image
 * below.
 * You need to capture the stationary piece by moving the mobile piece with the
 * minimum amount of moves.
 * 
 * Write a program to find out the minimum number moves to catch a piece.
 * 
 * [Input]
 * Several test cases can be included in the inputs. T, the number of cases is
 * given in the first row of the
 * inputs. After that, the test cases as many as T (T ≤ 20) are given in a row.
 * N, the numbers of the rows and M, the number of columns of the chessboard are
 * given in the first row of
 * each test case.
 * R & C is the location information of the attacking piece and S & K is the
 * location of the defending pieces
 * and are given in the row at the second line. However, the location of the
 * uppermost end of the left end
 * is (1, 1)
 * 
 * [Output]
 * For each test case, you should print "Case #T" in the first line where T
 * means the case number.
 * 
 * For each test case, you should output the minimum number of movements to
 * catch a defending piece at the
 * first line of each test case. If not moveable, output equals ‘-1’.
 * 
 * [I/O Example]
 * 
 * Input
 * 2
 * 9 9
 * 3 5 2 8
 * 20 20
 * 2 3 7 9
 * 
 * Output
 * Case #1
 * 2
 * Case #2
 * 5
 */
public class ChessPiece {

    static class cell {
        int x, y;
        int dist;

        public cell(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    static boolean isInside(int x, int y, int n, int m) {
        return (x > 0 && x <= n) && (y > 0 && y <= m);
    }

    static int minSteps(int x_pos, int y_pos, int tx, int ty, int n, int m) {
        int[][] moveable = { { -2, 1 }, { -1, 2 }, { 1, 2 }, { 2, 1 }, { 2, -1 }, { 1, -2 }, { -1, -2 },
                { -2, -1 } };
        Vector<cell> que = new Vector<>();
        que.add(new cell(x_pos,y_pos,0));
        cell t;
        int x, y;
        boolean[][] visited = new boolean[n+1][m+1];
        visited[x_pos][y_pos] = true;
        while (!que.isEmpty()){
            t = que.firstElement();
            que.remove(0);
            if (t.x == tx && t.y == ty){
                return t.dist;
            }
            for (int i = 0; i <8; i++) {
                x = t.x + moveable[i][0];
                y = t.y + moveable[i][1];
                if (isInside(x, y, n, m) && !visited[x][y]){
                    visited[x][y] = true;
                    que.add(new cell(x, y, t.dist+1));
                }

            }
        }
        return Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
        int T;
        Scanner scanner = new Scanner(System.in);
        T = scanner.nextInt();
        for (int i = 1; i <= T; i++) {
            int n, m, r, c, s, k;
            n = scanner.nextInt();
            m = scanner.nextInt();
            r = scanner.nextInt();
            c = scanner.nextInt();
            s = scanner.nextInt();
            k = scanner.nextInt();
            int minSteps = minSteps(r,c,s,k,n,m);
            System.out.println("#"+i+" "+minSteps);
        }
        
    }
}
