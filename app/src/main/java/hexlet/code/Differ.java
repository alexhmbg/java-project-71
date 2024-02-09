package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class Differ {
    public static String generate(String filepath1, String filepath2, String format) throws Exception {
        String fileData1 = fileToString(filepath1);
        String fileData2 = fileToString(filepath2);

        String fileExtension1 = filepath1.substring(filepath1.lastIndexOf(".") + 1);
        String fileExtension2 = filepath2.substring(filepath2.lastIndexOf(".") + 1);

        Map<String, Object> fileMap1 = Parser.parse(fileData1, fileExtension1);
        Map<String, Object> fileMap2 = Parser.parse(fileData2, fileExtension2);

        var listOfMapDiffs = DiffBuilder.build(fileMap1, fileMap2);

        return Formatter.format(listOfMapDiffs, format);
    }

    public static String generate(String filepath1, String filepath2) throws Exception {
        return generate(filepath1, filepath2, "stylish");
    }

    public static String fileToString(String filepath) throws Exception {
        Path path = Paths.get(filepath).toAbsolutePath().normalize();

        if (!Files.exists(path)) {
            throw new Exception("File '" + path + "' does not exist");
        }

        return Files.readString(path);
    }
}
