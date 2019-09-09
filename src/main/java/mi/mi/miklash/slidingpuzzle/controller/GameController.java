package mi.mi.miklash.slidingpuzzle.controller;

import mi.mi.miklash.slidingpuzzle.generator.NodeGenerator;
import mi.mi.miklash.slidingpuzzle.initializer.PositionMapInitializer;
import mi.mi.miklash.slidingpuzzle.model.Node;
import mi.mi.miklash.slidingpuzzle.model.SelectionEnum;

import java.util.List;
import java.util.Map;

import static mi.mi.miklash.slidingpuzzle.model.SelectionEnum.*;


public class GameController {

    private List<Node> nodeList;
    MovesCounterController movesCounterController;

    public GameController() {
        this.movesCounterController = new MovesCounterController();
        nodeList = NodeGenerator.generateShuffledNodeList(this);

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
        movesCounterController.incrementMovesCounter();


    }

    private void unselectNodes() {
        for (Node node : nodeList) {
            if (node.isSelected()) {
                node.setNotSelected();
            }
        }

    }

    private void findPossibleNodeToSwitch(Node actualNode) {
        Map<Integer, List<Node>> positionMap = PositionMapInitializer.init4x4PositionMap(nodeList);
        List<Node> possibleNodesToSwitch = PositionMapInitializer.getPossibleNodesToSwitch(positionMap, actualNode);

        int actualNodeNumber = actualNode.getNodeNumber();

        for (Node node : nodeList) {
            if (node.isSelected()) {
                int selectedNodeNumber = node.getNodeNumber();
                if (actualNodeNumber != selectedNodeNumber) {
                    /*
                   check actualNodeNumber as a key
                   and should check node
                     */


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
