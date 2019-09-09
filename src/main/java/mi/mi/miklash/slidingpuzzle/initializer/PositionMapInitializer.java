package mi.mi.miklash.slidingpuzzle.initializer;

import mi.mi.miklash.slidingpuzzle.model.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PositionMapInitializer {

    public static Map<Integer, List<Node>> init4x4PositionMap(List<Node> nodeList) {

        List<Node> positionsForNode0 = new ArrayList<>();
        positionsForNode0.add(nodeList.get(1));
        positionsForNode0.add(nodeList.get(5));

        List<Node> positionsForNode1 = new ArrayList<>();
        positionsForNode1.add(nodeList.get(0));
        positionsForNode1.add(nodeList.get(5));
        positionsForNode1.add(nodeList.get(2));

        List<Node> positionsForNode2 = new ArrayList<>();
        positionsForNode2.add(nodeList.get(1));
        positionsForNode2.add(nodeList.get(3));
        positionsForNode2.add(nodeList.get(6));

        List<Node> positionsForNode3 = new ArrayList<>();
        positionsForNode3.add(nodeList.get(2));
        positionsForNode3.add(nodeList.get(7));

        List<Node> positionsForNode4 = new ArrayList<>();
        positionsForNode4.add(nodeList.get(0));
        positionsForNode4.add(nodeList.get(5));
        positionsForNode4.add(nodeList.get(8));

        List<Node> positionsForNode5 = new ArrayList<>();
        positionsForNode5.add(nodeList.get(1));
        positionsForNode5.add(nodeList.get(4));
        positionsForNode5.add(nodeList.get(6));
        positionsForNode5.add(nodeList.get(9));

        List<Node> positionsForNode6 = new ArrayList<>();
        positionsForNode6.add(nodeList.get(2));
        positionsForNode6.add(nodeList.get(5));
        positionsForNode6.add(nodeList.get(7));
        positionsForNode6.add(nodeList.get(10));

        List<Node> positionsForNode7 = new ArrayList<>();
        positionsForNode7.add(nodeList.get(3));
        positionsForNode7.add(nodeList.get(6));
        positionsForNode7.add(nodeList.get(11));

        List<Node> positionsForNode8 = new ArrayList<>();
        positionsForNode8.add(nodeList.get(4));
        positionsForNode8.add(nodeList.get(9));
        positionsForNode8.add(nodeList.get(12));

        List<Node> positionsForNode9 = new ArrayList<>();
        positionsForNode9.add(nodeList.get(5));
        positionsForNode9.add(nodeList.get(8));
        positionsForNode9.add(nodeList.get(10));
        positionsForNode9.add(nodeList.get(13));

        List<Node> positionsForNode10 = new ArrayList<>();
        positionsForNode10.add(nodeList.get(6));
        positionsForNode10.add(nodeList.get(9));
        positionsForNode10.add(nodeList.get(11));
        positionsForNode10.add(nodeList.get(14));

        List<Node> positionsForNode11 = new ArrayList<>();
        positionsForNode11.add(nodeList.get(7));
        positionsForNode11.add(nodeList.get(10));
        positionsForNode11.add(nodeList.get(15));


        List<Node> positionsForNode12 = new ArrayList<>();
        positionsForNode12.add(nodeList.get(8));
        positionsForNode12.add(nodeList.get(11));
        positionsForNode12.add(nodeList.get(13));


        List<Node> positionsForNode13 = new ArrayList<>();
        positionsForNode13.add(nodeList.get(9));
        positionsForNode13.add(nodeList.get(12));
        positionsForNode13.add(nodeList.get(14));

        List<Node> positionsForNode14 = new ArrayList<>();
        positionsForNode14.add(nodeList.get(10));
        positionsForNode14.add(nodeList.get(13));
        positionsForNode14.add(nodeList.get(15));

        List<Node> positionsForNode15 = new ArrayList<>();
        positionsForNode15.add(nodeList.get(11));
        positionsForNode15.add(nodeList.get(14));


        Map<Integer, List<Node>> positionMap = new HashMap<>();

        positionMap.put(0, positionsForNode0);
        positionMap.put(1, positionsForNode1);
        positionMap.put(2, positionsForNode2);
        positionMap.put(3, positionsForNode3);
        positionMap.put(4, positionsForNode4);
        positionMap.put(5, positionsForNode5);
        positionMap.put(6, positionsForNode6);
        positionMap.put(7, positionsForNode7);
        positionMap.put(8, positionsForNode8);
        positionMap.put(9, positionsForNode9);
        positionMap.put(10, positionsForNode10);
        positionMap.put(11, positionsForNode11);
        positionMap.put(12, positionsForNode12);
        positionMap.put(13, positionsForNode13);
        positionMap.put(14, positionsForNode14);
        positionMap.put(15, positionsForNode15);


        return positionMap;
    }

    public static List<Node> getPossibleNodesToSwitch(Map<Integer, List<Node>> positionMap, Node node) {
        int nodeNumber = node.getNodeNumber();

        return positionMap.get(nodeNumber);
    }


}
