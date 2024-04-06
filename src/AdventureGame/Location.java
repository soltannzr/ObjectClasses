package AdventureGame;

import java.util.Scanner;

public abstract class Location {

    private String name;
    private boolean isCompleted = false;
    Player player;
    public static Scanner sc = new Scanner(System.in);

    public Location(Player player, String name){
        this.player = player;
        this.name = name;
    }

    public abstract boolean onLocation();

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }
}