@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public String handleException(RuntimeException ex) {
        return ex.getMessage();
    }
}
