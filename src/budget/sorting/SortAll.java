package budget.sorting;

import budget.Purchase;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class SortAll implements SortingMethod{

    @Override
    public void sort(HashMap<Integer, ArrayList<Purchase>> purchases) {
        purchases.values()
                .stream()
                .flatMap(List::stream)
                .sorted(Comparator.comparingDouble(Purchase::getPrice).reversed())
                .forEach(System.out::println);
    }
}
