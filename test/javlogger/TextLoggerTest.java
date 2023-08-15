package test.javlogger;

import java.io.File;
import java.nio.file.Files;

import org.junit.Test;

import javlogger.loggers.TextLogger;
import junit.framework.TestCase;

public class TextLoggerTest extends TestCase {

    @Test
    public void testTextLogger() {
        String testMsg = "Hi world!";

        String tmpdir = System.getProperty("java.io.tmpdir");
        String filePath = tmpdir + "/javlogger.log";
        new File(filePath).delete();

        TextLogger logger = new TextLogger(filePath);
        logger.log(testMsg);

        // Read file and assert they're equals
        File file = new File(filePath);
        assertTrue(file.exists());
        assertTrue(file.isFile());
        assertTrue(file.canRead());

        try {
            String content = new String(Files.readAllBytes(file.toPath()));
            assertTrue(content.contains(testMsg));
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
}
