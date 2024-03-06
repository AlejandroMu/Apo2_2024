package co.icesi.edu.board;

public class Square {
    private int number;
    private Square nextSquare;
    private Player player1;
    private Player player2;

    public Square(int number) {
        this.number = number;
    }

    public void setNextSquare(Square nextSquare) {
        this.nextSquare = nextSquare;
    }

    public Square getNextSquare() {
        return nextSquare;
    }

    public void setPlayer(Player player1) {
        if (this.player1 == null) {
            this.player1 = player1;
        } else if (this.player2 == null) {
            this.player2 = player1;
        }
    }

    public int getNumber() {
        return number;
    }

    public String toString() {
        if (player1 != null && player2 != null) {
            return "P1-P2";
        } else if (player1 != null) {
            return "P1";
        } else if (player2 != null) {
            return "P2";
        }
        return "" + number;
    }

    public boolean isPlayer(Player p) {
        return player1.compareTo(p) == 0 || player2.compareTo(p) == 0;
    }

    public void movePlayer(Player player) {
        if (player1.compareTo(player) == 0) {
            player1 = null;
            nextSquare.setPlayer(player);
        } else if (player2.compareTo(player) == 0) {
            player2 = null;
            nextSquare.setPlayer(player);
        }
    }
}
