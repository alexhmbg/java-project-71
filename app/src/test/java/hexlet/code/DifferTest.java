package hexlet.code;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
class DifferTest {
    @Test
    public void generateTest() throws Exception {
        var expected = "{\n"
                + "  - follow: false\n"
                + "    host: hexlet.io\n"
                + "  - proxy: 123.234.53.22\n"
                + "  - timeout: 50\n"
                + "  + timeout: 20\n"
                + "  + verbose: true\n"
                + "}";
        var actual = Differ.generate("src/test/resources/file1.json", "src/test/resources/file2.json", "stylish");
        assertEquals(expected, actual);

        var expected2 = "{\n" +
                "  - calling-birds: [huey, dewey, louie, fred]\n" +
                "  + calling-birds: huey\n" +
                "    check: null\n" +
                "  - pi: 3.14159\n" +
                "    ray: a drop of golden sun\n" +
                "  + vi: 2.1\n" +
                "  - xmas: true\n" +
                "  + xmas: false\n" +
                "}";
        var actual2 = Differ.generate("src/test/resources/file1.yml", "src/test/resources/file2.yml", "stylish");
        assertEquals(expected2, actual2);
    }
}
