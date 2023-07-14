package budget;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Budget {
    private double balance;
    //private final ArrayList<Purchase> purchases = new ArrayList<>();
    private final HashMap<Integer, ArrayList<Purchase>> purchases = new HashMap<>();

    public Budget() {
    }

    public void addIncome(double income) {
        balance += income;
        System.out.println("Income was added\n");
    }

    public double getBalance() {
        return balance;
    }

    public void addPurchase(String input, Scanner sc) {
        ArrayList<Purchase> temp = purchases.getOrDefault(Integer
                .valueOf(input), new ArrayList<>());
        temp.add(getNewPurchase(sc));
        purchases.put(Integer.valueOf(input), temp);
        System.out.print("Purchase was added!\n\n");
    }


    private Purchase getNewPurchase(Scanner sc) {
        System.out.println("\nEnter purchase name");
        String name = sc.nextLine();
        System.out.println("Enter its price:");
        double price = Double.parseDouble(sc.nextLine());
        balance -= price;
        return new Purchase(name, price);
    }

    public void displayPurchases(String input) {

        ArrayList<Purchase> category = new ArrayList<>();
        switch (input) {
            case "1", "2", "3", "4" -> category = purchases.getOrDefault(Integer.valueOf(input), new ArrayList<>());
            case "5" ->
                    category = (ArrayList<Purchase>) purchases.values().stream().flatMap(ArrayList::stream).collect(Collectors.toList());
        }
        if (category.size() == 0) {
            System.out.println("The purchase list is empty\n");
        } else {
            double sum = category.stream().mapToDouble(Purchase::getPrice).sum();
            category.forEach(System.out::println);
            System.out.printf("Total sum: $%.2f\n\n", sum);
        }
    }
}
