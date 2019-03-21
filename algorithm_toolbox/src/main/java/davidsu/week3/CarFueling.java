import java.util.*;
import java.io.*;

public class CarFueling {
    static class Stop{
        public int distanceFromLast;
        public int distance;
        public boolean refuelable;
        public Stop(Stop last, int distance, boolean refuelable) {
            this.distance = distance;
            this.distanceFromLast = distance - (last == null? 0 : last.distance);
            this.refuelable = refuelable;

        }
    }

    public static int computeMinRefills(int dist, int tank, int[] _stops) {
        LinkedList<Stop> stops = new LinkedList<Stop>();
        Stop curr = null;
        for(int i = 0; i < _stops.length && _stops[i] < dist; i++) {
            curr = new Stop(curr, _stops[i], true);
            stops.add(curr);
        }
        stops.add(new Stop(curr, dist, false));
        int fuel = tank;
        int retVal = 0;
        while(!stops.isEmpty()) {//I can refuel here
            curr = stops.remove();
            fuel -= curr.distanceFromLast;
            dist -= curr.distanceFromLast;
            int fuelTillNext = fuel - (stops.isEmpty() ? 0 : stops.peek().distanceFromLast);
            if(fuel < 0) return -1;
            if(fuelTillNext < 0 && curr.refuelable) {//I must refuel here
                fuel = tank;
                retVal++;
            }
        }

        return retVal;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dist = scanner.nextInt();
        int tank = scanner.nextInt();
        int n = scanner.nextInt();
        int[] stops = new int[n];
        for (int i = 0; i < n; i++) {
            stops[i] = scanner.nextInt();
        }

        System.out.println(computeMinRefills(dist, tank, stops));
    }
}
