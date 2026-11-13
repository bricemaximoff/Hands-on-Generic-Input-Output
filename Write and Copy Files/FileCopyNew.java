package handson7.src.file_io;

import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.util.Collections;

public class FileCopyNew {
    public static void main(String[] args) {
        Path source = Paths.get("report.txt");
        Path backup = Paths.get("backup/report.txt");
        Path logFile = Paths.get("log.txt");

        try {
            Files.write(source, java.util.List.of("Report Generated", "Status: OK"));
            
            if (Files.notExists(backup.getParent())) {
                Files.createDirectories(backup.getParent());
            }

            String logMessage = "";
            if (Files.exists(source)) {
                Files.copy(source, backup, StandardCopyOption.REPLACE_EXISTING);
                logMessage = "[" + LocalDateTime.now() + "] Backup created successfully from " + source + " to " + backup;
                System.out.println(logMessage);
            } else {
                logMessage = "[" + LocalDateTime.now() + "] Failed to backup: Source file does not exist.";
                System.out.println(logMessage);
            }
            
            Files.write(logFile, Collections.singletonList(logMessage), StandardOpenOption.CREATE, StandardOpenOption.APPEND);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
