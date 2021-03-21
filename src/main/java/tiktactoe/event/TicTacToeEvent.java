package tiktactoe.event;

import tiktactoe.viewer.BoardView;

import java.util.*;

public class TicTacToeEvent {


    private int[] playerXrow = {0, 0, 0};
    private int[] playerOrow = {0, 0, 0};
    private int[] playerOcol = {0, 0, 0};
    private int[] playerXcol = {0, 0, 0};
    private int counter = 0;
    private Player curPlayer;

    public enum Player {X, O}

    ;

    private String[][] boardPlan = {{" ", "1", "2", "3"},
            {"1", " ", " ", " "},
            {"2", " ", " ", " "},
            {"3", " ", " ", " "}};

    public TicTacToeEvent() {
        BoardView.printBoard(boardPlan);
    }

    public void play(String input) throws InterruptedException {
        this.boardPlan = boardPlan;


        if (input.isEmpty() || input.length() != 2) {
            throw new InputMismatchException();
        } else {
            Integer row = Integer.valueOf(input.substring(0, 1));
            Integer col = Integer.valueOf(input.substring(1));
            if (row > 3 || col > 3) {
                throw new InputMismatchException();
            }

            if (!boardPlan[row][col].trim().isEmpty()) {
                throw new InputMismatchException();
            }
            curPlayer = (curPlayer == null || curPlayer.equals(Player.O)) ? Player.X : Player.O;
            System.out.println("Player " + curPlayer + ":");

            boardPlan[row][col] = curPlayer.name();
            switch (curPlayer) {
                case X:
                    playerXrow[row - 1] = playerXrow[row - 1] + 1;
                    playerXcol[col - 1] = playerXcol[col - 1] + 1;
                    break;
                case O:
                    playerOrow[row - 1] = playerOrow[row - 1] + 1;
                    playerOcol[col - 1] = playerOcol[col - 1] + 1;
                    break;
            }
            BoardView.printBoard(boardPlan);
            counter++;

        }


    }

    public boolean checkWinner() {

        if (Arrays.stream(playerXrow).anyMatch(val -> val == 3) || Arrays.stream(playerXcol)
                                                                         .anyMatch(val -> val == 3)) {
            return false;
        }

        if (Arrays.stream(playerOrow).anyMatch(val -> val == 3) || Arrays.stream(playerOcol)
                                                                         .anyMatch(val -> val == 3)) {
            return false;
        }
        int[] diagonal = {1, 1, 1};
        if (Arrays.equals(playerXrow, diagonal) || Arrays.equals(playerOrow, diagonal)) {
            String checkDiag = boardPlan[1][1] + boardPlan[2][2] + boardPlan[3][3];
            String checkOpositeDiag = boardPlan[1][3] + boardPlan[2][2] + boardPlan[3][1];
            if (checkDiag.equals("XXX") || checkOpositeDiag.equals("XXX")) {
                return false;
            }
            if (checkDiag.equals("OOO") || checkOpositeDiag.equals("OOO")) {
                return false;
            }
        }

        if (counter == 9) {
            curPlayer = null;
            return false;
        }
        return true;

    }


    public Player getCurPlayer() {
        return this.curPlayer;
    }


}
