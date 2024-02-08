package hexlet.code.formatters;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Stylish {
    public static String format(List<Map<String, Object>> listOfMapDiffs) {
        Map<String, Object> map = new LinkedHashMap<>();

        for (var mapOfDiffs : listOfMapDiffs) {
            var getKey = mapOfDiffs.get("key");
            var getStatus = mapOfDiffs.get("status");
            var getValue1 = mapOfDiffs.get("value1");
            var getValue2 = mapOfDiffs.get("value2");

            switch (String.valueOf(getStatus)) {
                case "added":
                    map.put("  + " + getKey, getValue1);
                    break;
                case "deleted":
                    map.put("  - " + getKey, getValue1);
                    break;
                case "changed":
                    map.put("  - " + getKey, getValue1);
                    map.put("  + " + getKey, getValue2);
                    break;
                case "unchanged":
                    map.put("    " + getKey, getValue1);
                    break;
                default:
                    throw new RuntimeException("Unrecognizable status of diff " + getStatus);
            }
        }

        var result = map.entrySet().stream()
                .map(n -> n.getKey() + ": " + n.getValue())
                .collect(Collectors.joining("\n", "{\n", "\n}"));

        return result;
    }
}
