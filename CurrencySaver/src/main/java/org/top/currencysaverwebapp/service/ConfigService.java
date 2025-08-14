package org.top.currencysaverwebapp.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.stereotype.Service;
import org.top.currencysaverwebapp.model.Config;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;


@Service
public class ConfigService {

//    private static final String CONFIG_FILE = "./src/main/resources/config.json";
    private static final String CONFIG_FILE = "./resources/config.json"; // Для контейнера
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public Config loadConfig() throws IOException {
        try (Reader reader = new FileReader(CONFIG_FILE)) {
            return gson.fromJson(reader, Config.class);
        }
    }

    public void saveConfig(Config config) throws IOException {
        try (Writer writer = new FileWriter(CONFIG_FILE)) {
            gson.toJson(config, writer);
        }
    }
}


//@Service
//public class ConfigService {
//
//    private static final String CONFIG_FILE = "src/main/resources/config.json";
//    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();
//
//    public Config loadConfig() throws IOException {
//        try (Reader reader = new FileReader(CONFIG_FILE)) {
//            return gson.fromJson(reader, Config.class);
//        }
//    }
//
//    public void saveConfig(Config config) throws IOException {
//        try (Writer writer = new FileWriter(CONFIG_FILE)) {
//            gson.toJson(config, writer);
//        }
//    }
//}
