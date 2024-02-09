package hexlet.code;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Stream;

public class DiffBuilder {
    public static List<Map<String, Object>> build(Map<String, Object> fileMap1,
                                                  Map<String, Object> fileMap2) {
        List<Map<String, Object>> listOfMapDiffs = new LinkedList<>();

        List<String> sortedKeys = Stream.concat(
                        fileMap1.keySet().stream(),
                        fileMap2.keySet().stream())
                .distinct()
                .sorted()
                .toList();

        for (var key : sortedKeys) {
            Map<String, Object> map = new TreeMap<>();
            var valueString1 = fileMap1.get(key);
            var valueString2 = fileMap2.get(key);

            if (!fileMap1.containsKey(key)) {
                map.put("key", key);
                map.put("status", "added");
                map.put("value1", valueString2);
            } else if (!fileMap2.containsKey(key)) {
                map.put("key", key);
                map.put("status", "deleted");
                map.put("value1", valueString1);
            } else if (String.valueOf(valueString1).equals(String.valueOf(valueString2))) {
                map.put("key", key);
                map.put("status", "unchanged");
                map.put("value1", valueString1);
            } else {
                map.put("key", key);
                map.put("status", "changed");
                map.put("value1", valueString1);
                map.put("value2", valueString2);
            }

            listOfMapDiffs.add(map);
        }

        return listOfMapDiffs;
    }
}
