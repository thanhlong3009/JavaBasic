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
    
    public void deletePlayers(Player player) {
        PlayerDB.players.remove(player);
        FileUtils.setDataToFileP("players.json" , PlayerDB.players);
    }


}
