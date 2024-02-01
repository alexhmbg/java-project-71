package hexlet.code;

import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.List;
import java.util.Map;

public class Formatter {
    public static String format(List<Map<String, Object>> listOfMapDiffs, String format) {

        return switch (format) {
            case "stylish" -> Stylish.format(listOfMapDiffs);
            case "plain" -> Plain.format(listOfMapDiffs);
            default -> Formatter.format(listOfMapDiffs, "stylish");
        };

    }
}
