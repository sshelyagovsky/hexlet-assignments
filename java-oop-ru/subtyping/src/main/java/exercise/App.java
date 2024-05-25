package exercise;

import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

// BEGIN
public class App {
    public static void swapKeyValue(KeyValueStorage storage) {
        Map<String, String> data = storage.toMap();
        Set<String> uniqKey = new TreeSet<>(data.keySet());

        for (var key : uniqKey) {
            var value = data.get(key);
            storage.unset(key);
            storage.set(value, key);
        }
    }
}
// END
