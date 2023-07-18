package budget.sorting;

import budget.Purchase;

import java.util.ArrayList;
import java.util.HashMap;

public class SortByType implements SortingMethod {
    @Override
    public void sort(HashMap<Integer, ArrayList<Purchase>> purchases) {
        System.out.println("Types");
        double totalSum = 0;
        for (int i = 1; i <= 4; i++) {
            double sum = purchases.getOrDefault(i, new ArrayList<>()).stream().mapToDouble(Purchase::getPrice).sum();
            totalSum += sum;
            System.out.printf("%s - $%.2f\n", returnType(i), sum);
        }
        System.out.printf("Total sum: $%.2f\n", totalSum);
    }

    private String returnType(int i) {
        switch (i) {
            case 1 -> {
                return "Food";
            }
            case 2 -> {
                return "Entertainment";
            }
            case 3 -> {
                return "Clothes";
            }
            case 4 -> {
                return "Other";
            }
            default -> {
                return null;
            }
        }
    }
}
