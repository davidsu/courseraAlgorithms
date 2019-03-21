import java.util.Scanner;
import java.util.ArrayList;

public class FractionalKnapsack {
    private static class Item {
        private int value;
        private int weight;
        public double getUnitValue() { return this.value / (this.weight * 1.0); }
        public double getWeight() { return this.weight; }
        public Item(int value, int weight) {
            this.value = value;
            this.weight = weight;
        }
        public String toString() { return "value: " + value + ", weight: " + weight + ", unitValue: " + this.getUnitValue();}
    }

    public static ArrayList<Item> factory(int[] values, int[] weight) {
        ArrayList<Item> ar = new ArrayList<>(values.length);
        for(int i = 0; i < values.length; i++) {
            ar.add(new Item(values[i], weight[i]));
        }
        return ar;

    }


    public static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0;
        ArrayList<Item> items = factory(values, weights);//
        items.sort((a,b) -> a.getUnitValue() < b.getUnitValue() ? 1 : -1);
        for(Item t : items) {
            if(capacity > 0) {
                value += capacity > t.getWeight() ? t.getWeight() * t.getUnitValue() : capacity * t.getUnitValue();
                capacity -= t.getWeight();
            }
        }
        return value;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }
} 
