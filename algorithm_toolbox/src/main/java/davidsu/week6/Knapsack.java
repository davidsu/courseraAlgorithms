import java.util.*;

public class Knapsack {
    static int _Weight;
    static int[] _itemsWeights;
    static int[][] calcTable;
    static int valueForItem(int item, int weight) {
        if(item<0 || weight < 0) return 0;
        return calcTable[item][weight];
    }
    static void calcForItem(int item, int weight) {
        int maxWeight = 0;
        for(int currWeight = 0; currWeight <= _Weight; currWeight++) {
            calcTable[item][currWeight] = Math.max(
                        valueForItem(item-1, currWeight),
                        valueForItem(item-1, currWeight - weight) + (weight <= currWeight ? weight : 0)
                    );
        }
    }
    static void init(int Weight, int[] itemsWeights) {
        calcTable = new int[itemsWeights.length][Weight+1];
        _Weight = Weight;
        _itemsWeights = itemsWeights;
    }
    static int optimalWeight(int Weight, int[] itemsWeights) {
        Arrays.sort(itemsWeights);
        init(Weight, itemsWeights);
        int item = 0;
        for(int itemWeight: itemsWeights){
            calcForItem(item, itemWeight);
            item++;
        }
        // for(int i = 0; i< itemsWeights.length; i++) System.out.println(Arrays.toString(calcTable[i]));
        return valueForItem(itemsWeights.length-1, Weight);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        System.out.println(optimalWeight(W, w));
    }
}

