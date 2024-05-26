package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class PairedTag extends Tag {
    private final String tagBody;
    private final List<Tag> singleTags;

    public PairedTag(String type, Map<String, String> attributes, String tagBody, List<Tag> singleTags) {
        super(type, attributes);
        this.tagBody = tagBody;
        this.singleTags = singleTags;
    }

    @Override
    public String toString() {
        return  super.singleTagString()
                + tagBody
                + singleTags
                    .stream()
                    .map(Object::toString)
                    .collect(Collectors.joining(""))
                + "</" + type + ">";
    }
}
// END
