package budget;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner sc = new Scanner(System.in);
        Budget budget = new Budget();
        PurchaseListFile purchaseListFile = new PurchaseListFile();
        boolean toContinue = true;
        while (toContinue) {
            System.out.print("""
                    Choose your action:
                    1) Add income
                    2) Add purchase
                    3) Show list of purchases
                    4) Balance
                    5) Save
                    6) Load
                    0) Exit
                    """);
            String option = sc.nextLine();
            System.out.println();
            switch (option) {
                case "1" -> {
                    System.out.println("Enter income:");
                    budget.addIncome(Double.parseDouble(sc.nextLine()));
                }
                case "2" -> addingMenu(sc, budget);
                case "3" -> displayMenu(sc, budget);
                case "4" -> System.out.printf("Balance: $%.2f\n\n", budget.getBalance());
                case "5" -> purchaseListFile.savePurchaseList(budget);
                case "6" -> purchaseListFile.loadPurchaseList(budget);
                case "0" -> toContinue = false;
            }
        }
        System.out.println("Bye!");
    }

    public static void addingMenu(Scanner sc, Budget budget) {
        boolean toContinue = true;
        while (toContinue) {
            System.out.print("""
                    Choose the type of purchases
                    1) Food
                    2) Clothes
                    3) Entertainment
                    4) Other
                    5) Back
                    """);
            String input = sc.nextLine();
            switch (input) {
                case "1", "2", "3", "4" -> budget.addPurchase(input, sc);
                case "5" -> {
                    toContinue = false;
                    System.out.println();
                }
            }
        }
    }

    public static void displayMenu(Scanner sc, Budget budget) {
        boolean toContinue = true;
        while (toContinue) {
            System.out.println("""
                    Choose the type of purchases
                    1) Food
                    2) Clothes
                    3) Entertainment
                    4) Other
                    5) All
                    6) Back
                    """);

            String input = sc.nextLine();
            switch (input) {
                case "1", "2", "3", "4", "5" -> budget.displayPurchases(input);
                case "6" -> {
                    toContinue = false;
                    System.out.println();
                }
            }
        }
    }
}
