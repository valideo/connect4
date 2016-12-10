package connect4;

/**
 * Created by Valentin on 25/11/2016.
 */
public class GameLogic{

    private int width;
    private int height;

    public int lastRow = -1;
    public int lastColumn = -1;

    public GameLogic(int width, int height) {

        this.width = width;
        this.height = height;
    }

    public boolean hasWinningCombination(char[][] board) {

        if (lastColumn == -1) {
            return false;//No moves has been made
        }

        char pawn = board[lastRow][lastColumn];
        String winningCombination = String.format("%c%c%c%c", pawn, pawn, pawn, pawn);

        return getRow(board).contains(winningCombination) ||
                getColumn(board).contains(winningCombination) ||
                getDiagonal(board).contains(winningCombination) ||
                getOppositeDiagonal(board).contains(winningCombination);
    }

    private String getRow(char[][] board) {
        return new String(board[lastRow]);
    }

    private String getColumn(char[][] board) {

        StringBuilder column = new StringBuilder(height);
        for (int i = 0; i < height; i++) {
            column.append(board[i][lastColumn]);
        }
        return column.toString();
    }

    private String getDiagonal(char[][] board) {

        StringBuilder diagonal = new StringBuilder(height);
        for (int i = 0; i < height; i++) {
            int j = (lastColumn + lastRow) - i;
            if (0 <= j && j < width) {
                diagonal.append(board[i][j]);
            }
        }
        return diagonal.toString();
    }

    private String getOppositeDiagonal(char[][] board) {

        StringBuilder backDiagonal = new StringBuilder(height);
        for (int i = 0; i < height; i++) {
            int j = (lastColumn - lastRow) + i;
            if (0 <= j && j < width) {
                backDiagonal.append(board[i][j]);
            }
        }
        return backDiagonal.toString();
    }

}
