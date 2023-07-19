package budget.sorting;

import budget.Purchase;

import java.util.ArrayList;
import java.util.HashMap;

public class SortByType implements SortingMethod {
    @Override
    public void sort(HashMap<Integer, ArrayList<Purchase>> purchases) {
        System.out.println("Types");
        double totalSum = 0;
        totalSum += sumCategory(1, purchases);
        totalSum += sumCategory(3, purchases);
        totalSum += sumCategory(2, purchases);
        totalSum += sumCategory(4, purchases);
        System.out.printf("Total sum: $%.2f\n", totalSum);
    }

    private String returnType(int i) {
        switch (i) {
            case 1 -> {
                return "Food";
            }
            case 2 -> {
                return "Clothes";
            }
            case 3 -> {
                return "Entertainment";
            }
            case 4 -> {
                return "Other";
            }
            default -> {
                return null;
            }
        }
    }

    private double sumCategory(int i, HashMap<Integer, ArrayList<Purchase>> purchases) {
        double sum = purchases.getOrDefault(i, new ArrayList<>()).stream().mapToDouble(Purchase::getPrice).sum();
        System.out.printf("%s - $%.2f\n", returnType(i), sum);
        return sum;
    }
}
