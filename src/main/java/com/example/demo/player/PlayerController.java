package com.example.demo.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/V1")
public class PlayerController {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private PlayerService playerService;

    @RequestMapping(value = "/players", method =  RequestMethod.GET, produces = "application/json")
    public List<Player> getAllPlayers() {
        //return playerService.getAllPlayers();
        List<Player> players = new ArrayList<>();
        playerRepository.findAll().forEach(players::add);
        return players;
    }

    @RequestMapping(value = "/players/{id}", method = RequestMethod.GET, produces = "application/json")
    public Optional<Player> getPlayer(@PathVariable String id) {
        //return playerService.getPlayer(id);
        return playerRepository.findById(id);
    }

    @RequestMapping(value = "/players", method = RequestMethod.POST, consumes = "application/json")
    public void addPlayer(@RequestBody Player player) {
        //playerService.addPlayer(player);
        playerRepository.save(player);
    }

    @RequestMapping(value = "/players/{id}", method =  RequestMethod.PUT, consumes = "application/json")
    public void updatePlayer(@PathVariable String id, @RequestBody Player player) {
       // playerService.updatePlayer(id,player);
        playerRepository.save(player);
    }

    @RequestMapping(value = "/players/{id}", method = RequestMethod.DELETE, consumes = "application/json")
    public void deletePlayer(@PathVariable String id) {
       // playerService.deletePlayer(id);
        playerRepository.deleteById(id);
    }



}
