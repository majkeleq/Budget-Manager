package budget.sorting;

import budget.Budget;

import java.util.Scanner;

public class PurchaseSorter {
    private SortingMethod sortingMethod;

    public PurchaseSorter() {
    }

    private void setSortingMethod(SortingMethod sortingMethod) {
        this.sortingMethod = sortingMethod;
    }

    public void run(Budget budget, Scanner sc) {
        boolean toContinue = true;
        while (toContinue) {
            System.out.print("""
                    How do you want to sort?
                    1) Sort all purchases
                    2) Sort by type
                    3) Sort certain type
                    4) Back
                    """);
            String input = sc.nextLine();
            switch (input) {
                case "1", "2", "3" -> {
                    System.out.println();
                    setSortingMethod(returnSortingMethod(input));
                    sortingMethod.sort(budget.getPurchases());
                    System.out.println();
                }
                case "4" -> {
                    toContinue = false;
                    System.out.println();
                }
            }

        }
    }

    private SortingMethod returnSortingMethod(String input) {
        switch (input) {
            case "1" -> {
                return new SortAll();
            }
            case "2" -> {
                return new SortByType();
            }
            case "3" -> {
                return new SortCertainType();
            }
            default -> {
                return null;
            }
        }
    }
}
