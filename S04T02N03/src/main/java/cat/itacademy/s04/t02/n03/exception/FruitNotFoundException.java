package cat.itacademy.s04.t02.n03.exception;

public class FruitNotFoundException extends RuntimeException {
    private final String code;

    public FruitNotFoundException(String code, String message) {
        super(message);
        this.code = code;
    }
    public String getCode() {
        return code;
    }
    
}
