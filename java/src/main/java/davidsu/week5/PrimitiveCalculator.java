import java.util.*;
import java.util.stream.IntStream;

public class PrimitiveCalculator {
    static class Point{
        int index, prev, hops;
        public Point(int x, int y, int z){
            index = x;
            prev = y;
            hops = z;
        }
        public static Point shortest(Point p1, Point p2, Point p3) {
            return p1.smallest(p2).smallest(p3);
        }
        public Point smallest(Point other) {
            return this.hops < other.hops ? this : other;
        }
    }
    public static List<Integer> optimal_sequence(int n) {
        Point[] list = new Point[n+1];
        list[0] = new Point(0,0, 0);
        final Point dummy = new Point(0, 0, Integer.MAX_VALUE);
        Point p1, p2, p3;
        for(int i = 1; i <=n; i++){
            p1 = p2 = p3 = dummy;
            if (i % 3 == 0) p3 = list[i/3]; 
            if (i % 2 == 0) p2 = list[i/2];
            p1 = list[i-1];
            Point p = Point.shortest(p1, p2, p3);
            list[i] = new Point(i, p.index, p.hops + 1);
        };
        LinkedList<Integer> result = new LinkedList<Integer>();
        Point cur = list[n];
        while(cur.hops != 0) {
            result.addFirst(cur.index);
            cur = list[cur.prev];
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> sequence = optimal_sequence(n);
        System.out.println(sequence.size() - 1);
        for (Integer x : sequence) {
            System.out.print(x + " ");
        }
    }
}

