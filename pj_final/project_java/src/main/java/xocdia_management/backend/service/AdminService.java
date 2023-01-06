package xocdia_management.backend.service;

import xocdia_management.backend.model.Admin;
import xocdia_management.backend.model.Player;
import xocdia_management.backend.repository.AdminRepository;
import xocdia_management.backend.repository.PlayerRepository;
import xocdia_management.backend.request.LoginRequest;

import java.util.List;

public class AdminService {
    private final AdminRepository adminRepository = new AdminRepository();

    private final PlayerRepository playerRepository = new PlayerRepository();
    List<Admin> admins = adminRepository.findAll();

    // lấy ra list admin
    public List<Admin> getAdmins() {
        return adminRepository.findAll();
    }

    // Check login
    public boolean checkLogin(LoginRequest loginRequest) {
        for (Admin a:getAdmins()) {
            if (a.getEmail().equals(loginRequest.getEmail()) && a.getPassword().equals(loginRequest.getPassword())) {
                return true;
            }
        }

        return false;
    }
    public Admin findAdminByEmail(String email) {
        Admin admin = new Admin();
        for (Admin a: adminRepository.findAll()) {
            if (a.getEmail().equals(email)){
                admin = a;
            }
        }
        return admin;
    }
    public boolean checkEmailExist(String email) {
        for (Admin a: getAdmins()) {
            if (a.getEmail().equals(email)){
                return true;
            }
        }
        return false;
    }

    public List<Player> getPlayers() {
        return playerRepository.findAll();
    }

    public void deletePlayers(String userName) {
        Player player = playerRepository.findPlayerByUserName(userName);
        playerRepository.deletePlayers(player);
    }
}
