public class IfDemo {
    public static void main(String[] args) {
        // ví dụ
        int hour = 16;
        if (hour < 12) {
            System.out.println("Good morning!");
        }else if (hour >= 12 && hour < 18){
            System.out.println("Good afternoon");
        }


        boolean troiDep = true;
        boolean coTien = true;

        // Kết hợp nhiều điều kiện && , ||. !
        if (!troiDep && coTien) {
            System.out.println("đi chơi");
        }else {
            System.out.println("Ở nhà");
        }
        if (!troiDep && coTien) {
            System.out.println("đi chơi");
        }

        if (!troiDep || coTien) {
            System.out.println("đi chơi");
        }

        // Toán tử 3 ngôi
        String message = (troiDep && coTien) ? "Đi chơi" : " ở nhà";
        System.out.println(message);

        int number = -7;
        String text = number > 0 ? "số dương" : number == 0 ? "Số 0" : "số âm";
        System.out.println(text);



    }
}
