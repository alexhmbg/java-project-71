package hexlet.code.formatters;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Plain {
    public static String format(List<Map<String, Object>> listOfMapDiffs) {
        List<String> result = new LinkedList<>();

        for (var mapOfDiffs : listOfMapDiffs) {
            var getKey = mapOfDiffs.get("key");
            var getStatus = mapOfDiffs.get("status");
            var getValue1 = complexValueToString(mapOfDiffs.get("value1"));
            var getValue2 = complexValueToString(mapOfDiffs.get("value2"));

            switch (String.valueOf(getStatus)) {
                case "added":
                    result.add("Property '" + getKey + "' was added with value: " + getValue1);
                    break;
                case "deleted":
                    result.add("Property '" + getKey + "' was removed");
                    break;
                case "unchanged":
                    break;
                default:
                    result.add("Property '" + getKey + "' was updated. From " + getValue1 + " to " + getValue2);
                    break;
            }
        }

        return String.join("\n", result);
    }

    public static Object complexValueToString(Object value) {
        var isInteger = value instanceof Integer;
        var isString = value instanceof String;
        var isBoolean = value instanceof Boolean;
        var isNull = value != null;

        if (!isInteger && !isString && !isBoolean && isNull) {
            return "[complex value]";
        }

        return value;
    }
}
