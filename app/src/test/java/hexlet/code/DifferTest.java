package hexlet.code;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
class DifferTest {
    @Test
    public void generateTest() throws Exception {
        var expected = "{\n"
                + "  - follow: false\n"
                + "    host: hexlet.io\n"
                + "  - obj1: {nestedKey=value, isNested=true}\n"
                + "  + obj1: {nestedKey=value}\n"
                + "  + obj2: {key=value}\n"
                + "  - obj3: 250\n"
                + "  + obj3: {key=value}\n"
                + "  - proxy: 123.234.53.22\n"
                + "  - timeout: 50\n"
                + "  + timeout: 20\n"
                + "  + verbose: true\n"
                + "}";
        var actual = Differ.generate("src/test/resources/file1.json", "src/test/resources/file2.json", "stylish");
        assertEquals(expected, actual);

        var expected2 = "{\n"
                + "  - calling-birds: [huey, dewey, louie, fred]\n"
                + "  + calling-birds: huey\n"
                + "    chars1: [a, b, c]\n"
                + "  - chars2: [d, e, f]\n"
                + "  + chars2: false\n"
                + "    check: null\n"
                + "  + obj1: {nestedKey=value, isNested=true}\n"
                + "  - pi: 3.14159\n"
                + "    ray: a drop of golden sun\n"
                + "  + vi: 2.1\n"
                + "  - xmas: true\n"
                + "  + xmas: false\n"
                + "}";
        var actual2 = Differ.generate("src/test/resources/file1.yml", "src/test/resources/file2.yml", "stylish");
        assertEquals(expected2, actual2);

        var expected3 = "Property 'follow' was removed\n"
                + "Property 'obj1' was updated. From [complex value] to [complex value]\n"
                + "Property 'obj2' was added with value: [complex value]\n"
                + "Property 'obj3' was updated. From 250 to [complex value]\n"
                + "Property 'proxy' was removed\n"
                + "Property 'timeout' was updated. From 50 to 20\n"
                + "Property 'verbose' was added with value: true";
        var actual3 = Differ.generate("src/test/resources/file1.json", "src/test/resources/file2.json", "plain");
        assertEquals(expected3, actual3);

        var expected4 = "{-\"follow\": \"false\", ~\"host\": \"hexlet.io\"," +
                " -\"obj1\": \"{nestedKey=value, isNested=true}\"," +
                " +\"obj1\": \"{nestedKey=value}\", +\"obj2\": \"{key=value}\"," +
                " -\"obj3\": \"250\", +\"obj3\": \"{key=value}\"," +
                " -\"proxy\": \"123.234.53.22\", -\"timeout\": \"50\"," +
                " +\"timeout\": \"20\", +\"verbose\": \"true\"}";
        var actual4 = Differ.generate("src/test/resources/file1.json", "src/test/resources/file2.json", "json");
        assertEquals(expected4, actual4);
    }
}
