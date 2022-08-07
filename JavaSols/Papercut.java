package JavaSols;


import java.util.Scanner;

public class Papercut {

    public static int blue = 0;
    public static int white = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[][] arr = new boolean[129][129];
        for(int i = 0 ; i< n  ; i++){
            for(int j = 0 ;j<n ; j++){
                int a = sc.nextInt();
                if(a==1) arr[i][j] = true;
                else arr[i][j] = false;
            }
        }
        sc.close();
        solve(arr,n,0,0);
        System.out.println("Blue : "+ blue + " White : " + white);
    }
    static void solve(boolean[][] arr ,int size, int sti, int stj){
        boolean same = checkSame(arr,size,sti,stj);
        if(!same){
            solve(arr, size/2, sti, stj);
            solve(arr, size/2, sti + size/2, stj);
            solve(arr, size/2, sti, stj + size/2);
            solve(arr, size/2, sti + size/2, stj + size/2);
        }else{
            if(arr[sti][stj]) ++blue;
            else ++white;
        }
    }
    static boolean checkSame(boolean[][] arr, int size , int sti, int stj){
        boolean color = arr[sti][stj];
        for(int i = sti ; i<sti+size ; i++){
            for(int j = stj ; j<stj+size ; j++){
                if(arr[i][j]!=color){
                    return false;
                }
            }
        }
        return true;
    } 
}
