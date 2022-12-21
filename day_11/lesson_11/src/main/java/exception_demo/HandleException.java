package exception_demo;

public class HandleException {
    public static void main(String[] args) {
        try {
            methodOne();
            methodTwo();
        } catch (ArithmeticException | NullPointerException e) {
            System.out.println("Loi roi, xu ly di");
            System.out.println(e.getMessage());
            e.printStackTrace();
        } finally {
            System.out.println("finally");
        }
//        } catch (NullPointerException e) {
//            System.out.println("Xu ly loi NullPointerException");
//        }
        System.out.println("code continue");
    }

    public static void methodOne() {
        int number = 9;
        int zero = 2;
        System.out.println(number/zero);
    }

    public static void methodTwo() {
        String str = "abc";
        System.out.println(str.length());
    }
}
