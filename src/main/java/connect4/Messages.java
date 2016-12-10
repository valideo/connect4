package connect4;

import java.util.List;

/**
 * Created by val on 10/12/2016.
 */
public class Messages {
    private Colors colors = new Colors();

    public void showWinner(List<Player> players, Connect4Board board){
        System.out.println("\n" + players.get(board.playerIndex).color + players.get(board.playerIndex).name + " has won!" + colors.black);
    }

    public void showNoWinner(){
        System.out.println("\n" + colors.red + "Game over, nobody has won." + colors.black);
    }

    public void welcomeMessage(){
        System.out.println("\nWelcome to Connect 4 Game! :)");
    }

    public void introducePlayers(List<Player> players){

        System.out.println( "\n" + players.get(0).name + " affronte " + players.get(1).name);
    }

    public void enterPlayerName(int index){
        System.out.println("\nEnter player " + (index + 1) + " name :");
    }

    public void showInstruction(Player player){

        System.out.println("\nEnter a number between 1 and 7 for choosing a column.");
        System.out.println("\n" + player.color + player.name + " turn: " + colors.black);
    }

    public void showWrongNumberMessage(int column, int width) {
        if (column < 0 && column != -2) {
            System.out.println("\n" + colors.red + (column + 1) + " is lesser than " + 1 + ". Please enter a number between 1 and " + (width) + colors.black);
        }

        if (column >= width) {
            System.out.println("\n" + colors.red + (column + 1) + " is greater than " + width + ". Please enter a number between 1 and " + (width) + colors.black);
        }

        if (column == -2) {
            System.out.println("\n" + colors.red + "You cannot enter letters. Please try again with a number" + colors.black);
        }
    }

    public void showFullColumnMessage(int column){
        System.out.println("\n" + colors.red + " Column " + column + " is full." + colors.black);
    }

}


