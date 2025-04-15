package javaoopCoding.pattern.strategy;

import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * @author trinapal
 */

enum LogLevel{
    INFO, WARNING,ERROR
}

interface  LogStrategy{
    void log(LogLevel level, String message);
}

class ConsoleLogger implements  LogStrategy{

    @Override
    public void log(LogLevel level, String message) {
        Logger logger = Logger.getLogger("Console log");
        System.out.println("[" + level + "] " + message);
    }
}

class FileLogger implements LogStrategy{
    private final String filePath;

    FileLogger(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void log(LogLevel level, String message) {
        try{
            FileWriter fw = new FileWriter(filePath, true);
            fw.write("[" + level + "] " + message + "\n");
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
class LoggerContext{
    private LogStrategy logStrategy;

    LoggerContext(LogStrategy logStrategy){
        this.logStrategy = logStrategy;
    }

    public void setLogStrategy(LogStrategy strategy){
        this.logStrategy = strategy;
    }

    public void log(String message, LogLevel level){
        logStrategy.log(level,message);
    }
}

public class Main {
    public static void main(String[] args) {
    LoggerContext loggerContext = new LoggerContext(new ConsoleLogger());
    loggerContext.log("This is an info message", LogLevel.INFO);
    loggerContext.setLogStrategy(new FileLogger("app.log"));
    loggerContext.log("This is a warning message", LogLevel.WARNING);
    }
}
