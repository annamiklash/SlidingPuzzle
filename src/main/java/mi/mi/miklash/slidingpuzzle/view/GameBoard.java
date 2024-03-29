package mi.mi.miklash.slidingpuzzle.view;


import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import lombok.Getter;
import mi.mi.miklash.slidingpuzzle.controller.GameController;
import mi.mi.miklash.slidingpuzzle.generator.GridGenerator;
import mi.mi.miklash.slidingpuzzle.model.Node;

import java.util.List;

import static mi.mi.miklash.slidingpuzzle.common.Constants.COLUMN_NUMBER;

@Getter
public class GameBoard {

    private final GridPane gridPane;
    private final GameController gameController;


    public GameBoard() {
        this.gridPane = new GridPane();

        this.gameController = new GameController(this);

        initGridPane();

    }


    private void initGridPane() {
        gridPane.setPrefSize(800, 800);
        gridPane.setAlignment(Pos.CENTER);

        //Setting the vertical and horizontal gaps between the columns
        gridPane.setVgap(5);
        gridPane.setHgap(5);

    }

    public void initializeNodesLocation(List<Node> nodeList) {
        GridGenerator.generateGrid(gridPane, nodeList,  COLUMN_NUMBER);
    }

//    public void initializeMovesCounterLocation (Text movesCounter) {
//        GridGenerator.locateClickNumberTextBox(this, movesCounter);
//    }

}
