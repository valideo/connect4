package connect4;

/**
 * Created by macsound on 24/11/2016.
 */

import java.io.Console;
import java.util.Arrays;
import java.util.Scanner;

public class Connect4Board {

    private final int width;
    private final int height;
    private final char emptyCell = '-';
    private Colors colors = new Colors();
    private static Messages messages = new Messages();

    public GameLogic gameLogic;
    public int playerIndex = 0;
    public int remainingTurns = 6 * 7;
    public final char[][] board;

    public Connect4Board(int width, int height) {

        this.width = width;
        this.height = height;
        board = new char[height][];
        generateBoard(board);
        gameLogic = new GameLogic(width,height);
    }

    private void generateBoard(char[][] board){

        for (int i = 0; i < height; i++) {
            Arrays.fill(board[i] = new char[width], emptyCell);
        }
    }

    @Override
    public String toString() {

        StringBuilder cell = new StringBuilder();
        for (int j = 0; j < height; j++) {
            for (int i = 0; i < width; i++) {
                cell.append(board[j][i]);
                cell.append(" ");
            }
            cell.append("\n");
        }
        return cell.toString();
    }


    public void playAndCheckRules(Player player, Scanner input) {

        messages.showInstruction(player);

        int column = (input.nextInt() - 1);
        try {
            checkEntry(column, player);

        } catch (GameException e) {

            messages.showWrongNumberMessage(column, width);
        }
    }


    private void placePawn(int column, Player player) {

        for (int i = height - 1; i >= 0; i--) {
            if (board[i][column] == emptyCell) {
                char[] charPlayed = player.playerPawn.toCharArray();
                board[gameLogic.lastRow = i][gameLogic.lastColumn = column] = Character.toUpperCase(charPlayed[0]);
                return;
            }

        }
        messages.showFullColumnMessage(column);
    }

    private void checkEntry (int column, Player player) throws GameException {

        if (column < 0 || column >= width) {
            playerIndex = 0;
            throw new GameException();
        }
        else {
            placePawn(column,player);
        }
    }
}
