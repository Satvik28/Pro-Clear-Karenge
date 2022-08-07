package JavaSols;

import java.util.Scanner;

public class DoctorProbability {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float[][] pm = new float[100][100];
        float[][] rm = new float[100][100];
        int nodes = scanner.nextInt();
        int e = scanner.nextInt();
        int t = scanner.nextInt();
        int x, y;
        for (int i = 0; i < e; i++) {
            x = scanner.nextInt();
            y = scanner.nextInt();
            pm[x-1][y-1] = scanner.nextFloat();
        }
        rm[0][0]=1;
        for (int i = 0; i < t / 10; i++) { //time intervals
            for (int j = 0; j < nodes; j++) { //nodes of the graph
                if (rm[i][j]>0)
                    for (int k = 0; k < nodes; k++)
                        rm[i + 1][k] += rm[i][j] * pm[j][k];
            }
        }
        float ans = 0;
        int res = -1;
        for (int i = 0; i < nodes; i++) {
            if (rm[t/10][i] >ans) {
                ans = rm[t/10][i];
                res = i;
            }
        }
        System.out.println((res+1));

    }
}

/*
6 10 40
1 2 0.3 1 3 0.7 3 3 0.2 3 4 0.8 2 4 1 4 5 0.9 4 4 0.1 5 6 1 6 3 0.5 6 6 0.5
*/


