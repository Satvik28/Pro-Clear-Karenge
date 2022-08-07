package JavaSols;

import java.util.Arrays;
import java.util.Scanner;

public class Fishermen {
    static int n, ans;
    static boolean[] visited = new boolean[100];

    static class gate{
        int loc, men;
        gate(int loc, int men) {
            this.loc = loc;
            this.men = men;
        }
    }

    static gate[] gates = new gate[4];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int tc = 0; tc < t; tc++) {
            n = scanner.nextInt();
//            System.out.println(Arrays.toString(gates));
            for (int i = 1; i <= 3; i++) {
                int loc = scanner.nextInt();
                int men = scanner.nextInt();
                gates[i] = new gate(loc, men);
            }
//            System.out.println(Arrays.toString(gates));
            ans = Integer.MAX_VALUE;
            solve(1,2,3,0,1);
            solve(1,3,2,0,1);
            solve(2,1,3,0,2);
            solve(2,3,1,0,2);
            solve(3,1,2,0,3);
            solve(3,2,1,0,3);

            System.out.printf("#%d %d%n",tc+1,ans);
        }
        scanner.close();
    }

    static void solve(int x, int y, int z, int distance, int curr_gate) {
        if (distance>ans) return;
        if (gates[curr_gate].men == 0) {
            if (curr_gate == x) curr_gate = y;
            else if (curr_gate == y) curr_gate =z;
            else {
                ans = Math.min(ans, distance);
                return;
            }
        }
        int l = findLeft(gates[curr_gate].loc);
        int costL = Math.abs(gates[curr_gate].loc - l)+1;
        int r = findRight(gates[curr_gate].loc);
        int costR = Math.abs(gates[curr_gate].loc - r)+1;

        boolean goLeft = true, goRight = true;
        if (costL>costR) goLeft = false;
        if (costL<costR) goRight = false;

        if (goLeft) {
            visited[l] = true;
            gates[curr_gate].men--;
            solve(x, y, z, distance+costL, curr_gate);
            visited[l] = false;
            gates[curr_gate].men++;
        }

        if (goRight) {
            visited[r] = true;
            gates[curr_gate].men--;
            solve(x, y, z, distance+costR, curr_gate);
            visited[r] = false;
            gates[curr_gate].men++;
        }


    }

    static int findLeft(int loc) {
        for (int i = loc; i > 0; i--){
            if (!visited[i]) {
                return i;
            }
        }
        return Integer.MAX_VALUE;
    }

    static int findRight(int loc) {
        for (int i = loc+1; i <=n; i++){
            if (!visited[i]) {
                return i;
            }
        }
        return Integer.MAX_VALUE;
    }

}
