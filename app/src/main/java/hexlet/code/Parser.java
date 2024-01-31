package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class Parser {
    public static Map<String, Object> parse(String filepath) throws Exception {
        Path path = Paths.get(filepath).toAbsolutePath().normalize();

        if (!Files.exists(path)) {
            throw new Exception("File '" + filepath + "' does not exist");
        }

        String fileExtension = filepath.substring(filepath.lastIndexOf(".") + 1);
        ObjectMapper mapper = switch (fileExtension) {
            case "yml" -> new YAMLMapper();
            case "anything" -> new YAMLMapper();
            default -> new ObjectMapper();
        };

        var fileMap = mapper.readValue(Files.readString(path), new TypeReference<Map<String, Object>>() { });

        return fileMap;
    }
}
