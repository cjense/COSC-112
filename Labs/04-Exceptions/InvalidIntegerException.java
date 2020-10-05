// Write a class for an InvalidIntegerException here
public InvalidIntegerException extends Exception {
    private String message;
    public InvalidIntegerException() {

    }
    public InvalidIntegerException(String message) {
        this.message = message;
    }
}