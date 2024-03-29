package taixiu_management.frontend.player_ui;

import taixiu_management.backend.controller.PlayerController;
import taixiu_management.backend.model.Admin;

import java.util.List;
import java.util.Scanner;

public class PlayerSupportPage {

    private final PlayerController playerController = new PlayerController();

    public void run(String email) {
        Scanner sc = new Scanner(System.in);
        int option = 0;
        boolean isQuit = false;
        while (!isQuit) {
            System.out.println("\n ---- TRANG HỖ TRỢ KHÁCH HÀNG -----");
            System.out.println("Hiện nay, xuất hiện một số thành phần LỪA ĐẢO giả mạo thương hiệu SHENLONG trên không gian mạng (sao chép các hình ảnh, thiết kế, bố cục, màu sắc,...etc) " +
                    "\nđể dẫn dụ thành viên về một trang website lạ và thực hiện các hành vi lừa đảo, chiếm đoạt số tiền trong tài khoản thành viên.");
            System.out.println("Nhân viên SHENLONG sẽ KHÔNG yêu cầu thành viên phải đăng kí lại tài khoản ở bất kì website lạ nào, và với bất kì lý do nào.");
            System.out.println("SHENLONG là thương hiệu chính thức tại CHÂU ÂU & CHÂU Á. Và hiện SHENLONG KHÔNG có uỷ quyền hay cấp phép cho bất kì bên thứ 3 nào khác làm đại diện cho SHENLONG\n");
            showMenuSupport();
            try {
                System.out.print("Nhập lựa chọn : ");
                option = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ");
                continue;
            }


            switch (option) {

                case 1: {

                    int subOption = 0;
                    boolean subIsQuit = false;
                    while (!subIsQuit) {
                        System.out.println("\n ------------- HỖ TRỢ TỰ ĐỘNG --------------");
                        System.out.println("1. Nạp tiền\n2. Rút tiền\n3. Tài khoản\n4. Sản phẩm\n0. Quay lại");
                        try {
                            System.out.print("Nhập lựa chọn : ");
                            subOption = Integer.parseInt(sc.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.println("Lựa chọn không hợp lệ");
                            continue;
                        }
                        switch (subOption) {
                            case 1: {
                                System.out.println("---------- NẠP TIỀN ----------");
                                System.out.println("1. Hình thức: chuyển khoảng ngân hàng.");
                                System.out.println("2. Hạn mức nạp tiền: tối thiểu 1$, tối đa 99999$.");
                                System.out.println("3. Kiểm tra lệnh nạp: các bạn có thể kiểm tra lịch sử giao dịch tại mục [ Nạp/Rút tiền ] trên giao diện người chơi");
                                System.out.println("4. Số tài khoản SHENLONG: nhà cái SHENLONG hiện đang sử dụng 1 tài khoản ngân hàng duy nhất [ 46110000400752 | BIDV | Trần Thành Long ].");
                                System.out.println("5. Huớng dẫn rút tiền: \n   Di chuyển đến mục nạp tiền -> Chọn số tiền cần nạp -> Chuyển tiền đến số tài khoản nhà cái -> Chờ xác nhận từ admin.");
                                System.out.println("------------------------------");
                                System.out.println("Nhập một phím bất kỳ để thoát");
                                String out  = sc.nextLine();
                                break;
                            }
                            case 2: {
                                System.out.println("---------- RÚT TIỀN ----------");
                                System.out.println("1. Hình thức: Rút tiền qua thẻ cào điện thoại.");
                                System.out.println("2. Hạn mức rút tiền: tối thiểu 1$, tối đa 99999$.");
                                System.out.println("3. Kiểm tra lệnh rút: các bạn có thể kiểm tra lịch sử giao dịch tại mục [ Nạp/Rút tiền ] trên giao diện người chơi");
                                System.out.println("4. Huớng dẫn rút tiền: \n   Di chuyển đến mục rút tiền -> Chọn số tiền cần rút -> Nhập mật khẩu thanh toán -> Chờ xác nhận từ admin.");
                                System.out.println("------------------------------");
                                System.out.println("Nhập một phím bất kỳ để thoát");
                                String out  = sc.nextLine();
                                break;
                            }

                            case 3: {
                                System.out.println("--------- TÀI KHOẢN ---------");
                                System.out.println("1. Với mỗi email bạn chỉ có thể tạo được duy nhất 1 tài khoản.");
                                System.out.println("2. Bạn có thể lấy lại mật khẩu tại mục [3. Quên mật khẩu] hoặc tự thay đổi mật khẩu cá nhân của mình tại [Thay đổi mật khẩu].");
                                System.out.println("3. Số dư tài khoản của bạn sẽ được cập nhật liên tục sau mỗi ván game.");
                                System.out.println("4. Thông tin bảng xếp hạng của bạn sẽ được cập nhật liên tục sau mỗi ván game dựa vào tổng lợi nhuận ghi nhân.");
                                System.out.println("5. Nếu có thêm bất kì vấn đề phát sinh nào, bạn hãy liên hệ trực tiếp với các admin để nhận được sự hỗ trợ sớm nhất");
                                System.out.println("------------------------------");
                                System.out.println("Nhập một phím bất kỳ để thoát");
                                String out  = sc.nextLine();
                                break;
                            }

                            case 4: {
                                System.out.println("-------- SẢN PHẨM ----------");
                                System.out.println("Thị trường các cuợc online đang ngày càng phát triển, trong đó Tài Xỉu là trò chơi đang được các Bet thủ săn đón từng ngày.");
                                System.out.println("Chính vì vậy, sân chơi cung cấp game tài xỉu SHENLONG đã được ra đời để đáp ứng những nhu cầu đó. Nhà cái SHENLONG là một\n" +
                                                   "trong các đơn vị tiên phong áp dụng sớm nhất các công nghệ hiện đại. ");
                                System.out.println("SHENLONG cung cấp game tài xỉu uy tín, cách chơi đơn giản, phí cuợc cực thấp. ");
                                System.out.println("Nhà cái SHENLONG ra mất lần đầu tiên vào tháng 12 năm 2022. Dù mới chỉ có vài tháng hoạt động nhưng tên tuổi nhà cái đã vươn tầm châu lục.");

                                break;
                            }

                            case 0: {
                                subIsQuit = true;
                                System.out.println("Quay lại!!!!!");
                                break;
                            }
                            default: {
                                System.out.println("Lựa chọn không tồn tại, nhập lại!!!!!");
                            }
                        }
                    }


                    break;
                }
                case 2: {
                    System.out.println("Bạn đang có số thứ tự 23 trong hàng chờ, thời gian ước tính 15 phút .........");
                    System.out.println("\nẤn phím bất kỳ để trở lại ...");
                    String out = sc.nextLine();
                    break;
                }
                case 3: {
                    List<Admin> admins = playerController.getAdmins();
                    if (admins.isEmpty()) {
                        System.out.println("Không có admin nào");
                    } else {
                        System.out.println("\n----- DANH SÁCH ADMIN -----");
                        System.out.printf("%-20s%-30s\n", "USER_NAME", "EMAIL");
                        for (Admin a : admins) {
                            System.out.printf("%-20s%-30s\n", a.getUserName(), a.getEmail());
                        }
                    }
                    System.out.println("Hãy liên hệ trực tiếp với 1 trong các admin qua email để nhận được sự hỗ trợ sớm nhất!!!");
                    System.out.println("\nNhấn phím bất kỳ + Enter để quay lại");
                    String out = sc.nextLine();
                    break;
                }
                case 0: {
                    isQuit = true;
                    break;
                }
                default: {
                    System.out.println("Lựa chọn không hợp lệ, nhập lại");
                }
            }
        }
    }

    public static void showMenuSupport() {

        System.out.println("1. Chat tự động");
        System.out.println("2. Live Chat");
        System.out.println("3. Liên hệ trực tiếp với các admin");
        System.out.println("0. Quay lại");
    }
}
