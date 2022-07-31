package JavaSols;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class data{
    int x,y,level;
    data(int x, int y ,int level){
        this.x = x;
        this.y = y;
        this.level = level;
    }
}

public class LaughingGas {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n+1][m+1];
        for(int i = 1; i<=n ; i++){
            for(int j = 1 ; j<=m ; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        int r = sc.nextInt();
        int c = sc.nextInt();
        sc.close();
        int[][] moveable = {{1,0},{0,1},{-1,0},{0,-1}};
        Queue<data> q = new LinkedList<>();
        int tmx,tmy,tml=0;
        data d = new data(r, c, 0);
        q.add(d);
        arr[r][c] = 2;
        while(!q.isEmpty()){
            int x = q.peek().x;
            int y = q.peek().y;
            int level = q.peek().level;
            q.remove();
            for(int i = 0 ; i<4 ; i++){
                tmx = x + moveable[i][0];
                tmy = y + moveable[i][1];
                tml = level + 1;
                if(tmx<=n && tmy<=m && tmx>0 && tmy>0){
                    if(arr[tmx][tmy]==1){
                    arr[tmx][tmy]=2;
                    q.add(new data(tmx, tmy, tml));
                }
            }
            }
        }
        System.out.println(tml);
    }
    
}
