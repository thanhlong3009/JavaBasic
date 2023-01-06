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

    // Kiểm tra đăng nhập
    public boolean checkLogin(LoginRequest loginRequest) {
        for (Player p : players) {
            if (p.getEmail().equals(loginRequest.getEmail()) && p.getPassword().equals(loginRequest.getPassword())) {
                return true;
            }
        }
        return false;
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
    public boolean checkPassword(String password) {

        String PASSWORD_PATTERN = "[a-z A-Z0-9]{7,15}$";
        return Pattern.matches(PASSWORD_PATTERN, password);
    }

    // TODO : chưa tìm được cách để mật khẩu rút tiền chỉ chứa 4 ký tự số
    public boolean checkPasswordWithdraw(String passwordWithdaw) {
        String PASSWORD_WITHDRAW_PATTERN = "[0,9]{4}$";
        return Pattern.matches(PASSWORD_WITHDRAW_PATTERN, passwordWithdaw);
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


    public boolean checkAmount(int amountDeposit) {
        String rs = String.valueOf(amountDeposit);
        String AMOUNT_PATTERN = "[0-9]{0,5}$";
        return Pattern.matches(AMOUNT_PATTERN, rs);
    }

    // Nạp tiền người chơi theo email.
    public void depositPlayer(DepositRequest depositRequest) {
        Player player = findPlayerByEmail(depositRequest.getEmail());
        int rs = player.getAccountBalance() + depositRequest.getAmountDeposit();
        player.setAccountBalance(rs);
        playerRepository.updateFiles();
    }

    public void withdrawPlayer(WithdrawRequest withdrawRequest) {
        Player player = findPlayerByEmail(withdrawRequest.getEmail());
        int rs = player.getAccountBalance() - withdrawRequest.getAmountWithdraw();
        player.setAccountBalance(rs);
        playerRepository.updateFiles();
    }

    // Kết quả cá cược đưa ra từ nhà cái (xúc 3 con xúc xắc)
    public int betting() {
        Random dice = new Random();

        int dice1 = dice.nextInt(5) + 1;
        int dice2 = dice.nextInt(5) + 1;
        int dice3 = dice.nextInt(5) + 1;

        return  dice3 + dice1 + dice2;

    }
}
