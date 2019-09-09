package mi.mi.miklash.slidingpuzzle.view;


import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import lombok.Getter;
import mi.mi.miklash.slidingpuzzle.controller.GameController;
import mi.mi.miklash.slidingpuzzle.generator.GridGenerator;
import mi.mi.miklash.slidingpuzzle.generator.NodeGenerator;
import mi.mi.miklash.slidingpuzzle.model.Node;

import java.util.List;

@Getter
public class GameBoard {

    private final GridPane gridPane;
    private final GameController gameController;
    private final List<Node> nodeList;

    public GameBoard() {
        this.gridPane = new GridPane();
        this.gameController = new GameController();
        this.nodeList = NodeGenerator.generateShuffledNodeList(gameController);
        initGridPane();
        initializeNodesLocation();
    }


    private void initGridPane() {
        gridPane.setPrefSize(800, 800);
        gridPane.setAlignment(Pos.CENTER);

        //Setting the vertical and horizontal gaps between the columns
        gridPane.setVgap(5);
        gridPane.setHgap(5);

    }

    private void initializeNodesLocation() {
        GridGenerator.generateGrid(gridPane, nodeList,  4);
    }

//    public void initializeMovesCounterLocation (Text movesCounter) {
//        GridGenerator.locateClickNumberTextBox(this, movesCounter);
//    }

}
