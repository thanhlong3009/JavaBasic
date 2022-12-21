package employee_manager.exception;

public class InValidSalaryException extends RuntimeException{
    public InValidSalaryException(String message) {
        super(message);
    }
}
