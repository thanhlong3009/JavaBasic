package xocdia_management.backend.service;

import xocdia_management.backend.model.Player;
import xocdia_management.backend.repository.PlayerRepository;
import xocdia_management.backend.request.DepositRequest;
import xocdia_management.backend.request.LoginRequest;
import xocdia_management.backend.request.RegisterRequest;
import xocdia_management.backend.request.WithdrawRequest;

import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;

public class PlayerService {
    private final PlayerRepository playerRepository = new PlayerRepository();

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
        if (!checkEmailExist(registerRequest.getEmail()) && checkEmailValidate(registerRequest.getEmail()) && checkPassword(registerRequest.getPassword()) && checkPassword(registerRequest.getPasswordWithdaw())) {
            Player player = new Player();
            player.setEmail(registerRequest.getEmail());
            player.setPassword(registerRequest.getPassword());
            player.setUserName(registerRequest.getUserName());
            player.setAccountBalance(registerRequest.getAccountBalance());
            player.setPasswordWithdaw(registerRequest.getPasswordWithdaw());

            players.add(player);

            playerRepository.updateFiles();
            System.out.println("Tạo tài khoản thành công");
        } else {
            System.out.println("Đăng ký không hợp lệ, vui lòng thử lại!");
        }
    }
    // Cộng tiền người chơi(nạp or win) theo email.
    public void depositPlayer(String email, int  amountDeposit) {
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
        String EMAIL_PATTERN =
                "^[a-zA-Z][\\w-]+@([\\w]{5}+\\.[\\w]{3,}+|[\\w]{5}+\\.[\\w]{3,}\\.[\\w]{2,})$";

        return Pattern.matches(EMAIL_PATTERN, email);
    }
                                        // kiểm tra tính hợp lệ của mật khẩu
            // có thể là các chữ các hoa thuờng hay chữ số, từ 7-15 ký tự
    public boolean checkPassword(String password) {

        String PASSWORD_PATTERN = "[a-z A-Z0-9]{7,15}$";
        return Pattern.matches(PASSWORD_PATTERN, password);
    }
                                        // Kiểm tra tính hợp lệ của mật khẩu rút tiền => 4 chữ số

    // TODO : chưa tìm được cách để mật khẩu rút tiền chỉ chứa 4 ký tự số
    public boolean checkPasswordWithdraw(String passwordWithdaw) {
        String PASSWORD_WITHDRAW_PATTERN = "[0,9]{4}$";
        return Pattern.matches(PASSWORD_WITHDRAW_PATTERN, passwordWithdaw);
    }

                                        // Kiểm tra số tiền nạp hoặc rút có hợp lệ không
                                        // là các chữ số và có từ 0 - 5 chữ số
    public boolean checkAmount(int amountDeposit) {
        String rs = String.valueOf(amountDeposit);
        String AMOUNT_PATTERN = "[0-9]{0,5}$";
        return Pattern.matches(AMOUNT_PATTERN, rs);
    }
}

