package xocdia_management.backend.service;

import xocdia_management.backend.model.Player;
import xocdia_management.backend.repository.PlayerRepository;
import xocdia_management.backend.repository.request.DepositRequest;
import xocdia_management.backend.repository.request.LoginRequest;
import xocdia_management.backend.repository.request.RegisterRequest;

import java.util.ArrayList;
import java.util.List;
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
        for (Player p: players) {
            if (p.getEmail().equals(loginRequest.getEmail()) && p.getPassword().equals(loginRequest.getPassword())) {
                return true;
            }
        }
        return false;
    }
    // Tìm thông tin người chưa theo email
    public Player findPlayerByEmail(String email) {
        Player player = new Player();
        for (Player p: getPlayers()) {
            if (p.getEmail().equals(email)){
                player = p;
            }
        }
        return player;
    }

    // kiểm tra email đã tồn tại chưa
    public boolean checkEmailExist(String email){
        for (Player p:players) {
            if(p.getEmail().equals(email)) {
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

    // tạo một tài khoản người chơi ( đăng ký)
    public void createPlayer(RegisterRequest registerRequest) {
        if (!checkEmailExist(registerRequest.getEmail()) && checkEmailValidate(registerRequest.getEmail()) && checkPassword(registerRequest.getPassword())) {
            Player player = new Player();
            player.setEmail(registerRequest.getEmail());
            player.setPassword(registerRequest.getPassword());
            player.setUserName(registerRequest.getUserName());
            player.setAccountBalance(registerRequest.getAccountBalance());

            players.add(player);

            playerRepository.updateFiles((ArrayList<Player>) players);
            System.out.println("Tạo tài khoản thành công");
        }else {
            System.out.println("Đăng ký không hợp lệ, vui lòng thử lại!");
        }
    }

//    public boolean check

    // Nạp tiền người chơi theo email.
    public void depositPlayer(DepositRequest depositRequest) {

    }
}
