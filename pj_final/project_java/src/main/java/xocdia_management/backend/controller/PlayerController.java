package xocdia_management.backend.controller;

import xocdia_management.backend.model.Player;
import xocdia_management.backend.repository.request.DepositRequest;
import xocdia_management.backend.repository.request.LoginRequest;
import xocdia_management.backend.repository.request.RegisterRequest;
import xocdia_management.backend.service.PlayerService;

import java.util.List;

public class PlayerController {
    private static final PlayerService playerService = new PlayerService();

    // Check đăng nhập
    public boolean checkLogin(LoginRequest loginRequest) {
        return playerService.checkLogin(loginRequest);
    }
    // Tìm người chơi theo email
    public Player findPlayerByEmail(String email) {
       return playerService.findPlayerByEmail(email);
    }
    // lấy ra danh sách người chơi
    public List<Player> getPlayers() {
        return playerService.getPlayers();
    }
    // Xóa người chơi theo tên tài khoản
    public void deletePlayers(String userName) {
        playerService.deletePlayers(userName);
    }
    // Tạo người chơi mới
    public void createPlayer(RegisterRequest registerRequest) {
        playerService.createPlayer(registerRequest);
    }


    public void depositPlayer(DepositRequest depositRequest) {
        playerService.depositPlayer(depositRequest);
    }
}
