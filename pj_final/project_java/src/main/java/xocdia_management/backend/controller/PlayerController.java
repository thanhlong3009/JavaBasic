package xocdia_management.backend.controller;

import xocdia_management.backend.model.Player;
import xocdia_management.backend.request.LoginRequest;
import xocdia_management.backend.service.PlayerService;
import xocdia_management.frontend.PlayerPage;

import java.util.List;

public class PlayerController {
    private static final PlayerService playerService = new PlayerService();
    public boolean checkLogin(LoginRequest loginRequest) {
        return playerService.checkLogin(loginRequest);
    }
    public Player findPlayerByEmail(String email) {
       return playerService.findPlayerByEmail(email);
    }

    public List<Player> getPlayers() {
        return playerService.getPlayers();
    }

    public void deletePlayers(String userName) {
        playerService.deletePlayers(userName);
    }
}
