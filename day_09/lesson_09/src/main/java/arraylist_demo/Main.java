package arraylist_demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);

        System.out.println(numbers);

        //Method

        numbers.add(3,10);
        System.out.println(numbers);

        ArrayList<Integer> numbers1 = new ArrayList<>(List.of(100,200,300));
        numbers.addAll(numbers1);
        System.out.println(numbers);

        System.out.println(numbers.contains(100));
        System.out.println(numbers.get(0));

        // 1. Sử dụng for binh thường
        for (int i = 0; i < numbers.size(); i++) {
            System.out.println(numbers.get(i));
        }

        // 3. Sử dụng Iterator
        Iterator<Integer> iterator = numbers.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }




        ArrayList<String> names = new ArrayList<>(List.of("hiên","Long","Huy"));
        System.out.println(names);
    }

}
