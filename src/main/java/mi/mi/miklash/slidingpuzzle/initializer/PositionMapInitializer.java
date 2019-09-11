package mi.mi.miklash.slidingpuzzle.initializer;

import mi.mi.miklash.slidingpuzzle.model.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static mi.mi.miklash.slidingpuzzle.common.Constants.COLUMN_NUMBER;

public class PositionMapInitializer {

    public static Map<Integer, List<Node>> initPositionMap(List<Node> nodeList) {
        Map<Integer, List<Node>> positionMap = new HashMap<>();

        for (int i = 0; i < COLUMN_NUMBER * COLUMN_NUMBER; i++) {
            if (i == 0) {
                List<Node> value = new ArrayList<>();
                value.add(nodeList.get(i + 1));
                value.add(nodeList.get(i + COLUMN_NUMBER));
                positionMap.put(i, value);
            } else if (i == COLUMN_NUMBER - 1) {
                List<Node> value = new ArrayList<>();
                value.add(nodeList.get(i - 1));
                value.add(nodeList.get(i + COLUMN_NUMBER));
                positionMap.put(i, value);
            } else if (i == COLUMN_NUMBER * COLUMN_NUMBER - COLUMN_NUMBER) {
                List<Node> value = new ArrayList<>();
                value.add(nodeList.get(i - COLUMN_NUMBER));
                value.add(nodeList.get(i + 1));
                positionMap.put(i, value);
            } else if (i == COLUMN_NUMBER * COLUMN_NUMBER - 1) {
                List<Node> value = new ArrayList<>();
                value.add(nodeList.get(i - COLUMN_NUMBER));
                value.add(nodeList.get(i - 1));
                positionMap.put(i, value);
            } else if (i < COLUMN_NUMBER) {
                List<Node> value = new ArrayList<>();
                value.add(nodeList.get(i - 1));
                value.add(nodeList.get(i + 1));
                value.add(nodeList.get(i + COLUMN_NUMBER));
                positionMap.put(i, value);
            } else if (i % COLUMN_NUMBER == 0) {
                List<Node> value = new ArrayList<>();
                value.add(nodeList.get(i - COLUMN_NUMBER));
                value.add(nodeList.get(i + 1));
                value.add(nodeList.get(i + COLUMN_NUMBER));
                positionMap.put(i, value);
            } else if (i % COLUMN_NUMBER == COLUMN_NUMBER - 1) {
                List<Node> value = new ArrayList<>();
                value.add(nodeList.get(i - COLUMN_NUMBER));
                value.add(nodeList.get(i - 1));
                value.add(nodeList.get(i + COLUMN_NUMBER));
                positionMap.put(i, value);
            } else if (i > COLUMN_NUMBER * (COLUMN_NUMBER - 1)) {
                List<Node> value = new ArrayList<>();
                value.add(nodeList.get(i - COLUMN_NUMBER));
                value.add(nodeList.get(i - 1));
                value.add(nodeList.get(i + 1));
                positionMap.put(i, value);
            } else {
                List<Node> value = new ArrayList<>();
                value.add(nodeList.get(i - COLUMN_NUMBER));
                value.add(nodeList.get(i - 1));
                value.add(nodeList.get(i + 1));
                value.add(nodeList.get(i + COLUMN_NUMBER));
                positionMap.put(i, value);
            }
        }

        return positionMap;
    }

    public static List<Node> getPossibleNodesToSwitch(Map<Integer, List<Node>> positionMap, Node node) {
        int nodeNumber = node.getNodeNumber();

        return positionMap.get(nodeNumber);
    }


}
