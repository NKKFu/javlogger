package javlogger.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

// Validator class has a generic type T which is a class that implements IValidation
public abstract class JaVlogger {
    private String formatLog(String message) {
        // Get current day time
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ")
            .format(Calendar.getInstance().getTime());
        return "[" + timeStamp + "] " + this.getClass().getSimpleName() + ": " + message;
    }

    public void log(String message) {
        logImplementation(formatLog(message));
    }

    protected abstract void logImplementation(String message);
}
