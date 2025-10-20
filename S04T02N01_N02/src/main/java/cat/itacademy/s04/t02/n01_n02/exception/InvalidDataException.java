package cat.itacademy.s04.t02.n01_n02.exception;

public class InvalidDataException extends RuntimeException {
  public InvalidDataException(String message) {
    super(message);
  }
}
