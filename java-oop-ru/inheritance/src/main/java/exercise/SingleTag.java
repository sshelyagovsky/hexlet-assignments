package exercise;

import java.util.Map;

// BEGIN
public class SingleTag extends Tag {

    public SingleTag(String type, Map<String, String> attributes) {
        super(type, attributes);
    }

    @Override
    public String toString() {
        return super.singleTagString();
    }
}
// END
