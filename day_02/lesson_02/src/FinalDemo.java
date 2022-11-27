public class FinalDemo {

    public static final String EMAIL = "thanhlongite6@gmail.com";

    public static void main(String[] args) {
        final String NAME = "Bob";
        final String FIRST_NAME = "Long";
        System.out.println(FIRST_NAME);
        System.out.println(NAME);

        System.out.println(EMAIL);
        System.out.println(sumTwoNumber(10,20));
    }

    // Method final không thể overide (ghi đè)
    public static final int sumTwoNumber(int a, int b) {
        return a + b;
    }
}
