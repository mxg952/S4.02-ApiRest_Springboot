package cat.itacademy.s04.t02.n03.exception;

public class InvalidDataException extends RuntimeException {
    private final String code;

    public InvalidDataException(String code, String message) {
        super(message);
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
