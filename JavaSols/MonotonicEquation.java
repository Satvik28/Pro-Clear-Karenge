package JavaSols;

import java.util.Scanner;

public class MonotonicEquation {
    //f(n) = an + bn[log2n(n)]+cn^3
    /*
     * given a, b, c and f(n)
     * */

    static long u_limit = 1000000L;
    static long l_limit = 1000000000000000L;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long a = scanner.nextLong();
        long b = scanner.nextLong();
        long c = scanner.nextLong();
        long k = scanner.nextLong();
        long ans = solve(a,b,c,k);
        System.out.println(ans);
    }

    static long equation(long a, long b, long c, long n){
        return (long) (a*n + b*n*Math.floor(Math.log(n)/Math.log(2)) + c*Math.pow(n, 3));
    }

    static long solve(long a, long b, long c, long k) {
        long start = 1, end = l_limit;
        if (c==0){
            end = u_limit;
        }
        long ans = 0;
        while (start<=end){
            long mid = (start+end)/2;
            long val = equation(a, b, c, mid);
            if (val == k) {
                ans = mid;
                break;
            } else if (val>k) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return ans;
    }

}

