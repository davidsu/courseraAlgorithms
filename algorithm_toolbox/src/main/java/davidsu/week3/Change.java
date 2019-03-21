import java.util.Scanner;

public class Change {
    public static int getChange(int m) {
        int res = 0;
        for(int coin: new int[]{10,5,1}){
            while(m-coin >= 0) {
                m -= coin;
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

