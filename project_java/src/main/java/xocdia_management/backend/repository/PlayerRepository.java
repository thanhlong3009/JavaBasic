package xocdia_management.backend.repository;

import xocdia_management.backend.database.PlayerDB;
import xocdia_management.backend.exception.NotFoundException;
import xocdia_management.backend.model.Player;
import xocdia_management.backend.utlis.FileUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PlayerRepository {
    public List<Player> findAll() {
        return PlayerDB.players;
    }

    public void updateFiles(ArrayList<Player> players) {
        FileUtils.setDataToFileP("players.json" , players);
    }

    public Player findPlayerByUserName(String userName) {
        for (Player p :PlayerDB.players) {
            if (p.getUserName().equals(userName)) {
                return p;
            }
        }
        throw new NotFoundException("Không tìm thấy người chơi");
    }

    public void deletePlayers(Player player) {
        PlayerDB.players.remove(player);
        FileUtils.setDataToFileP("players.json" , PlayerDB.players);
    }


}
