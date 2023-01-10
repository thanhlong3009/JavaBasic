package taixiu_management.backend.service;

import taixiu_management.backend.model.Admin;
import taixiu_management.backend.model.Player;
import taixiu_management.backend.repository.AdminRepository;
import taixiu_management.backend.repository.PlayerRepository;
import taixiu_management.backend.request.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;

public class PlayerService {
    private final PlayerRepository playerRepository = new PlayerRepository();
    private final AdminRepository adminRepository = new AdminRepository();

    List<Player> players = playerRepository.findAll();

    // Lấy ra list thông tin players
    public List<Player> getPlayers() {
        return playerRepository.findAll();
    }

    // Tìm thông tin người chưa theo email
    public Player findPlayerByEmail(String email) {
        Player player = new Player();
        for (Player p : getPlayers()) {
            if (p.getEmail().equals(email)) {
                player = p;
            }
        }
        return player;
    }

    // tạo một tài khoản người chơi ( đăng ký)
    public void createPlayer(RegisterRequest registerRequest) {
        if (!checkEmailExist(registerRequest.getEmail()) && checkEmailValidate(registerRequest.getEmail())) {
            if (checkPassword(registerRequest.getPassword()) && checkPasswordWithdraw(registerRequest.getPasswordWithdaw())) {
                Player player = new Player();
                player.setEmail(registerRequest.getEmail());
                player.setPassword(registerRequest.getPassword());
                player.setUserName(registerRequest.getUserName());
                player.setAccountBalance(registerRequest.getAccountBalance());
                player.setPasswordWithdaw(registerRequest.getPasswordWithdaw());

                players.add(player);

                playerRepository.updateFiles();
                System.out.println("Tạo tài khoản thành công");
            }
            else {
                System.out.println("Mật khẩu hoặc mật khẩu thanh toán không hợp lệ");
            }
        } else {
            System.out.println("Email không hợp lệ");
        }
    }

    // Cộng tiền người chơi(nạp or win) theo email.
    public void depositPlayer(String email, int amountDeposit) {
        Player player = findPlayerByEmail(email);
        int rs = player.getAccountBalance() + amountDeposit;
        player.setAccountBalance(rs);
        playerRepository.updateFiles();
    }

    // Trừ tiền người chơi(rút or lose) theo email
    public void withdrawPlayer(String email, int amountWithdraw) {
        Player player = findPlayerByEmail(email);
        int rs = player.getAccountBalance() - amountWithdraw;
        player.setAccountBalance(rs);
        playerRepository.updateFiles();
    }

    // Thay đổi mật khẩu
    public void changePassword(ChangePasswordRequest changePasswordRequest) {
        if (checkPassword(changePasswordRequest.getNewPassword())) {
            Player player = findPlayerByEmail(changePasswordRequest.getEmail());
            player.setPassword(changePasswordRequest.getNewPassword());
            playerRepository.updateFiles();
            System.out.println("Thay đổi mật khẩu thành công!!");
        } else {
            System.out.println("Mật khẩu mới không hợp lệ, quay lại!!");
        }
    }
    // ---------------- CÁC HÀM CHECK ---------------

    // Kiểm tra đăng nhập
    public boolean checkLogin(LoginRequest loginRequest) {
        for (Player p : players) {
            if (p.getEmail().equals(loginRequest.getEmail()) && p.getPassword().equals(loginRequest.getPassword())) {
                return true;
            }
        }
        return false;
    }

    // kiểm tra email đã tồn tại chưa
    public boolean checkEmailExist(String email) {
        for (Player p : players) {
            if (p.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }
    // Kiểm tra tính hợp lệ của email

    public boolean checkEmailValidate(String email) {
        //        Định nghĩa email:
//        - Bắt đầu bằng chữ cái.
//        - Chỉ chứa chữ cái, chữ số và dấu gạch ngang (-)
//        - Chứa một ký tự @, sau @ là tên miền.
//        - Tên miền có thể là domain.xxx.yyy hoặc domain.xxx. Trong đó xxx và yyy là các chữ cái và có độ dài từ 2 trở lên.
        String EMAIL_PATTERN =  "^[a-zA-Z][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$";
        return Pattern.matches(EMAIL_PATTERN, email);
    }

    // kiểm tra tính hợp lệ của mật khẩu
    // có thể là các chữ các hoa thuờng hay chữ số, từ 7-15 ký tự
    public boolean checkPassword(String password) {

        String PASSWORD_PATTERN = "[a-z A-Z0-9]{7,15}$";
        return Pattern.matches(PASSWORD_PATTERN, password);
    }
    // Kiểm tra tính hợp lệ của mật khẩu rút tiền => 4 chữ số

    // TODO : chưa tìm được cách để mật khẩu rút tiền chỉ chứa 4 ký tự số, test riêng đúng nhưng trong bài lại sai
    public boolean checkPasswordWithdraw(String passwordWithdaw) {
        String PASSWORD_WITHDRAW_PATTERN = "[0-9]{4}$";
        return Pattern.matches(PASSWORD_WITHDRAW_PATTERN, passwordWithdaw);
    }

    // Kiểm tra số tiền nạp hoặc rút có hợp lệ không
    // là các chữ số và có từ 0 - 5 chữ số
    public boolean checkAmount(int amountDeposit) {
        String rs = String.valueOf(amountDeposit);
        String AMOUNT_PATTERN = "[0-9]{0,5}$";
        return Pattern.matches(AMOUNT_PATTERN, rs);
    }

    // Kiểm tra số dư tài khoản có lớn hơn 3 không, để tham gia cá cuợc
    public boolean checkAccountBalance(String email) {
        Player player = findPlayerByEmail(email);
        if (player.getAccountBalance() >= 3) {
            return true;
        }
        return false;
    }

    // check bảng xếp hạng
    public List<Player> getRankings() {
        Collections.sort(players,new Comparator<Player>() {
            @Override
            public int compare(Player o1, Player o2) {
                //Sử dụng toán tử 3 ngôi
                return o2.getAccountBalance() - o1.getAccountBalance() > 0 ? 1 : -1;
            }
        });

        return players;
    }
    // lấy ra danh sách admin
    public List<Admin> getAdmins() {
        return adminRepository.findAll();
    }
}

