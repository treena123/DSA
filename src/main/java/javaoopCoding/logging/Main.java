package javaoopCoding.logging;

import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.FileHandler;
/**
 * @author trinapal
 */

enum LogLevel{
    INFO, WARNING, ERROR
}

interface InfoLogger {

    Logger logger = Logger.getLogger("Info");
    default void logInfo(String message){
        logger.info(message);
    }
    default void log(String message, LogLevel level){
        logger.log(Level.INFO,message);
    }
}

interface ErrorLogger {
    Logger log = Logger.getLogger("error");

    default void logError(String message){
        log.log(Level.SEVERE, message);
    }
    default void log(String message, LogLevel level){
        log.log(Level.SEVERE,message);
    }
}

interface WarningLogger {

    Logger log = Logger.getLogger("Warning");

    default void logWarning(String message){
        log.warning(message);
    }
    default void log(String message, LogLevel level){
        log.log(Level.WARNING,message);
    }
}


class ConsoleLogger implements InfoLogger,WarningLogger,ErrorLogger{
    private LogLevel threshold;

    ConsoleLogger(LogLevel threshold){
        this.threshold = threshold;
    }

    @Override
    public void logError(String message) {
        ErrorLogger.super.logError(message);
    }

    @Override
    public void logInfo(String message) {
        InfoLogger.super.logInfo(message);
    }

    @Override
    public void log(String message, LogLevel level) {
        if(level.ordinal() >= threshold.ordinal()){
            switch(level){
                case WARNING -> WarningLogger.super.log(message, level);
                case ERROR -> ErrorLogger.super.log(message, level);
                case INFO -> InfoLogger.super.log(message, level);
            }
        }


    }

    @Override
    public void logWarning(String message) {
        WarningLogger.super.logWarning(message);
    }
}

class FileLogger implements InfoLogger{
    static{
        try {
            Logger logger = Logger.getLogger("Info");
            FileHandler fileHandler = new FileHandler("app.log", true);
            logger.addHandler(fileHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        ConsoleLogger consoleLogger = new ConsoleLogger(LogLevel.ERROR);
        consoleLogger.logError("error");
        consoleLogger.log( "info test",LogLevel.INFO);
        consoleLogger.logWarning("warning");
        consoleLogger.logInfo("info");
        FileLogger fileLogger = new FileLogger();
        fileLogger.log("info", LogLevel.INFO);
    }
}
