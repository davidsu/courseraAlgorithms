import java.util.*;

public class DifferentSummands {

    public static List<Integer> optimalSummands(int n) {
        var summands = new ArrayList<Integer>();
        var i = 0;
        while(n > 0) {
            i++;
            if(2*i+1 <= n) {
                summands.add(i);
                n-=i;
            } else {
                summands.add(n);
                n=0;
            }
        }
        return summands;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> summands = optimalSummands(n);
        System.out.println(summands.size());
        for (Integer summand : summands) {
            System.out.print(summand + " ");
        }
    }
}

