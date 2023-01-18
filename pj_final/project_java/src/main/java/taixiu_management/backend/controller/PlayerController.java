package taixiu_management.backend.controller;

import taixiu_management.backend.model.Admin;
import taixiu_management.backend.model.Player;
import taixiu_management.backend.request.*;
import taixiu_management.backend.service.PlayerService;

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
    public void loseBet(String email, int amountBet){
        playerService.loseBet(email,amountBet);
    }

    // Cộng tiền vào tài khoản, cuợc thắng
    public void winBet(String email, int amountBetWin) {
        playerService.winBet(email,amountBetWin);
    }

    // Check password có hợp lệ không
    public void changePassword(ChangePasswordRequest changePasswordRequest) {
        playerService.changePassword(changePasswordRequest);
    }

    // Check email đã tồn tại chưa
    public boolean checkEmailExist(String email) {
        return playerService.checkEmailExist(email);
    }

    // Check số dư tài khoản để chơi game
    public boolean checkAvailableAccountBalance(String email) {
        return playerService.checkAvailableAccountBalance(email);
    }

    // check bảng xếp hạng
    public List<Player> getRankings() {
        return playerService.getRankings();
    }

    // lấy ra danh sách admin hỗ trợ
    public List<Admin> getAdmins() {
        return playerService.getAdmins();
    }

    // check email hợp lệ
    public boolean checkEmailValidate(String email) {
        return playerService.checkEmailValidate(email);
    }

    //check username hợp lệ
    public boolean checkUserName(String userName) {
        return playerService.checkUserName(userName);
    }

    // checkpw hợp lệ
    public boolean checkPassword(String password) {
        return playerService.checkPassword(password);
    }

    // check mật khẩu thanh toán hợp lệ
    public boolean checkPasswordWithdraw(String passwordWithdaw) {
        return playerService.checkPasswordWithdraw(passwordWithdaw);
    }

    // Kiểm tra username có tồn tại không
    public boolean checkUserNameExist(String userName) {
        return playerService.checkUserNameExist(userName);
    }

    // trừ số dư tạm thời khi giao dịch rút tiền đang chờ xử lý
    public void temporaryWithdrawPlayer(String email, int amountWithdraw) {
        playerService.temporaryWithdrawPlayer(email,amountWithdraw);
    }

    // Trả lại tiền về số dư ban đầu khi giao dịch rút tiền thất bại
    public void returnWithdraw(String email, int amount) {
        playerService.returnWithdraw(email,amount);
    }
}
