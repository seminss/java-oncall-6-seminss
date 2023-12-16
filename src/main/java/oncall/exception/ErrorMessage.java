package oncall.exception;

public enum ErrorMessage {
    INVALID_VALUE("유효하지 않은 입력입니다."),
    ;
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
