package xocdia_management.backend.service;

import xocdia_management.backend.model.Player;
import xocdia_management.backend.repository.PlayerRepository;
import xocdia_management.backend.request.LoginRequest;

import java.util.List;
import java.util.regex.Pattern;

public class PlayerService {
    private  final PlayerRepository playerRepository = new PlayerRepository();

    List<Player> players = playerRepository.findAll();

    public List<Player> getPlayers() {
        return playerRepository.findAll();
    }

    public boolean checkLogin(LoginRequest loginRequest) {
        for (Player p: players) {
            if (p.getEmail().equals(loginRequest.getEmail()) && p.getPassword().equals(loginRequest.getPassword())) {
                return true;
            }
        }
        return false;
    }

    public Player findPlayerByEmail(String email) {
        Player player = new Player();
        for (Player p: getPlayers()) {
            if (p.getEmail().equals(email)){
                player = p;
            }
        }
        return player;
    }



    public boolean checkEmailExist(String email){
        for (Player p:players) {
            if(p.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkPassword(String password) {
        String PASSWORD_PATTERN = "[a-z A-Z0-9]{7,15}$";
        return Pattern.matches(PASSWORD_PATTERN, password);
    }

    public void deletePlayers(String userName) {
        Player player = playerRepository.findPlayerByUserName(userName);
        playerRepository.deletePlayers(player);
    }
}
