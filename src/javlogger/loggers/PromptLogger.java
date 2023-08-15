package javlogger.loggers;

import javlogger.utils.JaVlogger;

public class PromptLogger extends JaVlogger {

    @Override
    public void log(String message) {
        message = formatLog(message);
        System.out.println(message);
    }
}
