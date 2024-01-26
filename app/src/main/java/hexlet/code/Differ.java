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
        Path path1 = Paths.get(filepath1).toAbsolutePath().normalize();
        Path path2 = Paths.get(filepath2).toAbsolutePath().normalize();

        if (!Files.exists(path1)) {
            throw new Exception("File '" + filepath1 + "' does not exist");
        } else if (!Files.exists(path2)) {
            throw new Exception("File '" + filepath2 + "' does not exist");
        }

        File json1 = new File(String.valueOf(path1));
        File json2 = new File(String.valueOf(path2));

        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> jsonMap1 = mapper.readValue(json1, new TypeReference<>() { });
        Map<String, Object> jsonMap2 = mapper.readValue(json2, new TypeReference<>() { });

        var result = Stream.concat(
                jsonMap1.keySet().stream(),
                jsonMap2.keySet().stream())
                .distinct()
                .sorted()
                .map(key -> valueDiff(key, jsonMap1.get(key), jsonMap2.get(key)))
                .collect(Collectors.joining("\n", "{\n", "\n}"));

        return result;
    }

    public static String valueDiff(String key, Object value1, Object value2) {

        if (value1 == null) {
            return "  + " + key + ": " + value2;
        } else if (value2 == null) {
            return "  - " + key + ": " + value1;
        } else if (value1.equals(value2)) {
            return "    " + key + ": " + value1;
        } else {
            return "  - "
                    + key
                    + ": "
                    + value1
                    + "\n"
                    + "  + "
                    + key
                    + ": "
                    + value2;
        }
    }
}
