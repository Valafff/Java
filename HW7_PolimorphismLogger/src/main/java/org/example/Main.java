package org.example;
import org.example.classes.*;


public class Main {
    public static void main(String[] args)
    {
        Logger logger = new DebugConsoleLogger();
        Logger infoConsoleLogger = new InfoConsoleLogger();
        Logger infoFileLogger = new InfoFileLogger();
        Logger errorConsoleLogger = new ErrorConsoleLogger();
        Logger errorFileLogger = new ErrorFileLogger();

        //Настройка цепочки обязанностей
        logger.setNextLogger(infoConsoleLogger);
        infoConsoleLogger.setNextLogger(infoFileLogger);
        infoFileLogger.setNextLogger(errorConsoleLogger);
        errorConsoleLogger.setNextLogger(errorFileLogger);

        //Проверка
        logger.logMessage("Привет мир!", LogLevel.DEBUGCONSOLE.ordinal());
        logger.logMessage("Hello world!", LogLevel.INFOCONSOLE.ordinal());
        logger.logMessage("Hola, mundo!", LogLevel.INFOFILE.ordinal());
        logger.logMessage("Bonjour, le monde!", LogLevel.ERRORCONSOLE.ordinal());
        logger.logMessage("Hallo, Welt!", LogLevel.ERRORFILE.ordinal());

    }
}