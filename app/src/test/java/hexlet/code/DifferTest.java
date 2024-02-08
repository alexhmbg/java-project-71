package hexlet.code;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DifferTest {
    @Test
    public void generateTest() throws Exception {
        var expected = Differ.fileToString("src/test/resources/fixtures/stylishFormat");
        var actual = Differ.generate("src/test/resources/fixtures/file1.json",
                "src/test/resources/fixtures/file2.json",
                "stylish");
        assertEquals(expected, actual);

        var expected2 = Differ.fileToString("src/test/resources/fixtures/stylishFormat");
        var actual2 = Differ.generate("src/test/resources/fixtures/file1.yml",
                "src/test/resources/fixtures/file2.yml",
                "stylish");
        assertEquals(expected2, actual2);

        var expected3 = Differ.fileToString("src/test/resources/fixtures/plainFormat");
        var actual3 = Differ.generate("src/test/resources/fixtures/file1.json",
                "src/test/resources/fixtures/file2.json",
                "plain");
        assertEquals(expected3, actual3);

        var expected4 = Differ.fileToString("src/test/resources/fixtures/plainFormat");
        var actual4 = Differ.generate("src/test/resources/fixtures/file1.yml",
                "src/test/resources/fixtures/file2.yml",
                "plain");
        assertEquals(expected4, actual4);

        var expected5 = Differ.fileToString("src/test/resources/fixtures/jsonFormat");
        var actual5 = Differ.generate("src/test/resources/fixtures/file1.json",
                "src/test/resources/fixtures/file2.json",
                "json");
        assertEquals(expected5, actual5);

        var expected6 = Differ.fileToString("src/test/resources/fixtures/jsonFormat");
        var actual6 = Differ.generate("src/test/resources/fixtures/file1.yml",
                "src/test/resources/fixtures/file2.yml",
                "json");
        assertEquals(expected6, actual6);

        var expected7 = Differ.fileToString("src/test/resources/fixtures/stylishFormat");
        var actual7 = Differ.generate("src/test/resources/fixtures/file1.json",
                "src/test/resources/fixtures/file2.json");
        assertEquals(expected7, actual7);

        var expected8 = Differ.fileToString("src/test/resources/fixtures/stylishFormat");
        var actual8 = Differ.generate("src/test/resources/fixtures/file1.yml",
                "src/test/resources/fixtures/file2.yml");
        assertEquals(expected8, actual8);
    }
}
