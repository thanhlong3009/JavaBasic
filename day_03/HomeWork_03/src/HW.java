public class HW {
    public static void main(String[] args) {
        System.out.println(repeat3("long", 5));
    }
    public static String repeat3(String str, int number) {
        String rp = str;
        for (int i = 1; i < number; i++) {
            rp = rp + "-" + str;
        }
        return rp;
    }
}
