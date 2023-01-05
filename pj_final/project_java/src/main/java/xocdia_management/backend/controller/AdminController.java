package xocdia_management.backend.controller;

import xocdia_management.backend.model.Admin;
import xocdia_management.backend.model.Player;
import xocdia_management.backend.repository.request.LoginRequest;
import xocdia_management.backend.service.AdminService;

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
