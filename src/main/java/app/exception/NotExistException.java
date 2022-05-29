package app.exception;

public class NotExistException extends Exception {

  public NotExistException(String objectName) {
    super(objectName + " does not exist!");
  }
}
