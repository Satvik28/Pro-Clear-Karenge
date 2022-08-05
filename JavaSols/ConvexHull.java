package JavaSols;


import java.util.Scanner;
import java.util.Vector;

class Point{
    int x, y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class ConvexHull {
    public static int orientation(Point p, Point q, Point r) {
        int val = (q.y - p.y)*(r.x-q.x) - (q.x - p.x)*(r.y - q.y);
        if (val == 0) return 0;
        else if (val>0) return 1;
        else return 2;
    }
    public static void convexHull(Point[] points, int n) {
        if (n<3) return;
        Vector<Point> hull = new Vector<>();
        int l = 0; //first point
        for (int i = 0; i < n; i++)
            if (points[i].x < points[l].x)
                l = i;
        int p = l, q;
        do {
            hull.add(points[p]);
            q = (p+1)%n;
            for (int i = 0; i < n; i++)
                if (orientation(points[p], points[i], points[q]) == 2) q = i;
            p = q;
        } while (p!= l);

        for (Point temp : hull)
            System.out.println("(" + temp.x + ", " + temp.y + ")");

    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            points[i] = new Point(x, y);
        }
        convexHull(points, n);
    }
}
