package mi.mi.miklash.slidingpuzzle.controller;

import mi.mi.miklash.slidingpuzzle.generator.NodeGenerator;
import mi.mi.miklash.slidingpuzzle.initializer.PositionMapInitializer;
import mi.mi.miklash.slidingpuzzle.model.IndexedImage;
import mi.mi.miklash.slidingpuzzle.model.Node;
import mi.mi.miklash.slidingpuzzle.model.SelectionEnum;
import mi.mi.miklash.slidingpuzzle.view.GameBoard;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static mi.mi.miklash.slidingpuzzle.model.SelectionEnum.*;

public class GameController {

    private List<Node> nodeList;
    private GameBoard gameBoard;


    public GameController(GameBoard gameBoard) {
        this.gameBoard = gameBoard;

        initGame();

    }

    public void handleSelection(Node selectedNode) throws MalformedURLException, FileNotFoundException {

        final SelectionEnum selectionType = getSelectionType(selectedNode);

        System.out.println(selectionType);

        selectedNode.setSelected();

        if (selectionType.equals(SELECTED_SAME_NODE)) {
            return;
        }

        if (selectionType.equals(ONE_NODE_SELECTED)) {
            Optional<Node> possibleNodeToSwitch = findPossibleNodeToSwitch(selectedNode);//if present - swap, if not - unselect
            if (possibleNodeToSwitch.isPresent()) {
                swapNodes(selectedNode, possibleNodeToSwitch.get());
            }
            unselectNodes();
        }

        if (selectionType.equals(TWO_NODES_SELECTED)) {
            unselectNodes();
        }

        if (isGameOver()) {
            gameOver();

        }
        /*
        add if the game is over
         */

    }

    private boolean isGameOver() {
        System.out.println("check if game over");

        for (Node node : nodeList) {
            final IndexedImage image = (IndexedImage) node.getImage();
            if (node.getNodeNumber() != image.getIndex()) {
                return false;
            }
        }
        return true;

    }

    private void gameOver() {
        System.out.println("GAME OVER");
    }


    private void swapNodes(Node selectedNode, Node firstSelected) {
        selectedNode.swapNodes(firstSelected);

    }

    private void initGame() {
        nodeList = NodeGenerator.generateNodeList(this);
        gameBoard.initializeNodesLocation(nodeList);

    }

    private void unselectNodes() {
        for (Node node : nodeList) {
            if (node.isSelected()) {
                node.setNotSelected();
                System.out.println("unselected node " + node.getNodeNumber());
            }
        }
    }

    private Optional<Node> findPossibleNodeToSwitch(Node actualNode) {
        int actualNodeNumber = actualNode.getNodeNumber();

        for (Node firstNodeSelected : nodeList) {
            if (firstNodeSelected.isSelected()) { //ищет какой был кликнут первым
                            /*
                   check actualNodeNumber as a key
                   and should check firstNodeSelected
                     */
                Map<Integer, List<Node>> positionMap = PositionMapInitializer.initPositionMap(nodeList);
                List<Node> possibleNodesToSwitch = PositionMapInitializer.getPossibleNodesToSwitch(positionMap, firstNodeSelected);

                for (Node possibleNodeToSwitchFromList : possibleNodesToSwitch) {
                    if ((possibleNodeToSwitchFromList.getNodeNumber()) == actualNodeNumber) {

                        return Optional.of(firstNodeSelected);

                    }
                }
            }
        }

        return Optional.empty();


    }


    private SelectionEnum getSelectionType(Node selectedNode) {

        int selectedNodesCounter = 0;
        for (Node node : nodeList) {
            if (node.isSelected()) {
                if (node.equals(selectedNode)) {
                    return SELECTED_SAME_NODE;
                } else {
                    selectedNodesCounter++;
                }
            }
        }

        if (selectedNodesCounter == 1) {
            return ONE_NODE_SELECTED;
        }

        if (selectedNodesCounter == 2) {
            return TWO_NODES_SELECTED;
        }

        return NO_NODE_SELECTED;
    }
}
