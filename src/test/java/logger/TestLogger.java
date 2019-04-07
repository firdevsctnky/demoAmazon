package logger;

import org.apache.log4j.Logger;

/**
 * Created by Bruce Wayne on 12/5/2016.
 */
public class TestLogger {

    public static Logger logger = Logger.getLogger(TestLogger.class);

    private static TestLogger instance = null;

    protected TestLogger() {
        // Exists only to defeat instantiation.
    }

    public static TestLogger getInstance() {
        if(instance == null) {
            instance = new TestLogger();
        }
        return instance;
    }

    public void log(String message){
        logger.info(message);
    }
}