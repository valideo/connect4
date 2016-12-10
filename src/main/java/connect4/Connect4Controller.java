package connect4;

import sun.plugin2.message.Message;

import java.util.*;

/**
 * Created by macsound on 24/11/2016.
 */

public class Connect4Controller {

    private static Scanner input = new Scanner(System.in);
    private static List<Player> players = new ArrayList<>();
    private static enum PawnType { X, O }
    private static Colors colors = new Colors();
    private static Messages messages = new Messages();

    public static String read() {
        if (input.hasNext()) {
            return input.next();
        }
        else {
            input.next();
            return "no input";
        }
    }


    private static void play() {

        Connect4Board connect4Board = createGame();

         do {
             String playerChar = players.get(connect4Board.playerIndex).playerPawn;
             connect4Board.playAndCheckRules(players.get(connect4Board.playerIndex), input);
             System.out.println(connect4Board);

             if (connect4Board.gameLogic.hasWinningCombination(connect4Board.board)) {
                 messages.showWinner(players, connect4Board);
                 return;
             }
             connect4Board.playerIndex = 1 - connect4Board.playerIndex;
             --connect4Board.remainingTurns;

             if (connect4Board.remainingTurns == 0) { break; } //Game is over

         } while (true);

         messages.showNoWinner();
     }

    private static Connect4Board createGame() {

        messages.welcomeMessage();
        messages.introducePlayers(players);
        Connect4Board board = new Connect4Board(7,6);
        System.out.println("\n" + board);
        return board;
    }

    public static void createPlayers() {

        for (int i = 0; i < 2; i++) {

            messages.enterPlayerName(i);
            String name = read();
            String pawn = "";
            String color = "";

            if (i == 1) {
                color = colors.blue;
                pawn = PawnType.X.toString();
            }
            else {
                color = colors.green;
                pawn = PawnType.O.toString();
            }

            Player player = new Player(name, pawn, color);
            players.add(player);

        }
    }

    public static void main(String[] args) {

        createPlayers();
        play();

    }

}