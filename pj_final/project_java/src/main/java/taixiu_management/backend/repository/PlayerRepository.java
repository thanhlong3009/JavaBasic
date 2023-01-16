package taixiu_management.backend.repository;

import taixiu_management.backend.database.PlayerDB;
import taixiu_management.backend.exception.NotFoundException;
import taixiu_management.backend.model.Player;
import taixiu_management.backend.utlis.FileUtils;

import java.util.List;

public class PlayerRepository {

    // Lấy ra danh sách người chơi từ DB
    public List<Player> findAll() {
        return PlayerDB.players;
    }

    // update thông tin người chơi
    public void updateFiles() {
        FileUtils.setDataToFileP("players.json" , findAll());
    }

    // Tìm kiếm người chơi theo username
    public Player findPlayerByUserName(String userName) {
        for (Player p :PlayerDB.players) {
            if (p.getUserName().equals(userName)) {
                return p;
            }
        }
        throw new NotFoundException("Không tìm thấy người chơi");
    }

    // Xóa người chơi
    public void deletePlayers(Player player) {
        PlayerDB.players.remove(player);
        FileUtils.setDataToFileP("players.json" , PlayerDB.players);
    }


}
