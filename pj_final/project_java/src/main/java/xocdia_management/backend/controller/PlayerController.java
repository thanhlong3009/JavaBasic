package xocdia_management.backend.controller;

import xocdia_management.backend.model.Player;
import xocdia_management.backend.request.DepositRequest;
import xocdia_management.backend.request.LoginRequest;
import xocdia_management.backend.request.RegisterRequest;
import xocdia_management.backend.request.WithdrawRequest;
import xocdia_management.backend.service.PlayerService;

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
    // Tạo người chơi mới
    public void createPlayer(RegisterRequest registerRequest) {
        playerService.createPlayer(registerRequest);
    }


    public void depositPlayer(DepositRequest depositRequest) {
        playerService.depositPlayer(depositRequest);
    }

    public boolean checkAmount(int amountDeposit) {
        return playerService.checkAmount(amountDeposit);
    }

    public void withdrawPlayer(WithdrawRequest withdrawRequest) {
         playerService.withdrawPlayer(withdrawRequest);
    }

    public int betting() {
        return playerService.betting();
    }
}
