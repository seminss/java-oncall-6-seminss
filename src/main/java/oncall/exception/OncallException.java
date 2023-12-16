package oncall.exception;

public class OncallException extends IllegalArgumentException {
    public OncallException(String message) {
        super("[ERROR] " + message);
    }
}
