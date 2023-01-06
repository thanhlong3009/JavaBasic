package taixiu_management.backend.controller;

import taixiu_management.backend.model.Player;
import taixiu_management.backend.request.*;
import taixiu_management.backend.service.PlayerService;

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
    // Cộng tiền vào tài khoản, từ việc nạp
    public void depositPlayer(DepositRequest depositRequest) {
        playerService.depositPlayer(depositRequest.getEmail(),depositRequest.getAmountDeposit());
    }
    // Kiểm tra số tiền có
    public boolean checkAmount(int amountDeposit) {
        return playerService.checkAmount(amountDeposit);
    }

    // Trừ tiền từ tài khoạn, từ việc rút
    public void withdrawPlayer(WithdrawRequest withdrawRequest) {
         playerService.withdrawPlayer(withdrawRequest.getEmail(),withdrawRequest.getAmountWithdraw());
    }
    // trừ tiền từ tài khoản của bạn, cuợc thua
    public void loseBet(String email, int amountBet) {
        playerService.withdrawPlayer(email,amountBet);
    }
    // Cộng tiền vào tài khoản, cuợc thắng
    public void winBet(String email, int amountBetWin) {
        playerService.depositPlayer(email,amountBetWin);
    }


    public void changePassword(ChangePasswordRequest changePasswordRequest) {
        playerService.changePassword(changePasswordRequest);
    }

    public boolean checkEmailExist(String email) {
        return playerService.checkEmailExist(email);
    }
}
