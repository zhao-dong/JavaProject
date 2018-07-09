package Util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

/**
 * Created by dong.zhao on 2018/1/19.
 */


class LoggingException extends Exception {
    private static Logger logger = Logger.getLogger("LoggingException");
    public LoggingException() {
        StringWriter trace = new StringWriter();
        printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }
}

public class p253LoggingExceptions {
    public static void main(String[] args)
    {
        try
        {
            throw new LoggingException();
        } catch(LoggingException e)
        {
            System.err.println("Caught " + e);
        }

        try
        {
            throw new LoggingException();
        } catch(LoggingException e)
        {
            System.err.println("Caught " + e);
        }
    }
}
