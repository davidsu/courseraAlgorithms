import java.util.*;
import java.util.stream.*;

public class LargestNumber {
    public static String largestNumber(String[] arr) {
        return String.join(
                "",
                Stream.of(arr)
                    .sorted((a,b) -> (b+a).compareTo(a+b))
                    .toArray(size -> new String[size])
                );

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next();
        }
        System.out.println(largestNumber(a));
    }
}

