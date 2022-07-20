import java.util.Scanner;

public class MrLee {
    public static int n ;
    public static int ans;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[][] arr = new int[n][n];
        for(int i = 0 ; i<n ; i++){
            for(int j = 0 ; j<n ; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        sc.close();
        boolean[] vis = new boolean[n];
        ans = Integer.MAX_VALUE;
        vis[0] = true;
        helper(arr,vis,0,0,0);
        if(ans!=Integer.MAX_VALUE){
        System.out.println(ans);
        }else{
            System.out.println(-1);
        }
    }

    static void helper(int[][] arr, boolean[] vis , int count , int cost , int src){
        if(count==n-1){
            if(arr[src][0]!=0){
                ans = Math.min(ans,cost+arr[src][0]);
            }
            return;
        }
        for(int i =0 ; i<n ; i++){
            if(!vis[i] && arr[src][i]!=0){
                vis[i] = true;
                helper(arr, vis, count+1, cost + arr[src][i], i);
                vis[i] = false;
            }
        }
    }
    
}
