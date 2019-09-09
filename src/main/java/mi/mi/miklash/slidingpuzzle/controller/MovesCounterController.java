package mi.mi.miklash.slidingpuzzle.controller;

import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class MovesCounterController {

    private Text movesCounterTextBox;
    private int movesCounter;

    public MovesCounterController() {
        movesCounter = 0;
        initTextBox();
        movesCounterTextBox.setFont(new Font(15));
    }

    private void initTextBox() {
        movesCounterTextBox = new Text("Moves counter: " + movesCounter);
        movesCounterTextBox.setFont(new Font(12));
    }

    public void incrementMovesCounter() {
        movesCounter++;
        movesCounterTextBox.setText("Moves counter: " + movesCounter);
    }

    public Text getMovesCounterTextBox() {
        return movesCounterTextBox;
    }

    public int getMovesCounter() {
        return movesCounter;
    }
}
