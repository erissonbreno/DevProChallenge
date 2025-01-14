import com.github.javafaker.Faker;
import domain.Logger;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoggerTest {

    private static final String TEST_FILE = "loggerTest.log";
    private static final String DIRECTORY_PATH = "src/main/resources/logs";
    Faker faker = new Faker();
    Logger logger = new Logger();

    @Test
    void shouldAppendLogEntryToFile() throws IOException {
        int salt = faker.number().numberBetween(1000, 9999);

        logger.logMessage(TEST_FILE, "Test log entry " + salt, "INFO");
        String log = Files.readString(Path.of(DIRECTORY_PATH, TEST_FILE));

        assertTrue(log.contains("[INFO] Test log entry " + salt));
    }
}
