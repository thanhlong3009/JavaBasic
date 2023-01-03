package stream_api;

import java.util.List;
import java.util.Optional;
import java.util.SortedMap;
import java.util.stream.Collectors;

public class Practice {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(10, 5, 3, 12, 6, 7, 5, 3);

//        Duyệt numbers
        numbers.stream().forEach(System.out::println);
//        Tìm các giá trị chẵn trong list
        System.out.println("câu 2");
        numbers.stream().filter(n -> n % 2 == 0).forEach(System.out::println);
//        Tìm các giá trị > 5 trong list

        System.out.println("câu 3");
        numbers.stream().filter(n -> n > 5).forEach(System.out::println);
//        Tìm giá trị max trong list
        System.out.println("Câu 4");
        List<Integer> integerList = numbers.stream().sorted().toList();
        Integer max = integerList.get(integerList.size() -1);
        System.out.println(max);
//        Tìm giá trị min trong list

        System.out.println("Câu 5");
        Optional<Integer> optionalInteger = numbers.stream().max((a,b) -> b -a );
        optionalInteger.ifPresent(System.out::println);
//        Tính tổng các phần tử của mảng
        System.out.println("Câu 6");
        // Cách 1
        Integer total = numbers.stream().mapToInt(n -> n).sum();
        System.out.println(total);

        // Cách 2
        int total1 = numbers.stream().reduce(0,(a,b) -> a + b);
        System.out.println(total1);
//        Lấy danh sách các phần tử không trùng nhau

        System.out.println("Câu 7");
        numbers.stream().distinct().forEach(System.out::println);
//        Lấy 5 phần tử đầu tiên trong mảng
        System.out.println("Câu 8");
        numbers.stream().limit(5).forEach(System.out::println);

//        Lấy phần tử từ thứ 3 -> thứ 5

        System.out.println("Câu 9");
        numbers.stream().skip(2).limit(3).forEach(System.out::println);
//        Lấy phần tử đầu tiên > 5
        System.out.println("Câu 10");
         numbers.stream().filter(n -> n > 5).findFirst().ifPresent(System.out::println);

//        Kiểm tra xem list có phải là list chẵn hay không

//        Kiểm tra xem list có phần tử > 10 hay không

//        Có bao nhiêu phần tử > 5

//        Nhân đôi các phần tủ trong list và trả về list mới

//        Kiểm tra xem list không chứa giá trị nào = 8 hay không

    }
}
