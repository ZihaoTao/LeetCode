import java.util.HashMap;
import java.util.Map;

public class maxPoints {
    public int maxPoints(Point[] points) {
        if(points.length <= 1) return points.length;

        int res = 1;
        for(Point i : points) {
            int samePoints = 0;
            Map<String, Integer> map = new HashMap<>();
            for(Point j : points) {
                if(i.x == j.x && i.y == j.y) {
                    samePoints++;
                } else {
                    String s = getSlope(i, j);
                    if(!map.containsKey(s)) {
                        map.put(s, 1);
                    } else {
                        map.put(s, map.get(s) + 1);
                    }
                }
            }
            res = Math.max(res, samePoints);
            for(String str : map.keySet()) {
                res = Math.max(res, map.get(str) + samePoints);
            }
        }

        return res;
    }

    private String getSlope(Point i, Point j) {
        int dx = i.x - j.x;
        int dy = i.y - j.y;
        if(dx == 0) return "0/1";
        if(dy == 0) return "1/0";
        int gcd = gcd(Math.abs(dx), Math.abs(dy));
        dx /= gcd;
        dy /= gcd;
        if(dx < 0) {
            dx = -dx;
            dy = -dy;
        }
        return dx + "/" + dy;
    }

    private int gcd( int a , int b ){

        if( a < b )
            return gcd(b, a);

        if( a % b == 0 )
            return b;

        return gcd( b , a%b );
    }

    public static void main(String[] args) {
        //[[84,250],[0,0],[1,0],[0,-70],[0,-70],[1,-1],[21,10],[42,90],[-42,-230]]
        Point[] p = new Point[9];
        p[0] = new Point(84,250);
        p[1] = new Point(0, 0);
        p[2] = new Point(1, 0);
        p[3] = new Point(0,-70);
        p[4] = new Point(0,-70);
        p[5] = new Point(1,-1);
        p[6] = new Point(21,10);
        p[7] = new Point(42,90);
        p[8] = new Point(-42,-230);

        System.out.println((new maxPoints()).maxPoints(p));
    }
}
