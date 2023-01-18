package taixiu_management.backend.controller;

import taixiu_management.backend.model.Admin;
import taixiu_management.backend.model.Player;
import taixiu_management.backend.model.Status;
import taixiu_management.backend.model.TransactionHistory;
import taixiu_management.backend.request.LoginRequest;
import taixiu_management.backend.service.AdminService;

import java.awt.print.PrinterJob;
import java.util.List;

public class AdminController {
    private final AdminService adminService = new AdminService();

    // Lấy ra danh sách người chơi
    public List<Player> getPlayers() {
        return adminService.getPlayers();
    }

    // Đăng nhập admin
    public boolean checkLogin(LoginRequest loginRequest) {
        return adminService.checkLogin(loginRequest);
    }

    // Xóa người chơi theo username
    public void deletePlayers(String userName) {
        adminService.deletePlayers(userName);
    }

    // Lấy ra bảng xếp hạng người chơi
    public List<Player> getRankings() {
        return adminService.getRankings();
    }

    // Tìm kiếm admin theo email
    public Admin findAdminByEmail(String email) {
        return adminService.findAdminByEmail(email);
    }


    // Tìm kiếm danh sách người chơi theo email
    public List<Player> findPlayersByEmail(String emailFind) {
        return adminService.findPlayersByEmail(emailFind);
    }

    // Lấy ra các giao dịch đang chờ xử lý
    public List<TransactionHistory> getHistoriesPending() {
        return adminService.getHistoriesPending();
    }

    // Kiểm tra giao dịch có tồn tại không bằng mã giao dịch
    public boolean checkTransactionExits(int transactionCode) {
        return adminService.checkTransactionExits(transactionCode);
    }

    // Tìm kiếm giao dịch bằng mã giao dịch
    public TransactionHistory findTransactionHistoryByCode(int transactionCode) {
        return adminService.findTransactionHistoryByCode(transactionCode);
    }

    // Update trạng thái của giao dịch sau khi xử lý
    public void updateStatus(int transactionCode, Status stt) {
        adminService.updateStatus(transactionCode,stt);
    }
}


