public class Bai2 {
    public static final char SPACE = ' ';

    public static void main(String[] args) {

        executeString(" Tran Thanh Long  gfdgdoo   ");
    }

    public static void executeString(String str) {
        // Đếm số từ trong chuỗi
        int count = 0;
        boolean checkSpace = true;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != SPACE) {
                if (checkSpace) {
                    count++;
                    checkSpace = false;
                }
            }else {
                checkSpace = true;
            }
        }
        System.out.println("Số từ có trong chuỗi là: " + count);

        // đếm sô Ký tự o trong chuỗi
        int countCharO = 0;
        char kyTu = 'o';
        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) == kyTu) {
                countCharO++;
            }
        }
        System.out.println("Số ký tự \"o\" trong chuỗi là: " + countCharO);
    }
}
