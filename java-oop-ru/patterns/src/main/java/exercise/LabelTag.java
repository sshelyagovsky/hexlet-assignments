package exercise;

// BEGIN
public class LabelTag implements TagInterface {

    private final String label;
    private final TagInterface inputTag;

    public LabelTag(String label, TagInterface inputTag) {
        this.label = label;
        this.inputTag = inputTag;
    }

    public String render() {
        return "<label>"
                + label
                + inputTag.render()
                + "</label>";
    }
}
// END
