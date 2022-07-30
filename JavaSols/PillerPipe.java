package JavaSols;
import java.util.Scanner;

public class PillerPipe {

    public static int ans = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ;i<n ; i++){
            arr[i] = sc.nextInt();
        }
        boolean[] vis = new boolean[n];
        solve(arr,vis,0,0,n);
        System.out.println(ans);
        sc.close();
    }

    static void solve(int[] arr , boolean[] vis , int p1 , int p2 , int n){
        if(p1==p2){
            if(p1>ans){
                ans = p1;
            }
        }
        for(int i = 0 ; i< n ; i++){
            if(!vis[i]){
                vis[i] = true;
                solve(arr, vis, p1 + arr[i], p2, n);
                solve(arr, vis, p1, p2 + arr[i], n);
                vis[i] = false;
            }
        }
    }

}
    
