package hexlet.code;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class DiffBuilder {
    public static List<Map<String, Object>> build(Map<String, Object> fileMap1, Map<String, Object> fileMap2, List<String> keys) {
        List<Map<String, Object>> listOfMapDiffs = new LinkedList<>();

        for (var key : keys) {
            Map<String, Object> map = new TreeMap<>();
            var valueString1 = fileMap1.get(key);
            var valueString2 = fileMap2.get(key);

            if (!fileMap1.containsKey(key)) {
                map.put("key", key);
                map.put("status", "added");
                map.put("value1", valueString2);
                listOfMapDiffs.add(map);
            } else if (!fileMap2.containsKey(key)) {
                map.put("key", key);
                map.put("status", "deleted");
                map.put("value1", valueString1);
                listOfMapDiffs.add(map);
            } else if (String.valueOf(valueString1).equals(String.valueOf(valueString2))) {
                map.put("key", key);
                map.put("status", "unchanged");
                map.put("value1", valueString1);
                listOfMapDiffs.add(map);
            } else {
                map.put("key", key);
                map.put("status", "changed");
                map.put("value1", valueString1);
                map.put("value2", valueString2);
                listOfMapDiffs.add(map);
            }
        }

        return listOfMapDiffs;
    }
}
