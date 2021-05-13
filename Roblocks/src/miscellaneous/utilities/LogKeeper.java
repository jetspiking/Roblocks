package miscellaneous.utilities;

import miscellaneous.models.LogMessage;
import userinterface.interfaces.ILogObserver;

import java.util.ArrayList;

/**
This class keeps track of multiple logs.
*/

public class LogKeeper {
    private ArrayList<LogMessage> logList = new ArrayList<>();
    private ILogObserver logObserver;

    /**
     * Construct a LogKeeper for storing messages.
     * @param logObserver Needed to notify changes, when an item is added this observer is called.
     */

    public LogKeeper(ILogObserver logObserver) {
        this.logObserver = logObserver;
    }

    /**
     * Add a LogMessage.
     * @param logMessage LogMessage instance.
     */

    public void add(LogMessage logMessage) {
        logList.add(logMessage);
        logObserver.update();
    }

    /**
     * Clear all logs.
     */

    public void clear() {
        logList.clear();
    }

    /**
     * Get all logs.
     * @return List of logs.
     */

    public ArrayList<LogMessage> get() {
        return logList;
    }

    /**
     * Get the item count of the log ArrayList.
     * @return Size of log-array.
     */

    public int logSize() {
        return logList.size();
    }

    /**
     * Get a log by index.
     * @param index Index of the log you want to retrieve.
     * @return Log by index.
     */

    public LogMessage getLog(int index) {
        return logList.get(index);
    }

    /**
     * Returns the last known log. If no logs are present, returns null.
     * @return Last known log.
     */

    public LogMessage lastLog() {
        return logList.size()>0?logList.get(logList.size()-1):null;
    }
}
