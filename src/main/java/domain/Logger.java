package domain;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static model.LogLevelModel.*;

public class Logger {

    public void logMessage(String fileName, String message, String level) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String logEntry = String.format("[%s] [%s] %s%n", timestamp, level, message);
        File logFile = new File("src/main/resources/logs",fileName);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(logFile, true))) {
            writer.write(logEntry);
        } catch (IOException e) {
            System.out.println("Error while writing log file " + e.getMessage());;
        }
    }

    public static void main(String[] args) {
        Logger logger = new Logger();
        logger.logMessage("application.log", "User logged in", INFO);
        logger.logMessage("application.log", "Failed login attempt", WARNING);
        logger.logMessage("application.log", "User deactivated", ERROR);
    }
}
