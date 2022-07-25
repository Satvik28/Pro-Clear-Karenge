package JavaSols;

import java.util.Scanner;

public class WarmHole {
    public static int ans,n,temp =0;
    public static int[][] arr = new int[35][35];
    public static int[] mask = new int[35];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ans = Integer.MAX_VALUE;
        int sx = sc.nextInt();
        int sy = sc.nextInt();
        int dx = sc.nextInt();
        int dy = sc.nextInt();
        n = sc.nextInt();
        for(int i = 0 ; i< n ; i++){
            for(int j =0 ; j<5 ; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        sc.close();
        helper(sx,sy,dx,dy,0);
        System.out.println("Answer : "+ans);
    }

    static void helper(int sx, int sy, int dx,int dy, int value){
        ans = Math.min(ans, dist(sx,sy,dx,dy)+value);
        for(int i = 0 ; i<n ; i++){
            if(mask[i]==0){
                mask[i]=1;
                temp = dist(sx,sy,arr[i][0],arr[i][1])+arr[i][4]+value;
                helper(arr[i][2], arr[i][3], dx, dy, temp);

                temp = dist(sx,sy,arr[i][2],arr[i][3])+arr[i][4]+value;
                helper(arr[i][0], arr[i][1], dx, dy, temp);

                mask[i] = 0;
            }
        }
    }
    static int dist(int sx,int sy,int dx,int dy){
        return (Math.abs(sx-dx)+Math.abs(sy-dy));
    }
    
}
