package co.icesi.edu.board;

public class Board {

    private Square firstSquare;
    private Player player1;
    private Player player2;

    private int row;
    private int column;

    public Board(int row, int column) {
        this.row = row;
        this.column = column;
        player1 = new Player("Player 1");
        player2 = new Player("Player 2");
        for (int i = 0; i < row * column; i++) {
            addSquare(i + 1);
        }
        firstSquare.setPlayer(player1);
        firstSquare.setPlayer(player2);
    }

    public void addSquare(int number) {
        if (firstSquare == null) {
            firstSquare = new Square(number);
            return;
        }
        Square current = firstSquare;
        while (current.getNextSquare() != null) {
            current = current.getNextSquare();
        }
        current.setNextSquare(new Square(number));
    }

    public void printBoard() {
        Square current = firstSquare;
        String toString = "";
        int count = 1;
        while (current != null) {
            toString += "[" + current.toString() + "] " + (count % column == 0 ? "\n" : "");
            current = current.getNextSquare();
            count++;
        }
        System.out.println(toString);
    }

    public void movePlayer(Player player, int steps) {
        Square current = firstSquare;
        while (current != null) {
            if (current.isPlayer(player)) {
                break;
            }
        }
        for (int i = 0; i < steps; i++) {
            current.movePlayer(player);
            current = current.getNextSquare();
        }
    }

    public int randomNumber() {
        return (int) (Math.random() * 6) + 1;
    }

    public void moveP1(int steps) {
        movePlayer(player1, steps);
    }

    public void moveP2(int steps) {
        movePlayer(player2, steps);
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }
}
