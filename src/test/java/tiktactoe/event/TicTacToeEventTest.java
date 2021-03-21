package tiktactoe.event;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tiktactoe.TicTacToeControl;

import static org.mockito.Mockito.*;

class TicTacToeEventTest {


    /*round1 = {{" ", "1", "2", "3"},
            {"1", "X", " ", " "},
            {"2", "X", "O", " "},
            {"3", "X", "O", " "}};*/

    /*round2 = {{" ", "1", "2", "3"},
            {"1", "X", " ", "X"},
            {"2", "O", "O", "O"},
            {"3", "X", " ", " "}};*/

    /*round3 = {{" ", "1", "2", "3"},
            {"1", "X", " ", " "},
            {"2", "O", "X", " "},
            {"3", "O", " ", "X"}};*/

    /*round4 = {{" ", "1", "2", "3"},
            {"1", "X", "O", "X"},
            {"2", "O", "O", "X"},
            {"3", "X", "X", "O"}};*/


    @Test
    public void Round1() throws InterruptedException {
        TicTacToeEvent event = spy(new TicTacToeEvent());
        event.play("11");
        event.play("22");
        event.play("21");
        event.play("32");
        event.play("31");
        TicTacToeControl ticTacToeControl = new TicTacToeControl(event);
        ticTacToeControl.printOutput();
        Assertions.assertTrue(TicTacToeEvent.Player.X.equals(event.getCurPlayer()) && !event.checkWinner());
    }

  @Test
    public void Round2() throws InterruptedException {
      TicTacToeEvent event = spy(new TicTacToeEvent());
      event.play("11");
      event.play("21");
      event.play("13");
      event.play("22");
      event.play("31");
      event.play("23");
      TicTacToeControl ticTacToeControl = new TicTacToeControl(event);
      ticTacToeControl.printOutput();
      Assertions.assertTrue(TicTacToeEvent.Player.O.equals(event.getCurPlayer()) && !event.checkWinner());

    }

    @Test
    public void Round3() throws InterruptedException {
        TicTacToeEvent event = spy(new TicTacToeEvent());
        event.play("11");
        event.play("21");
        event.play("22");
        event.play("31");
        event.play("33");
        TicTacToeControl ticTacToeControl = new TicTacToeControl(event);
        ticTacToeControl.printOutput();
        Assertions.assertTrue(TicTacToeEvent.Player.X.equals(event.getCurPlayer()) && !event.checkWinner());

    }

    @Test
    public void Round4() throws InterruptedException {
        TicTacToeEvent event = spy(new TicTacToeEvent());
        event.play("11");
        event.play("12");
        event.play("13");
        event.play("21");
        event.play("22");
        event.play("23");
        event.play("31");
        event.play("32");
        event.play("33");
        Assertions.assertTrue( !event.checkWinner() && event.getCurPlayer() == null);
        TicTacToeControl ticTacToeControl = new TicTacToeControl(event);
        ticTacToeControl.printOutput();

    }
}
