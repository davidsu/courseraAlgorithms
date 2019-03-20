
import java.util.*;
import java.io.*;

public class Partition3 {
    private static boolean partition3(int[] gifts, int a, int b, int partition, int idx) {
        if(a == b && a == partition) return true;
        if(a > partition || b > partition || idx >= gifts.length) return false;
        int giftValue = gifts[idx];
        return partition3(gifts, a + giftValue, b, partition, idx + 1) ||
            partition3(gifts, a , b + giftValue, partition, idx + 1) ||
            partition3(gifts, a , b, partition, idx + 1);
    }
    public static int partition3(int[] A) {
        int sum = Arrays.stream(A).sum();
        if(sum % 3 != 0) return 0;
        return partition3(A, A[0], 0, sum / 3, 1) ? 1 : 0; 
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }
        System.out.println(partition3(A));
    }
}


