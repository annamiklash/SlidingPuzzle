package mi.mi.miklash.slidingpuzzle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static mi.mi.miklash.slidingpuzzle.common.Constants.COLUMN_NUMBER;

public class Test {

    public static void main(String[] args) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < COLUMN_NUMBER * COLUMN_NUMBER; i++) {
            if (i == 0) {
                List<Integer> value = new ArrayList<>();
                value.add(i + 1);
                value.add(i + COLUMN_NUMBER);
                map.put(i, value);
            } else if (i == COLUMN_NUMBER - 1) {
                List<Integer> value = new ArrayList<>();
                value.add(i - 1);
                value.add(i + COLUMN_NUMBER);
                map.put(i, value);
            } else if (i == COLUMN_NUMBER * COLUMN_NUMBER - COLUMN_NUMBER) {
                List<Integer> value = new ArrayList<>();
                value.add(i - COLUMN_NUMBER);
                value.add(i + 1);
                map.put(i, value);
            } else if (i == COLUMN_NUMBER * COLUMN_NUMBER - 1) {
                List<Integer> value = new ArrayList<>();
                value.add(i - COLUMN_NUMBER);
                value.add(i - 1);
                map.put(i, value);
            } else if (i < COLUMN_NUMBER) {
                List<Integer> value = new ArrayList<>();
                value.add(i - 1);
                value.add(i + 1);
                value.add(i + COLUMN_NUMBER);
                map.put(i, value);
            } else if (i % COLUMN_NUMBER == 0) {
                List<Integer> value = new ArrayList<>();
                value.add(i - COLUMN_NUMBER);
                value.add(i + 1);
                value.add(i + COLUMN_NUMBER);
                map.put(i, value);
            } else if (i % COLUMN_NUMBER == COLUMN_NUMBER - 1) {
                List<Integer> value = new ArrayList<>();
                value.add(i - COLUMN_NUMBER);
                value.add(i - 1);
                value.add(i + COLUMN_NUMBER);
                map.put(i, value);
            } else if (i > COLUMN_NUMBER * (COLUMN_NUMBER -1)) {
                List<Integer> value = new ArrayList<>();
                value.add(i - COLUMN_NUMBER);
                value.add(i - 1);
                value.add(i + 1);
                map.put(i, value);
            } else {
                List<Integer> value = new ArrayList<>();
                value.add(i - COLUMN_NUMBER);
                value.add(i - 1);
                value.add(i + 1);
                value.add(i + COLUMN_NUMBER);
                map.put(i, value);
            }
        }

        System.out.println(map.toString());

    }

}
