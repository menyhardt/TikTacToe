package tiktactoe;

import tiktactoe.event.TicTacToeEvent;

import java.io.IOException;

public class Main {

    private static TicTacToeEvent event;

    private static int counter = 0;

    public static void main(String[] args) throws InterruptedException, IOException {

        TicTacToeControl ticTakToeControl = new TicTacToeControl();
        ticTakToeControl.start();

    }


}
