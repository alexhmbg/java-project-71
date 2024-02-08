package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.util.Map;

public class Parser {
    public static Map<String, Object> parse(String data, String format) throws Exception {
        ObjectMapper mapper = switch (format) {
            case "yml" -> new YAMLMapper();
            case "json" -> new ObjectMapper();
            default -> throw new RuntimeException("The file format " + format + " is not supported");
        };

        var fileMap = mapper.readValue(data, new TypeReference<Map<String, Object>>() { });
        return fileMap;
    }
}
