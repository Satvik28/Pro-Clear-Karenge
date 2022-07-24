package JavaSols;
import java.util.*;


public class AggressiveCows {
    static boolean isPossible(int[] stalls, int minDist, int k) {
        int cows = 1;
        int lastPosCow = stalls[0];
        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - lastPosCow >= minDist) {
                cows +=1;
                lastPosCow = stalls[i];
                if (cows>=k){
                    return true;
                }
            }
        }
        return false;
    }

    static int aggressiveCows(int[] stalls, int k, int n) {
//        int n = stalls.length;
        Arrays.sort(stalls);
        int low = 1;
        int high = stalls[n] - stalls[0];
        int res = 0;
        while (high>low) {
            int mid = (low+high)/2;
            if (isPossible(stalls, mid, k)) {
                res = mid;
                low = mid+1;
            } else {
                high= mid - 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[] stalls = new int[n];
            for (int j = 0; j < n; j++) {
                stalls[j] = scanner.nextInt();
            }
            int res = aggressiveCows(stalls, k, n);
            System.out.println("#"+i+" "+res);
        }
    }

}
