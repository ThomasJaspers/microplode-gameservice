package de.codecentric.microplode.domain;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Player> players = new ArrayList<Player>();
    private int round;
    private boolean started;
    private boolean gameOver;
   
    public List<Player> getPlayers() {
        return players;
    }
    public void setPlayers(List<Player> players) {
        this.players = players;
    }
    public int getRound() {
        return round;
    }
    public void setRound(int round) {
        this.round = round;
    }
    public boolean isGameOver() {
        return gameOver;
    }
    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }
    public boolean isStarted() {
        return started;
    }
    public void setStarted(boolean started) {
        this.started = started;
    }
}
