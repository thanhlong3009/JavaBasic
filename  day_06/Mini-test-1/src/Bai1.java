public class Bai1 {
    public static void main(String[] args) {
        //In ra hình vuông
        System.out.println("In ra hình vuông");
        printSquare(4);

        // In ra hình tam giác
        System.out.println("In ra hình tam giác");
        printRightTriangle(4);
    }

    // In ra hình vuông
    public static void printSquare(int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print("*  ");
            }
            System.out.println();
        }
    }

    // In ra hình tam giác

    public static void printRightTriangle(int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i >= j) {
                    System.out.print("* ");
                }
                else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}
