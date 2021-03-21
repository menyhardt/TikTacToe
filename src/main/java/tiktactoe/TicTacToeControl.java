package tiktactoe;

import tiktactoe.event.TicTacToeEvent;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToeControl {

    private TicTacToeEvent event;

    private int counter = 1;

    private TicTacToeEvent.Player curPlayer = TicTacToeEvent.Player.X;

    public TicTacToeControl() {
        this.event = new TicTacToeEvent();
    }

    public TicTacToeControl(final TicTacToeEvent event) {
        this.event = event;
    }



    public void start() throws InterruptedException {

            System.out.println(
                    "X will play first. Enter row column coordinates [11,12 ...] to place X in:");
            do {
                try {
                    System.out.println("Player " + curPlayer + ":");
                    event.play(getInput());
                    curPlayer = (TicTacToeEvent.Player.X.equals(curPlayer))?TicTacToeEvent.Player.O:TicTacToeEvent.Player.X;

                } catch (InputMismatchException e) {
                    printError();
                    continue;
                }
                if (counter % 2 == 0) {
                    System.out.println("Working 2s");
                    Thread.sleep(2000);
                }
                counter++;
            } while (event.checkWinner());
            printOutput();
        }

        private static String getInput() {
            Scanner in = new Scanner(System.in);
            return in.next();

        }
        private static void printError() {
            System.out.println("Invalid input: re-enter coordinates:");
        }

        public void printOutput() {

            if (event.getCurPlayer() != null) {
                System.out.println(String.format("PLAYER %s WON!", event.getCurPlayer()));
            } else {
                System.out.println("GAME ENDS WITH A DRAW!");
            }
        }
}
