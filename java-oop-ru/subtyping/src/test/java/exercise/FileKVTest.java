package exercise;

import java.util.HashMap;
import org.junit.jupiter.api.BeforeEach;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
// BEGIN

// END


class FileKVTest {

    private static final Path FILE_PATH = Paths.get("src/test/resources/file").toAbsolutePath().normalize();

    @BeforeEach
    public void beforeEach() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String content = mapper.writeValueAsString(new HashMap<String, String>());
        Files.writeString(FILE_PATH, content, StandardOpenOption.TRUNCATE_EXISTING);
    }

    // BEGIN
    @Test
    public void fileKVTest() {

        KeyValueStorage storage = new FileKV(FILE_PATH.toString(), Map.of("key", "value"));
        storage.set("key1", "google");
        storage.set("key2", "yandex");
        assertThat(storage.get("key2", "default")).isEqualTo("yandex");

        storage.unset("key2");
        assertThat(storage.get("key2", "default")).isEqualTo("default");

        var expectedMap = Map.of("key", "value", "key1", "google");
        assertThat(storage.toMap()).isEqualTo(expectedMap);
    }
    // END
}
