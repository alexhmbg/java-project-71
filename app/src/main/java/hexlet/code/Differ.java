package hexlet.code;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Differ {
    public static String generate(String filepath1, String filepath2, String format) throws Exception {
        Map<String, Object> fileMap1 = Parser.parse(filepath1);
        Map<String, Object> fileMap2 = Parser.parse(filepath2);
        List<String> sortedKeyList = Stream.concat(
                fileMap1.keySet().stream(),
                fileMap2.keySet().stream())
                .distinct()
                .sorted()
                .toList();

        var listOfMapDiffs = DiffBuilder.build(fileMap1, fileMap2, sortedKeyList);

        if (format.equals("stylish")) {
            return Formatter.stylish(listOfMapDiffs);
        }

        return Formatter.stylish(listOfMapDiffs);
    }
}
