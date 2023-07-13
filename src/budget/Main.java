package budget;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // write your code here
        String line = null;
        ArrayList<String> orderList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        double sum = 0.0;
        while (sc.hasNext()) {
            line = sc.nextLine();
            orderList.add(line);
            sum += Double.parseDouble(line.substring(line.indexOf('$') + 1));
        }
        orderList.forEach(System.out::println);
        System.out.printf("Total: $%.2f\n", sum);
    }
}
