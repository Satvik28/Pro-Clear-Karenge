import java.util.*;

class node{
    int curr,prev;
    node(int curr , int prev){
        this.curr = curr;
        this.prev = prev;
    }
}

public class IsCycle {
    public static boolean ans = false;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n  = sc.nextInt();
        int[][] arr  = new int[n+1][n+1];
        for(int i = 1 ; i<n+1 ; i++){
            for(int j = 1 ; j<n+1 ; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        sc.close();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < n + 1; i++) {
            adj.add(new ArrayList<Integer>());
            for (int j = 0; j < n + 1; j++) {
                if (arr[i][j] == 1) {
                    adj.get(i).add(j);
                }
            }
        }
        System.out.println(adj);
        bfs(adj,n);
        System.out.println("Is Cycle : " + ans);
    }

    static void bfs( ArrayList<ArrayList<Integer>> adj,int n){
        boolean[] vis = new boolean[n+1];
        for(int i = 1 ; i<n+1; i++){
            Queue<node> q = new LinkedList<node>();
            q.add(new node(i, -1));
            vis[i]= true;
            while(!q.isEmpty()){
                int curr = q.peek().curr;
                int prev = q.peek().prev;
                q.remove();
                for(Integer it : adj.get(curr)){
                    if(!vis[it]){
                        vis[it] = true;
                        q.add(new node(it, curr));
                    }
                    else if (prev!=it) ans = true;
                }
            }
        }
    }
}
