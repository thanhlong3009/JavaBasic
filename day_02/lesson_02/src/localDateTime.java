import java.time.*;

public class localDateTime {
    public static void main(String[] args) {
        // Khởi tạo ngày và giờ hiện tại
        LocalDateTime toDay = LocalDateTime.now();
        System.out.println("Ngày và giờ hiện tại: " + toDay);

        LocalDateTime currentDateTime = LocalDateTime.of(LocalDate.now(), LocalTime.now());

        // Khởi tạo ngày 20/4/2021 12h30
        LocalDateTime  getDateTime = LocalDateTime.of(2021,4,20,12,20);
        System.out.println("Ngày và giờ chỉ định: " + getDateTime);

        LocalDateTime getDateTime2 = LocalDateTime.of(2021, Month.APRIL,20,12,20);
        System.out.println("Ngày và giờ chỉ định: " + getDateTime2);


    }
}
