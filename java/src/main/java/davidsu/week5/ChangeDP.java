import java.util.Scanner;
import java.util.stream.*;

public class ChangeDP {
    public static int getChange(int[] dynamic, int m, int coin) {
        return m-coin >=0 ? dynamic[m-coin] + 1 : Integer.MAX_VALUE;
    }
    public static int getChange(int m) {
        int[] coins = {1,3,4};
        int[] dynamic = new int[m+1];
        dynamic[0] = 0;
        IntStream.range(1, m+1).forEach(i -> {
            int min = Integer.MAX_VALUE;
            for(int c: coins) {
                int cur = getChange(dynamic, i, c);
                if(cur < min) {
                    min = cur;
                }
            }
            dynamic[i] = min;
            // IntStream.range(0, i+1).forEach(q -> System.out.print(dynamic[q] + " "));
            // System.out.println();

        });
        return dynamic[m];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

