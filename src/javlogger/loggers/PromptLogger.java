package javlogger.loggers;

import javlogger.utils.JaVlogger;

public class PromptLogger extends JaVlogger {

    @Override
    protected void logImplementation(String message) {
        System.out.println(message);
    }
}
