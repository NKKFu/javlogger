package javlogger.loggers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javlogger.utils.JaVlogger;

public class TextLogger extends JaVlogger {
    private String path = null;

    public TextLogger(String path) {
        if (path == null) {
            path = System.getProperty("java.io.tmpdir");
        }
        this.path = Paths.get(path, getLoggerName()).toString();
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getLoggerName() {
        String currentYearMonthDayAndHour = new SimpleDateFormat("yyyy-MM-dd_HH_mm")
                .format(Calendar.getInstance().getTime());
        return "javlogger." + currentYearMonthDayAndHour + ".log";
    }

    @Override
    protected void logImplementation(String message) {
        // Create or open a file
        File logFile = Paths.get(path).toFile();
        try {
            // if a file already exists it will do nothing
            logFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Write a message appending it
        try (FileOutputStream oFile = new FileOutputStream(logFile, true)) {
            oFile.write((message + "\n").getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
