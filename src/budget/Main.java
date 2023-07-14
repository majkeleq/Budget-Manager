package budget;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Budget budget = new Budget();
        Scanner sc = new Scanner(System.in);
        boolean toContinue = true;
        while(toContinue) {
            System.out.println("Choose your action:\n" +
                    "1) Add income\n" +
                    "2) Add purchase\n" +
                    "3) Show list of purchases\n" +
                    "4) Balance\n" +
                    "0) Exit\n");
            String option = sc.nextLine();
            System.out.println();
            switch (option) {
                case "1" -> {
                    System.out.println("Enter income:");
                    budget.addIncome(Double.parseDouble(sc.nextLine()));}
                case "2" -> budget.addPurchase(sc);
                case "3" -> budget.showPurchases();
                case "4" -> System.out.printf("Balance: $%.2f\n\n", budget.getBalance());
                case "0" -> toContinue = false;
            }
        }
        System.out.println("Bye!");
    }
}
