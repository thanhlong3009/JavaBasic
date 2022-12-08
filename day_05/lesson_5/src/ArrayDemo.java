import java.util.Arrays;

public class ArrayDemo {
    public static void main(String[] args) {

        String message = "một nGày nÀo đÓ";
        String[] messageArray = message.split("");
        System.out.println(Arrays.toString(messageArray));

        for (int i = 0; i < messageArray.length ; i++) {
            messageArray[i] = messageArray[i].substring(0,1).toUpperCase() + messageArray[i].substring(1).toLowerCase();
        }
        // sử dụng convert string qua array dùng join
        String messageString = String.join(" ",messageArray);
        System.out.println(Arrays.toString(messageArray));
    }
}
