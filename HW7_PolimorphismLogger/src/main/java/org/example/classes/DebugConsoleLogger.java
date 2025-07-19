package org.example.classes;

//level 0
public class DebugConsoleLogger extends Logger
{

    @Override
    protected boolean canHandle(int loggerLevel) {
        if (loggerLevel == LogLevel.DEBUGCONSOLE.ordinal())
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    protected void logMessage(String message)
    {
        System.out.println("Сообщение " +  message + " обработано DebugConsoleLogger");
    }
}
