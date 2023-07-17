package budget;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class PurchaseListFile {
    private final File file = new File("purchases.txt");

    public PurchaseListFile() {
        try {
            boolean createdNew = file.createNewFile();
            if (createdNew) {
                System.out.println("The file was successfully created.");
            } else {
                System.out.println("The file already exists.");
            }
        } catch (IOException e) {
            System.out.println("Cannot create the file: " + file.getPath());
        }
    }

    public void savePurchaseList(Budget budget) {
        try (PrintWriter printWriter = new PrintWriter(file)) {
            printWriter.print(budget.getBalance());
            HashMap<Integer, ArrayList<Purchase>> purchases = budget.getPurchases();
            purchases.forEach((key, value) ->
                    value.forEach(purchase ->
                            printWriter.printf("\n%d;%s;%.2f", key, purchase.getName(), purchase.getPrice())));
        } catch (FileNotFoundException e) {
            System.out.println("ERROR with PrintWriter" + e.getMessage());
        }
    }

    public void loadPurchaseList(Budget budget) {
        ArrayList<ArrayList<Purchase>> list = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            list.add(new ArrayList<>());
        }
        try (Scanner sc = new Scanner(file)) {
            budget.setBalance(Double.parseDouble(sc.nextLine()));
            while (sc.hasNext()) {
                String[] line = sc.nextLine().split(";");
                list.get(Integer.parseInt(line[0])-1).add(new Purchase(line[1], Double.parseDouble(line[2])));
            }
            for(int i = 0; i < list.size(); i++) {
                budget.insertPurchaseList(i + 1, list.get(i));
            }
            System.out.println("Purchases were loaded!\n");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
