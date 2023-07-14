package budget;

import java.util.ArrayList;
import java.util.Scanner;

public class Budget {
    private double balance;
    private final ArrayList<Purchase> purchases = new ArrayList<>();

    public Budget() {
    }
    public void addIncome(double income) {
        balance += income;
        System.out.println("Income was added\n");
    }

    public double getBalance() {
        return balance;
    }
    public void addPurchase(Scanner sc) {
        System.out.println("Enter purchase name");
        String name = sc.nextLine();
        System.out.println("Enter its price:");
        double price = Double.parseDouble(sc.nextLine());
        purchases.add(new Purchase(name, price));
        balance -= price;
        System.out.println("Purchase was added!\n");
    }
    public void showPurchases() {
        if (purchases.size() == 0) {
            System.out.println("The purchase list is empty\n");
        } else {
            double sum = purchases.stream().mapToDouble(Purchase::getPrice).sum();
            purchases.forEach(System.out::println);
            System.out.printf("Total sum: $%.2f\n\n", sum);
        }
    }
}
