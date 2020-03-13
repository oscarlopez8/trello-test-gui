package utils;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log {
    private static Logger logger = Logger.getLogger(Log.class);
    private static Log loggerInstance;

    /**
     * Initializes LogManager.
     */
    private Log() {
        initLogManager();
    }

    /**
     * Sets configurations for log and the level.
     */
    public void initLogManager() {
        PropertyConfigurator.configure("log4j.properties");
        logger.setLevel(Level.ALL);
    }

    /**
     * Allows to get the only instance of LogManager.
     *
     * @return loggerInstance.
     */
    public static Log getInstance() {
        if (loggerInstance == null) {
            loggerInstance = new Log();
        }
        return loggerInstance;
    }

    /**
     * Allows to get the log.
     *
     * @return logger.
     */
    public Logger getLogger() {
        return logger;
    }
}
