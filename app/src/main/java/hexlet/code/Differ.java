package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Differ {
    public static String generate(String filepath1, String filepath2) throws Exception {
        Map<String, Object> fileMap1 = Parser.parse(filepath1);
        Map<String, Object> fileMap2 = Parser.parse(filepath2);

        var result = Stream.concat(
                fileMap1.keySet().stream(),
                fileMap2.keySet().stream())
                .distinct()
                .sorted()
                .map(key -> {
                    var value1 = fileMap1.getOrDefault(key, "added");
                    var value2 = fileMap2.getOrDefault(key, "deleted");
                    return compareStrings(key, value1, value2);
                })
                .collect(Collectors.joining("\n", "{\n", "\n}"));

        return result;
    }

    public static String compareStrings(String key, Object value1, Object value2) {
        if (value1.equals(value2)) {
            return "    " + key + ": " + value1;
        } else if (value1.equals("added")) {
            return "  + " + key + ": " + value2;
        } else if (value2.equals("deleted")) {
            return "  - " + key + ": " + value1;
        } else {
            return "  - " + key + ": " + value1 + "\n" + "  + " + key + ": " + value2;
        }
    }
}
