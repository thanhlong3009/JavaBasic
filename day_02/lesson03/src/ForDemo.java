public class ForDemo {
    public static void main(String[] args) {
        // begin: Khởi tạo giá trị ban đầu cho vòng lặp
        // condition: Điều kiện để tiếp tục chạy vòng lặp
        // step: Cập nhật giá trị mỗi lần lặp

        //Thực hiện công việc dậy lúc 5h tong 30 ngày
//        for (int day = 1 ; day <= 30 ; day ++ ){
//            System.out.println("Ngày " + day + " thức dậy lúc 5h");
//        }
        // ví dụ 2: ngày chắn thức dậy lúc 5h, ngày lẻ thức dậy lúc 7h
//        for (int day = 1 ; day <= 30 ; day ++ ){
//            if (day % 2 == 0){
//                System.out.println("Ngày " + day + " thức dậy lúc 5h");
//            }else
//                System.out.println("Ngày " + day + " thức dậy lúc 7h");
//        }

        // ví dụ 3: thực hiện đến ngày 20 bỏ
//        for (int day = 1 ; day <= 30 ; day ++ ){
//            if (day == 20){
//                System.out.println("Bỏ ");
//                break;
//            }
//            System.out.println("Ngày " + day + " thức dậy lúc 5h");
//        }

        // ví dụ 4 : continue, vẫn thực hiện công việc nhưng cuối tuần nghỉ không thực hiện nữa
//        for (int day = 1 ; day <= 30 ; day ++ ){
//            if (day % 7 == 0 ){
//                System.out.println("nghỉ xả hơi");
//                continue;
//            }
//            System.out.println("Ngày " + day + " thức dậy lúc 5h");
//        }

        // Tính tổng tiền tiết kiệm
        // Tiết kiệm tiền trong 10 ngày, mỗi ngày tiết kiệm 100k từ ngày thứ 5 thì là 200k
        // Ngày 8 bạn rủ đi nhậu lấy 500 ra
        int total = 0;
        for (int day = 1; day <= 10; day++) {
            if (day == 8) {
                total -= 500_000;
            }
            if (day >= 5) {
                total += 200_000;
            } else {
                total += 100_000;
            }
        }
        System.out.println("Tổng tiền: " + total);

    }
}
