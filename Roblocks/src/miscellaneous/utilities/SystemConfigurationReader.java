package miscellaneous.utilities;

import java.io.*;
import java.util.Scanner;

/**
 * The SystemConfigurationReader attempts to find a JSON-data file from disk.
 */

public class SystemConfigurationReader {

    private FileStatus fileStatus;
    private File systemConfiguration;

    /**
     * The FileStatus can either be FOUND, NOT_FOUND, or IO_EXCEPTION.
     */

    public enum FileStatus {
        FOUND,
        NOT_FOUND,
        IO_EXCEPTION,
    }

    /**
     * Construct a SystemConfigurationReader.
     * @param filePath Path to file on disk.
     */

    public SystemConfigurationReader(String filePath) {
        try {
            systemConfiguration = new File(filePath);

            if (systemConfiguration.exists())
                fileStatus=FileStatus.FOUND;
            else fileStatus=FileStatus.NOT_FOUND;

        } catch (Exception e) { fileStatus = FileStatus.IO_EXCEPTION; }
    }

    /**
     * Return file as string.
     * @return String of JSON-data file.
     */

    public String getFileAsString() {
        StringBuilder json = new StringBuilder();
        try {
            Scanner scanner = new Scanner(systemConfiguration);
            while(scanner.hasNext()) {
                json.append(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return json.toString();
    }

    /**
     * Get the system configuration file.
     * @return File instance of configuration file on disk.
     */

    public File getFile() {
        return this.systemConfiguration;
    }

    /**
     * Get the FileStatus.
     * @return FileStatus after construction.
     */

    public FileStatus getFileStatus() {
        return fileStatus;
    }
}
