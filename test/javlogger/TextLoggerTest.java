package test.javlogger;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Test;

import javlogger.loggers.TextLogger;
import junit.framework.TestCase;

public class TextLoggerTest extends TestCase {

    @Test
    public void testTextLogger() {
        String testMsg = "Hi world!";

        String path = System.getProperty("java.io.tmpdir");
        new File(path).delete();

        TextLogger logger = new TextLogger(path);
        logger.log(testMsg);

        // Read file and assert they're equals
        File file = Paths.get(logger.getPath()).toFile();
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
