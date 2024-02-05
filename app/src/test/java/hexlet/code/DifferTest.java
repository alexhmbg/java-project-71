package hexlet.code;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
class DifferTest {
    @Test
    public void generateTest() throws Exception {
        var expected = Parser.parseTestExpected("src/test/resources/fixtures/jsonToStylishFormat");
        var actual = Differ.generate("src/test/resources/fixtures/file1.json", "src/test/resources/fixtures/file2.json", "stylish");
        assertEquals(expected, actual);

        var expected2 = Parser.parseTestExpected("src/test/resources/fixtures/ymlToStylishFormat");
        var actual2 = Differ.generate("src/test/resources/fixtures/file1.yml", "src/test/resources/fixtures/file2.yml", "stylish");
        assertEquals(expected2, actual2);

        var expected3 = Parser.parseTestExpected("src/test/resources/fixtures/jsonToPlainFormat");
        var actual3 = Differ.generate("src/test/resources/fixtures/file1.json", "src/test/resources/fixtures/file2.json", "plain");
        assertEquals(expected3, actual3);

        var expected4 = Parser.parseTestExpected("src/test/resources/fixtures/ymlToPlainFormat");
        var actual4 = Differ.generate("src/test/resources/fixtures/file1.yml", "src/test/resources/fixtures/file2.yml", "plain");
        assertEquals(expected4, actual4);

        var expected5 = Parser.parseTestExpected("src/test/resources/fixtures/jsonToJsonFormat");
        var actual5 = Differ.generate("src/test/resources/fixtures/file1.json", "src/test/resources/fixtures/file2.json", "json");
        assertEquals(expected5, actual5);

        var expected6 = Parser.parseTestExpected("src/test/resources/fixtures/ymlToJsonFormat");
        var actual6 = Differ.generate("src/test/resources/fixtures/file1.yml", "src/test/resources/fixtures/file2.yml", "json");
        assertEquals(expected6, actual6);

        var expected7 = Parser.parseTestExpected("src/test/resources/fixtures/jsonToStylishFormat");
        var actual7 = Differ.generate("src/test/resources/fixtures/file1.json", "src/test/resources/fixtures/file2.json", "test");
        assertEquals(expected7, actual7);

        var expected8 = Parser.parseTestExpected("src/test/resources/fixtures/ymlToStylishFormat");
        var actual8 = Differ.generate("src/test/resources/fixtures/file1.yml", "src/test/resources/fixtures/file2.yml", "test");
        assertEquals(expected8, actual8);
    }
}
