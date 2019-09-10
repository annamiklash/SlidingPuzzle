package mi.mi.miklash.slidingpuzzle.controller;

import mi.mi.miklash.slidingpuzzle.generator.NodeGenerator;
import mi.mi.miklash.slidingpuzzle.initializer.PositionMapInitializer;
import mi.mi.miklash.slidingpuzzle.model.Node;
import mi.mi.miklash.slidingpuzzle.model.SelectionEnum;
import mi.mi.miklash.slidingpuzzle.view.GameBoard;

import java.util.List;
import java.util.Map;

import static mi.mi.miklash.slidingpuzzle.model.SelectionEnum.*;

public class GameController {

    private List<Node> nodeList;
    private GameBoard gameBoard;


    public GameController(GameBoard gameBoard) {
        this.gameBoard = gameBoard;

        initGame();

    }

    public void handleSelection(Node selectedNode) {

        final SelectionEnum selectionType = processSelectedNodes(selectedNode);

        if (selectionType.equals(SELECTED_SAME_NODE)) {
            return;
        }

        if (selectionType.equals(ONE_NODE_SELECTED)) {

            findPossibleNodeToSwitch(selectedNode);
        }

        if (selectionType.equals(TWO_NODES_SELECTED)) {
            unselectNodes();
        }

        selectedNode.setSelected();
    }

    private void initGame() {
        nodeList = NodeGenerator.generateShuffledNodeList(this);
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

    private void findPossibleNodeToSwitch(Node actualNode) {
        Map<Integer, List<Node>> positionMap = PositionMapInitializer.init4x4PositionMap(nodeList);


        int actualNodeNumber = actualNode.getNodeNumber();

        for (Node firstNodeSelected : nodeList) {
            if (firstNodeSelected.isSelected()) { //ищет какой был кликнут первым
                int firstSelectedNodeNumber = firstNodeSelected.getNodeNumber();
                if (actualNodeNumber != firstSelectedNodeNumber) {
                    /*
                   check actualNodeNumber as a key
                   and should check firstNodeSelected
                     */
                    List<Node> possibleNodesToSwitch = PositionMapInitializer.getPossibleNodesToSwitch(positionMap, firstNodeSelected);

                    for (Node possibleNodeToSwitchFromList : possibleNodesToSwitch) {
                        if ((possibleNodeToSwitchFromList.getNodeNumber()) == actualNodeNumber){

                            firstNodeSelected.swapNodes(actualNode);


                            break;

                        }
                    }


                }
            }
        }
    }




    private SelectionEnum processSelectedNodes(Node selectedNode) {

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
