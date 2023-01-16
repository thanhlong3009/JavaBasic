package taixiu_management.backend.service;

import taixiu_management.backend.model.Admin;
import taixiu_management.backend.model.Player;
import taixiu_management.backend.repository.AdminRepository;
import taixiu_management.backend.repository.PlayerRepository;
import taixiu_management.backend.request.LoginRequest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
    // Tìm kiếm admin theo email
    public Admin findAdminByEmail(String email) {
        Admin admin = new Admin();
        for (Admin a: adminRepository.findAll()) {
            if (a.getEmail().equals(email)){
                admin = a;
            }
        }
        return admin;
    }

    // Láy ra danh sách người chơi
    public List<Player> getPlayers() {
        return playerRepository.findAll();
    }

    // Xóa người chơi theo UserName
    public void deletePlayers(String userName) {
        Player player = playerRepository.findPlayerByUserName(userName);
        playerRepository.deletePlayers(player);
    }

    // Lấy ra danh sách bảng xếp hạng ngườ chơi
    public List<Player> getRankings() {
        List<Player> playersRankings = playerRepository.findAll();
        playersRankings.sort(new Comparator<Player>() {
            @Override
            public int compare(Player o1, Player o2) {
                //Sử dụng toán tử 3 ngôi
                return o2.getAccountBalance() - o1.getAccountBalance() > 0 ? 1 : -1;
            }
        });
        return playersRankings;
    }

    // Tìm kiếm danh sách người chơi theo email
    public List<Player> findPlayersByEmail(String emailFind) {
        List<Player> rs = new ArrayList<>();
        for (Player p : playerRepository.findAll()) {
            if (p.getEmail().toLowerCase().contains(emailFind.toLowerCase())) {
                rs.add(p);
            }
        }
        return rs;
    }
}
