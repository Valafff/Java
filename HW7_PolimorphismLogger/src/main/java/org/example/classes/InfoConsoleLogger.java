package org.example.classes;

//level 1
public class InfoConsoleLogger extends Logger
{

    @Override
    protected boolean canHandle(int loggerLevel) {
        if (loggerLevel == LogLevel.INFOCONSOLE.ordinal())
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
        System.out.println("Сообщение " +  message + " обработано InfoConsoleLogger");
    }
}
