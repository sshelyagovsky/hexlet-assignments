package exercise;

import java.util.Map;
import java.util.HashMap;

// BEGIN
public class InMemoryKV implements KeyValueStorage {
    private final HashMap<String, String> dataSet;

    public InMemoryKV(Map<String, String> data) {
        this.dataSet = new HashMap<>(data);
    }

    @Override
    public void set(String key, String value) {
        if (dataSet.containsKey(key)) {
            dataSet.replace(key, value);
        } else {
            dataSet.put(key, value);
        }
    }

    @Override
    public void unset(String key) {
        dataSet.remove(key);
    }

    @Override
    public String get(String key, String defaultValue) {
        if (!dataSet.containsKey(key)) {
            return defaultValue;
        }
        return dataSet.get(key);
    }

    @Override
    public HashMap<String, String> toMap() {
        return new HashMap<>(dataSet);
    }
}
// END
