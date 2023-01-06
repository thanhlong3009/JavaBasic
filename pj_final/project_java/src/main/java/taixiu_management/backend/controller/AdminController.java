package taixiu_management.backend.controller;

import taixiu_management.backend.model.Admin;
import taixiu_management.backend.model.Player;
import taixiu_management.backend.request.LoginRequest;
import taixiu_management.backend.service.AdminService;

import java.util.List;

public class AdminController {
    private final AdminService adminService = new AdminService();

    public  List<Admin> getAdmins() {
        return adminService.getAdmins();
    }

    // Lấy ra danh sách người chơi
    public List<Player> getPlayers() {
        return adminService.getPlayers();
    }
    public Admin findAdminByEmail(String email) {
        return adminService.findAdminByEmail(email);
    }

    public boolean checkLogin(LoginRequest loginRequest) {
        return adminService.checkLogin(loginRequest);
    }


    // Xóa người chơi theo username
    public void deletePlayers(String userName) {
        adminService.deletePlayers(userName);
    }
}
