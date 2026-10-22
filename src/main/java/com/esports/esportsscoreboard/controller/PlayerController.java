package com.esports.esportsscoreboard.controller;

import com.esports.esportsscoreboard.model.Player;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/players")
@CrossOrigin
public class PlayerController {

    private final List<Player> players = new ArrayList<>();

    // ==========================================
    // CREATE 64 PLAYERS
    // ==========================================

    @PostMapping("/create-players")
    public String createPlayers() {

        players.clear();

        for (int team = 1; team <= 16; team++) {

            for (int player = 1; player <= 4; player++) {

                players.add(
                    new Player(
                        "T" + team + "-P" + player,
                        "T" + team
                    )
                );
            }
        }

        return "64 players created successfully";
    }


    // ==========================================
    // GET ALL PLAYERS
    // ==========================================

    @GetMapping
    public List<Player> getPlayers() {

        return players;
    }


    // ==========================================
    // UPDATE PLAYER STATISTICS
    // ==========================================

    @PutMapping("/{name}")
    public String updatePlayer(
            @PathVariable String name,
            @RequestBody Player updatedPlayer) {

        for (Player player : players) {

            if (player.getName().equals(name)) {

                player.setKills(updatedPlayer.getKills());
                player.setHeadshots(updatedPlayer.getHeadshots());
                player.setDamage(updatedPlayer.getDamage());
                player.setAssists(updatedPlayer.getAssists());

                return "Player updated successfully";
            }
        }

        return "Player not found";
    }


    // ==========================================
    // KILL / REVIVE PLAYER
    // ==========================================

    @PutMapping("/{name}/toggle")
    public String togglePlayer(@PathVariable String name) {

        for (Player player : players) {

            if (player.getName().equals(name)) {

                player.setAlive(!player.isAlive());

                if (player.isAlive()) {
                    return player.getName() + " is ALIVE";
                } else {
                    return player.getName() + " is DEAD";
                }
            }
        }

        return "Player not found";
    }


    // ==========================================
    // DELETE ALL PLAYERS
    // ==========================================

    @DeleteMapping
    public String deleteAllPlayers() {

        players.clear();

        return "All players deleted";
    }
}