package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.List;
import java.util.Map;

public class Formatter {
    public static String format(List<Map<String, Object>> listOfMapDiffs, String format)
            throws JsonProcessingException {

        return switch (format) {
            case "stylish" -> Stylish.format(listOfMapDiffs);
            case "plain" -> Plain.format(listOfMapDiffs);
            case "json" -> Json.format(listOfMapDiffs);
            default -> throw new RuntimeException("Unrecognizable format " + format);
        };

    }
}
