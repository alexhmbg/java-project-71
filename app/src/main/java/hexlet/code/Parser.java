package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class Parser {
    public static Map<String, Object> parse(String filepath) throws Exception {
        Path normalizePath = Paths.get(filepath).toAbsolutePath().normalize();

        if (!Files.exists(normalizePath)) {
            throw new Exception("File '" + filepath + "' does not exist");
        }

        File file = new File(String.valueOf(normalizePath));

        ObjectMapper mapper = new ObjectMapper();
        var fileMap = mapper.readValue(file, new TypeReference<Map<String, Object>>() { });

        return fileMap;
    }
}
