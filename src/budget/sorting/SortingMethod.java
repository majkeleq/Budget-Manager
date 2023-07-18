package budget.sorting;

import budget.Purchase;

import java.util.ArrayList;
import java.util.HashMap;

public interface SortingMethod {
    void sort(HashMap<Integer, ArrayList<Purchase>> purchases);
}
