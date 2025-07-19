package org.example.classes;

public abstract class Logger
{
    protected Logger nextLogger;

    public void setNextLogger(Logger nextLogger)
    {
        this.nextLogger = nextLogger;
    }

    abstract protected boolean canHandle(int loggerLevel);
    abstract protected void logMessage(String message);

    public void logMessage(String message, int loggerLevel)
    {
        if (message == null)
        {
            System.out.println("Message is null!");
            return;
        }
        if (canHandle(loggerLevel))
        {
            logMessage(message);
        }
        else if (nextLogger != null)
        {
            nextLogger.logMessage(message, loggerLevel);
        }
    }
}
