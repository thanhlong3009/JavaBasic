import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateAndTime {
    public static void main(String[] args) {
        // Ngày tháng năm hiện tại
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        // Ngày tháng năm chỉ định hiện tại
        LocalDate localDate1 = LocalDate.of(2022, 4, 30);
        System.out.println(localDate1);

        // Một số phương thức
        System.out.println("Năm : " + localDate.getYear());
        System.out.println("Tháng : " + localDate.getMonth());
        System.out.println("Ngày : " + localDate.getDayOfMonth());
        System.out.println("Thứ : " + localDate.getDayOfWeek().getValue());
        System.out.println("Ngày thứ bao nhiêu của năm : " + localDate.getDayOfYear());

        // Cộng ngày tháng năm
        System.out.println("Năm sau khi cộng 3 : " + localDate.plusYears(2));
        System.out.println("Tháng sau khi cộng 2 : " + localDate.plusMonths(2));
        System.out.println("Ngày sau khi cộng 12 : " + localDate.plusDays(1));
        System.out.println("Week sau khi cộng 10 : " + localDate.plusWeeks(1));

        // So sánh đối tượng LocalDate
        // So sánh 2 đối tượng LocalDate với nhau
        LocalDate ld1 = LocalDate.now();
        LocalDate ld2 = LocalDate.now();
        LocalDate ld3 = LocalDate.now().plusDays(2);

        System.out.println(ld1.compareTo(ld2)); // 0
        System.out.println(ld3.compareTo(ld1)); // 1
        System.out.println(ld1.compareTo(ld3)); // -1

        // isEqual
        System.out.println(ld1.isEqual(ld2)); // true
        System.out.println(ld3.isEqual(ld1)); // false

        // isBefore
        System.out.println(ld1.isBefore(ld3)); // true
        System.out.println(ld3.isBefore(ld1)); // false

        // isAfter
        System.out.println(ld1.isAfter(ld3)); // false
        System.out.println(ld3.isAfter(ld1)); // true

        // Kiểm tra năm nhuận
        System.out.println(ld1.isLeapYear()); // false
        System.out.println(ld1.minusYears(2).isLeapYear()); // true


        // Covert LocalDate --> String
        String strDate = ld1.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.println(strDate);

        // Covert String --> LocalDate
        String strDate1 = "22/05/2022";
        LocalDate ld4 = LocalDate.parse(strDate1, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.println(ld4);


    }
}
