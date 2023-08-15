package javlogger.loggers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javlogger.utils.JaVlogger;

public class TextLogger extends JaVlogger {
    private String path = null;

    public TextLogger(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public void log(String message) {
        message = formatLog(message);
        if (path == null) {
            throw new RuntimeException("Path is not set");
        }

        // Create or open a file
        File logFile = new File(path);
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
