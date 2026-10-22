
package com.esports.esportsscoreboard.model;

public class Team {

    private String name;
    private int matches;
    private int wwcd;
    private int placementPoints;
    private int eliminations;
    private int total;

    public Team(String name) {
         this.name = name;
    }

    public Team(String name, int matches, int wwcd,
                int placementPoints, int eliminations, int total) {
        this.name = name;
        this.matches = matches;
        this.wwcd = wwcd;
        this.placementPoints = placementPoints;
        this.eliminations = eliminations;
        this.total = total;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMatches() {
        return matches;
    }

    public void setMatches(int matches) {
        this.matches = matches;
    }

    public int getWwcd() {
        return wwcd;
    }

    public void setWwcd(int wwcd) {
        this.wwcd = wwcd;
    }

    public int getPlacementPoints() {
        return placementPoints;
    }

    public void setPlacementPoints(int placementPoints) {
        this.placementPoints = placementPoints;
    }

    public int getEliminations() {
        return eliminations;
    }

    public void setEliminations(int eliminations) {
        this.eliminations = eliminations;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}