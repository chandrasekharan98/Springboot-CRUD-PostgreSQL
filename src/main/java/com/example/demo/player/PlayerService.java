package com.example.demo.player;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PlayerService {

    private List<Player> players = new ArrayList<>(Arrays.asList(new Player("P1","Lionel Messi", "Argentina"),
            new Player("P2","Sergio Aguero", "Argentina"),
            new Player("P3","Marcus Rashford", "England"),
            new Player("P4","Mesut Ozil", "Germany")
    ));

    public List<Player> getAllPlayers() {
        return this.players;
    }

    public Player getPlayer(String id) {
        for(int i = 0; i < players.size(); i++) {
            if(players.get(i).getId().equals(id))
                return players.get(i);
        }
        return new Player("null","null","null");
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void updatePlayer(String id, Player player) {
        for(int i = 0; i < players.size(); i++) {
            if(players.get(i).getId().equals(id))
                players.set(i,player);
                return;
        }
    }

    public void deletePlayer(String id) {
 //       players.removeIf(t -> t.getId().equals(id));
        for(int i = 0; i < players.size(); i++) {
            if(players.get(i).getId().equals(id))
                players.remove(i);
        }
    }
}
