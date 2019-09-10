package mi.mi.miklash.slidingpuzzle.generator;


import javafx.scene.image.Image;
import mi.mi.miklash.slidingpuzzle.controller.GameController;
import mi.mi.miklash.slidingpuzzle.listener.MouseEnteredListener;
import mi.mi.miklash.slidingpuzzle.listener.MouseExitedListener;
import mi.mi.miklash.slidingpuzzle.listener.MousePressedListener;
import mi.mi.miklash.slidingpuzzle.model.Node;
import mi.mi.miklash.slidingpuzzle.util.ImageUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static mi.mi.miklash.slidingpuzzle.common.Constants.COLUMN_NUMBER;


public class NodeGenerator {

    public static List<Node> generateShuffledNodeList(GameController gameController) {
        final List<Image> customImageList = ImageUtil.readImageList(COLUMN_NUMBER);

        final List<Node> nodeList = new ArrayList<>();
        for (int i = 0; i < customImageList.size(); i++) {
            nodeList.add(createNode(customImageList, i, gameController));
            System.out.println("Adding node " + i);
        }

        Collections.shuffle(customImageList);

        return nodeList;
    }

    private static Node createNode(List<Image> customImageList, int nodeNumber, GameController gameController) {
        final Node node = new Node(customImageList.get(nodeNumber), nodeNumber);
        final MousePressedListener mousePressedListener = new MousePressedListener(gameController, node);
        final MouseEnteredListener mouseEnteredListener = new MouseEnteredListener(gameController, node);
        final MouseExitedListener mouseExitedListener = new MouseExitedListener(gameController, node);

        node.setOnMousePressed(mousePressedListener);
//        node.setOnMouseEntered(mouseEnteredListener);
//        node.setOnMousePressed(mouseExitedListener);


        return node;
    }

}
