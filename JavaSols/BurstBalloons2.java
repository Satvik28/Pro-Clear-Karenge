package JavaSols;

// There are n balloons and n bullets and each balloon is assigned with a particular number (point).
// Whenever a particular balloon is shot the no of points increases by
// 1.the multiplication of point assigned to balloon on left and that of right side.
// 2.point assigned to left if no right exists
// 3.point assigned to right if no left exists.
// 4.the point assigned to itself if no other balloon exists.

// You have to output the maximum no of points possible.

// Input
// 1 2 3 4

// Output
// 20

import java.util.*;

public class BurstBalloons2 {

    static int maxPoints(int[] arr, int i, int j) {
        // int n = arr.length;
        if (i > j) {
            return 0;
        }
        int maximum = Integer.MIN_VALUE;
        for (int k = i; k <= j; k++) {
            // consider that arr[k] is the last baloon to be burst
            // int cost = (arr[i - 1] * arr[j + 1]) + maxPoints(arr, i, k - 1) +
            // maxPoints(arr, k + 1, j);
            int cost = (arr[i - 1] * arr[k] * arr[j + 1]) + maxPoints(arr, i, k - 1) +
                    maxPoints(arr, k + 1, j);
            maximum = Math.max(maximum, cost);
        }
        return maximum;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int arr[] = new int[n + 2];
        arr[0] = 1;
        arr[n + 1] = 1;
        for (int i = 1; i < n + 1; i++) {
            arr[i] = scan.nextInt();
        }
        for (int i : arr) {
            System.out.println(i);
        }
        // System.out.println();
        scan.close();
        int points = maxPoints(arr, 1, n);
        System.out.println(points);
    }
}
