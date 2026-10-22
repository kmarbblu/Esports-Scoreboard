package com.esports.esportsscoreboard.model;

public class GameEvent {

    private String time;
    private String attacker;
    private String victim;
    private String type;

    public GameEvent() {
    }

    public GameEvent(String time, String attacker, String victim, String type) {
        this.time = time;
        this.attacker = attacker;
        this.victim = victim;
        this.type = type;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAttacker() {
        return attacker;
    }

    public void setAttacker(String attacker) {
        this.attacker = attacker;
    }

    public String getVictim() {
        return victim;
    }

    public void setVictim(String victim) {
        this.victim = victim;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}