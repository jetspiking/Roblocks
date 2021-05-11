package miscellaneous.utilities;

import userinterface.fragments.ToolboxFragment;

import java.io.*;

public class SystemConfigurationReader {

    private FileStatus fileStatus;
    private File systemConfiguration;

    public enum FileStatus {
        FOUND,
        NOT_FOUND,
        IO_EXCEPTION
    }

    public SystemConfigurationReader(String filePath) {
        InputStream inputStream = null;
        try {
            systemConfiguration = new File(filePath);
            inputStream = new FileInputStream(systemConfiguration);
            fileStatus=FileStatus.FOUND;
        } catch (FileNotFoundException e) {
            fileStatus=FileStatus.NOT_FOUND;
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    fileStatus=FileStatus.IO_EXCEPTION;
                }
            }
        }
    }

    public File getFile() {
        return this.systemConfiguration;
    }

    public FileStatus getFileStatus() {
        return fileStatus;
    }
}
