package mi.mi.miklash.slidingpuzzle.generator;

import javafx.scene.layout.GridPane;
import mi.mi.miklash.slidingpuzzle.model.Node;

import java.util.List;

public class GridGenerator {


    public static void generateGrid(GridPane gridPane, List<Node> nodeList, int columnNumber) {
        for (int count = 0, i = 1, j = 0; count < nodeList.size(); count++) {
            if (j == columnNumber) {
                j = 0;
                i++;
            }

            gridPane.add(nodeList.get(count), j, i);
            j++;
            System.out.println("Adding node " + count + " to grid pane");

        }
    }
}
