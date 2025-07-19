package org.example.classes;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

//level 4
public class ErrorFileLogger extends Logger
{
    @Override
    protected boolean canHandle(int loggerLevel) {
        if (loggerLevel == LogLevel.ERRORFILE.ordinal())
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
        String path = "errorLog.txt";
        try (PrintWriter pw = new PrintWriter(new FileWriter(path, true)))
        {
            pw.print(message + "\n");
        }
        catch (IOException ex)
        {
            System.out.println("file exception: " + ex.getMessage());
        }
        System.out.println("Сообщение " + message + " записано в errorLog.txt");
    }
}
