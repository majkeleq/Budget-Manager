package budget.sorting;

import budget.Purchase;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;


public class SortCertainType implements SortingMethod {
    @Override
    public void sort(HashMap<Integer, ArrayList<Purchase>> purchases) {
        Scanner sc = new Scanner(System.in);
        System.out.print("""
                Choose the type of purchase
                1) Food
                2) Clothes
                3) Entertainment
                4) Other
                """);
        ArrayList<Purchase> category = purchases.getOrDefault(Integer.valueOf(sc.nextLine()), new ArrayList<>());
        System.out.println();
        if (category.isEmpty()) {
            System.out.println("The purchase list is empty!");
        } else {
            category.stream()
                    .sorted(Comparator.comparingDouble(Purchase::getPrice).reversed())
                    .forEach(System.out::println);
        }
    }
}
