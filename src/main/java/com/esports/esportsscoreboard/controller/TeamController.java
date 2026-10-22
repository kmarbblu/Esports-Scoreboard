package com.esports.esportsscoreboard.controller;

import com.esports.esportsscoreboard.model.Team;
import com.esports.esportsscoreboard.model.Player;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/teams")
@CrossOrigin
public class TeamController {

    private final List<Team> teams = new ArrayList<>();

    private final PlayerController playerController;

    // Constructor
    public TeamController(PlayerController playerController) {
        this.playerController = playerController;
        createTeams();
    }

    // ==========================================
    // CREATE 16 TEAMS
    // ==========================================

    private void createTeams() {

        teams.clear();

        for (int i = 1; i <= 16; i++) {
            teams.add(new Team("T" + i));
        }
    }

    // ==========================================
    // CREATE NEW MATCH
    // ==========================================

    @PostMapping("/create-match")
    public String createMatch() {

        createTeams();

        return "16 teams created successfully";
    }

    // ==========================================
    // GET SCOREBOARD
    // ==========================================

    @GetMapping
    public List<Team> getTeams() {

        List<Player> players = playerController.getPlayers();

        // Reset team statistics
        for (Team team : teams) {

            team.setMatches(0);
            team.setWwcd(0);
            team.setPlacementPoints(0);
            team.setEliminations(0);
            team.setTotal(0);
        }

        // Calculate player kills for each team
        for (Player player : players) {

            String teamName = player.getTeam();

            for (Team team : teams) {

                if (team.getName().equals(teamName)) {

                    team.setEliminations(
                        team.getEliminations() + player.getKills()
                    );

                    break;
                }
            }
        }

        // Total = Placement Points + Eliminations
        for (Team team : teams) {

            team.setTotal(
                team.getPlacementPoints()
                + team.getEliminations()
            );
        }

        // Sort highest total first
        teams.sort(
            (a, b) -> Integer.compare(
                b.getTotal(),
                a.getTotal()
            )
        );

        return teams;
    }

    // ==========================================
    // DELETE ALL TEAMS
    // ==========================================

    @DeleteMapping
    public String deleteAllTeams() {

        teams.clear();

        return "All teams deleted";
    }
}