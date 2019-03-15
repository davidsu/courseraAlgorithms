import java.util.*;
import java.util.stream.*;

public class Inversions {
    static class Merged{
        public long inversions = 0;
        public Queue<Integer> list;
        public Merged(Collection<Integer> list, long inversions) {
            this.list = new ArrayDeque(list);
            this.inversions = inversions;
        }
        public Merged(Queue<Integer> list, long inversions) {
            this.list = list;
            this.inversions = inversions;
        }
        public String toString() { return list + " **"+inversions+"**";}

    }
    public static Merged merge(Merged m1, Merged m2) {
        long inversions = m1.inversions + m2.inversions;
        Queue<Integer> res = new ArrayDeque<Integer>();
        // System.out.println(m1);
        // System.out.println(m2);
        // System.out.println(inversions);
        // System.out.println("##############################################################");
        while(!m1.list.isEmpty() && !m2.list.isEmpty()) {
            if(m1.list.peek() <= m2.list.peek()) {
                res.add(m1.list.remove());
            // } else if(m2.list.get(0) == m1.list.get(0)){
            //     res.add(m2.list.remove());
            } else {
                res.add(m2.list.remove());
                inversions+=m1.list.size();
            }
        }
        if(!m1.list.isEmpty()) {
            res.addAll(m1.list);
        }
        if(!m2.list.isEmpty()) {
            res.addAll(m2.list);
        }
        return new Merged(res, inversions);
    }
    public static Merged mergeSort(List<Integer> a) {
        // System.out.println("##############################################################");
        // System.out.println(a);
        // System.out.println("##############################################################");
        if(a.size() <=1 ) return new Merged(a, 0);
        int avg = a.size()/2;
        Merged m1 = mergeSort(a.subList(0, avg));
        Merged m2 = mergeSort(a.subList(avg, a.size()));
        return merge(m1, m2);
    }

    public static long getNumberOfInversions(int[] a, int[] b, int left, int right) {
        List<Integer> list = IntStream.of(a).boxed().collect(Collectors.toList());
        Merged m = mergeSort(list);
        // return 0;
        // System.out.println(m);
        return m.inversions;

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] b = new int[n];
        System.out.println(getNumberOfInversions(a, b, 0, a.length));
    }
}


