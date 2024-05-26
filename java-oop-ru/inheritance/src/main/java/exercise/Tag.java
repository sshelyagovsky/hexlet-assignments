package exercise;

import java.util.stream.Collectors;
import java.util.Map;

// BEGIN
public class Tag {
    protected final String type;
    protected final Map<String, String> attributes;

    public Tag(String type, Map<String, String> attributes) {
        this.type = type;
        this.attributes = attributes;
    }

    public String singleTagString() {
        var delim = attributes.isEmpty() ? "" : " ";
        return "<"
                + type
                + delim
                + attributes
                    .entrySet()
                    .stream()
                    .map(e -> e.getKey() + "=\"" + e.getValue() + "\"")
                    .collect(Collectors.joining(" "))
                + ">";
    }
}
// END
