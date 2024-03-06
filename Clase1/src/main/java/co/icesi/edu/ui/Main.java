package co.icesi.edu.ui;

import co.icesi.edu.board.Board;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {
        Board board = new Board(3, 4);
        board.printBoard();
        board.movePlayer(board.getPlayer1(), board.randomNumber());
        board.printBoard();
        board.movePlayer(board.getPlayer2(), board.randomNumber());
        board.printBoard();

    }
}