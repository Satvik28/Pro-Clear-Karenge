package JavaSols;
import java.util.*;

class point{
    int x,y;
    point(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class FrogJump {
    static int[] y = {1,0,-1,0};
    static int[] x = {0,1,0,-1};
    static Queue<point> q = new LinkedList<point>();
    static int[][] arr = new int[105][105];
    static int[][] vis = new int[105][105];
    static int[][] dis = new int[105][105];
    static int n,sx,sy,tx,ty;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                arr[i][j] = sc.nextInt();
                vis[i][j] = 0;
                dis[i][j] = 0;
            }
        }
        sx = sc.nextInt();
        sy = sc.nextInt();
        tx = sc.nextInt();
        ty = sc.nextInt();
        sc.close();
        helper();
    }
    static boolean isValid(int i, int j){
        return (i>=0 && i<n && j>=0 && j<n);
    }

    static void helper(){
        q.add(new point(sx, sy));
        vis[sx][sy] = 1;
        dis[sx][sy] = 0;
        while(!q.isEmpty()){
            int a = q.peek().x;
            int b = q.peek().y;
            q.remove();
            for(int i = 0 ; i<4 ; i++){
                int newx = a + x[i];
                int newy = b + y[i];
                if(isValid(newx,newy) && arr[newx][newy] == 1 && vis[newx][newy] == 0 ){
                    if(i==0 || i==2){
                        dis[newx][newy] = dis[a][b] ;
                    }else if(i==1 || i==3){
                        dis[newx][newy] = dis[a][b] + 1  ;
                    }
                    vis[newx][newy] = 1;	
                    q.add(new point(newx, newy));
                }
            }
        }
        System.out.println(dis[tx][ty]);
    }
    
}
