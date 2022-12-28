package funtional_interface_build_in;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class PredicateDemo<T> {
    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>(List.of(10, 25, 31, 40, 50));


        // Xóa các phần tử lớn hơn 30
//        numbers.removeIf(number -> number > 30);
//        System.out.println(numbers);

        PredicateDemo<Integer> predicateDemo = new PredicateDemo<>();
        Predicate<Integer> predicate = item -> item > 30;
        Predicate<Integer> predicate1 = item -> item % 2 == 0;
        Predicate<Integer> predicate2 = item -> item % 2 != 0;

        List<Integer> rs = predicateDemo.filterList(numbers,predicate);
        System.out.println(rs);

        PredicateDemo<String> predicateDemo1 = new PredicateDemo<>();
        List<String> names = new ArrayList<>(List.of("Long", "Huơng","Thảo","Sơn"));

        Predicate<String> predicate3 = item -> item.length() > 3;
        List<String> rs1 = predicateDemo1.filterList(names,predicate3);
        System.out.println(rs1);
//
//        List<Integer> rs1 = filterList(numbers,predicate1);
//        System.out.println(rs1);
//
//        List<Integer> rs2 = filterList(numbers,predicate2);
//        System.out.println(rs2);


    }

    public  List<T> filterList(List<T> list, Predicate<T> predicate) {
        List<T> rs = new ArrayList<>();
        for (T item : list) {
            if (predicate.test(item)) {
                rs.add(item);
            }
        }
        return rs;
    }
}
