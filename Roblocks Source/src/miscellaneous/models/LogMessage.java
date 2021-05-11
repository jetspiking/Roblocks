package miscellaneous.models;

public class LogMessage {

    public enum LogMessageType {
        ERROR,
        DEBUG,
        VERBOSE
    }

    public final String message;
    public final LogMessageType logMessageType;

    public LogMessage(String message, LogMessageType logMessageType) {
        this.message = message;
        this.logMessageType = logMessageType;
    }
}
