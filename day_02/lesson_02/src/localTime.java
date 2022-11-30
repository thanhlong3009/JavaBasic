import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class localTime {
    public static void main(String[] args) {
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);

        LocalTime localTime1 = LocalTime.of(10, 20, 30);
        System.out.println(localTime1);
        // Một số phương thức
        // Thêm thời gian
        System.out.println("Thêm thời gian");
        System.out.println(localTime.plusHours(2));
        System.out.println(localTime.plusMinutes(2));
        System.out.println(localTime.plusSeconds(2));
        System.out.println(localTime.plusNanos(2));
        // Bớt thời gian
        System.out.println("Giảm thời gian");
        System.out.println(localTime.minusHours(2));
        System.out.println(localTime.minusMinutes(2));
        System.out.println(localTime.minusSeconds(2));
        System.out.println(localTime.minusNanos(2));
        // Đặt lại thời gian
        System.out.println("Đặt lại thời gian");
        System.out.println(localTime.withHour(2));
        System.out.println(localTime.withMinute(2));
        System.out.println(localTime.withSecond(2));
        System.out.println(localTime.withNano(2));
        // So sánh thời gian
        LocalTime lt1 = LocalTime.now();
        LocalTime lt2 = LocalTime.now();
        LocalTime lt3 = LocalTime.now().plusHours(1);
        // So sánh 2 đối tượng LocalDate -> giá trị trả về  : -1, 0 , 1
        System.out.println(lt1.compareTo(lt2));
        System.out.println(lt2.compareTo(lt3));
        // So sánh 2 đối tượng LocalDate -> giá trị trả về  : true/false
        System.out.println(lt1.equals(lt2));
        System.out.println(lt2.equals(lt3));

        System.out.println(lt1.isBefore(lt3));
        System.out.println(lt3.isBefore(lt1));

        System.out.println(lt1.isAfter(lt3));
        System.out.println(lt3.isAfter(lt1));
        // Convert LocalDate sang String
        System.out.println(lt1.format(DateTimeFormatter.ofPattern("hh:mm:ss")));


    }


}
