package miscellaneous.models;

/**
This class keeps track of a String and type, so that the application can store and potentially log messages.
*/

public class LogMessage {

    /**
     * LogMessageType specifies whether a LogMessage is an error, debug or verbose message.
     */

    public enum LogMessageType {
        ERROR,                                                          // For errors.
        DEBUG,                                                          // For debugging.
        VERBOSE                                                         // For verbose.
    }

    public final String message;                                        // Stores the message as a string.
    public final LogMessageType logMessageType;                         // Type should be ERROR, DEBUG, or VERBOSE.

    /**
     * Construct a LogMessage
     * @param message This is the message string.
     * @param logMessageType This is the type of the message, i.e. ERROR, DEBUG or VERBOSE.
     */

    public LogMessage(String message, LogMessageType logMessageType) {
        this.message = message;
        this.logMessageType = logMessageType;
    }
}
