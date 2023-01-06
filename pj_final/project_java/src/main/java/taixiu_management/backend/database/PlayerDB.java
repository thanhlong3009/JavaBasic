package taixiu_management.backend.database;

import taixiu_management.backend.model.Player;
import taixiu_management.backend.utlis.FileUtils;

import java.util.List;

public class PlayerDB {
    public static List<Player> players = FileUtils.getDataFromFileP("players.json");
}
