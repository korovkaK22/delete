package exceptions;

public class FullVehicleException extends Exception{
    public FullVehicleException() {
    }

    public FullVehicleException(String message) {
        super(message);
    }

    public FullVehicleException(String message, Throwable cause) {
        super(message, cause);
    }

    public FullVehicleException(Throwable cause) {
        super(cause);
    }

    public FullVehicleException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
