// Write a class for an InvalidIntegerException here
class InvalidIntegerException extends Exception {
    private String message;
    public InvalidIntegerException() {
        super();
    }
    public InvalidIntegerException(String message) {
        super(message);
    }
}