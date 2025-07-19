package org.example.classes;

//level 3
public class ErrorConsoleLogger extends Logger
{

    @Override
    protected boolean canHandle(int loggerLevel) {
        if (loggerLevel == LogLevel.ERRORCONSOLE.ordinal())
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
        System.out.println("Сообщение " +  message + " обработано ErrorConsoleLogger");
    }
}
