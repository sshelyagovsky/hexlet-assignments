package exercise;

// BEGIN
 public class ReversedSequence implements CharSequence{

    private final String str;

    private String reverseStr;

    public ReversedSequence(String str) {
        this.str = str;
        reverseStr(str);
    }

    public void reverseStr(String str) {
        reverseStr = new StringBuilder(str).reverse().toString();
    }

    @Override
    public int length() {
        return reverseStr.length();
    }

    @Override
    public char charAt(int index) {
        return reverseStr.charAt(index);
    }

    @Override
    public CharSequence subSequence(int start,int end) {
        return reverseStr.subSequence(start, end);
    }

    @Override
    public String toString() {
        return reverseStr;
    }
}

// END
