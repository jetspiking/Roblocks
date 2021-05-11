package miscellaneous.utilities;

import miscellaneous.models.LogMessage;
import userinterface.interfaces.ILogObserver;

import java.util.ArrayList;

public class LogKeeper {
    private ArrayList<LogMessage> logList = new ArrayList<>();
    private ILogObserver logObserver;

    public LogKeeper(ILogObserver logObserver) {
        this.logObserver = logObserver;
    }

    public void add(LogMessage logMessage) {
        logList.add(logMessage);
        logObserver.update();
    }

    public void clear() {
        logList.clear();
    }

    public ArrayList<LogMessage> get() {
        return logList;
    }

    public int logSize() {
        return logList.size();
    }

    public LogMessage getLog(int index) {
        return logList.get(index);
    }

    public LogMessage lastLog() {
        return logList.size()>0?logList.get(logList.size()-1):null;
    }
}
