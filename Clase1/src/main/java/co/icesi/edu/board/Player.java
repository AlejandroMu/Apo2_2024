package co.icesi.edu.board;

public class Player implements Comparable<Player> {
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Player o) {
        return name.compareTo(o.getName());
    }
}