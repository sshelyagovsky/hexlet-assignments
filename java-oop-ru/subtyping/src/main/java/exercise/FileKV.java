package exercise;

import java.util.Map;

// BEGIN
public class FileKV implements KeyValueStorage {

    private final String path;
    private Map<String, String> storage;

    public FileKV(String path, Map<String, String> storage) {
        this.path = path;
        this.storage = storage;
        transformAndWrite();
    }

    public Map<String, String> readAndTransform() {
        var content = Utils.readFile(path);
        return Utils.unserialize(content);
    }

    public void transformAndWrite() {
        var resultContent = Utils.serialize(storage);
        Utils.writeFile(path, resultContent);
    }

    @Override
    public void set(String key, String value) {
        storage = readAndTransform();

        if (storage.containsKey(key)) {
            storage.replace(key, value);
        } else {
            storage.put(key, value);
        }
        transformAndWrite();
    }

    @Override
    public void unset(String key) {
        storage = readAndTransform();

        storage.remove(key);
        transformAndWrite();
    }

    @Override
    public String get(String key, String defaultValue) {
        storage = readAndTransform();

        if (!storage.containsKey(key)) {
            return defaultValue;
        }
        return storage.get(key);
    }

    @Override
    public Map<String, String> toMap() {
        return readAndTransform();
    }
}
// END
