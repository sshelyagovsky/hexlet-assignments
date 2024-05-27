package exercise;

// BEGIN
public class NegativeRadiusException extends Exception {
    public static final NegativeRadiusException INVALID_ARITHMETIC_ERROR =
            new NegativeRadiusException("Не удалось посчитать площадь");

    public NegativeRadiusException(String message) {
        super(message);
    }

    public String getErrorDescription() {
        return this.getMessage();
    }
}
// END
