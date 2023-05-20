package lesson_6.tools.filter;

import lesson_6.goods.Laptop;

import java.util.HashSet;
import java.util.Set;

public class CheckFilters extends Filter {


    protected static Set<Laptop> newSetLaptop = new HashSet<>();

    protected static void filtersCheck(Set<Laptop> laptopSet) {

        for (Laptop element : newSetLaptop) {
            System.out.println(element);
        }
    }
}
