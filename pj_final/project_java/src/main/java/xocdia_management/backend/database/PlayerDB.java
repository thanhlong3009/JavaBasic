package xocdia_management.backend.database;

import xocdia_management.backend.model.Player;
import xocdia_management.backend.utlis.FileUtils;

import java.util.List;

public class PlayerDB {
    public static List<Player> players = FileUtils.getDataFromFileP("players.json");
}
