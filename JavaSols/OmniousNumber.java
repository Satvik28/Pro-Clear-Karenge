package JavaSols;

import java.util.Scanner;

public class OmniousNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int end = sc.nextInt();
        int k = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i<n ; i++){
            arr[i] = sc.nextInt();
        }
        sc.close();
        System.out.println(omniousNumber(start,end,k,arr,n));
    }

    static int omniousNumber(int start, int end, int k, int[] arr , int n){
        int count = 0;
        for(int i = start ; i<=end ; i++){
            int temp = i;
            int[] digitArray = new int[10];
            while(temp!=0){
                digitArray[temp%10]++;
                temp = temp/10;
            }
            int rougeK = 0;
            for(int j = 0 ; j<n ; j++){
                rougeK = rougeK + digitArray[arr[j]];
            }
            if(rougeK<k){
                count++;
            }
        }
        return count;
    }
}
