package org.top.currencysaverwebapp.service;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.google.gson.Gson;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.top.currencysaverwebapp.dto.CryptocurrencyDto;
import org.top.currencysaverwebapp.entity.Cryptocurrency;
import org.top.currencysaverwebapp.model.Config;
import org.top.currencysaverwebapp.repository.CryptocurrencyRepository;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ScheduledFuture;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;



@Service
public class CryptoService {

    private final CryptocurrencyRepository cryptocurrencyRepository;
    private final ConfigService configService;
    private final RestTemplate restTemplate;
    private final Gson gson;
    private final TaskScheduler taskScheduler;
    private final String apiKey;

    private ScheduledFuture<?> scheduledTask;
    private boolean isServiceRunning = false;

    public CryptoService(CryptocurrencyRepository cryptocurrencyRepository, ConfigService configService, TaskScheduler taskScheduler, @Value("${API_KEY}") String apiKey) {
        this.cryptocurrencyRepository = cryptocurrencyRepository;
        this.configService = configService;
        this.taskScheduler = taskScheduler;
        this.restTemplate = new RestTemplate();
        this.gson = new Gson();
        this.apiKey = apiKey;
        System.out.println("Значение переменной apiKey : " + apiKey);
    }

    @PostConstruct
    public void init() throws IOException {
        Config config = configService.loadConfig();
        if (config.isAutostart()) {
            start();
        }
    }


    public List<Cryptocurrency> getTop200() throws IOException {
        Config config = configService.loadConfig();
        String url = config.getService_urls().get(0) + "&key=" + apiKey;
        String response = restTemplate.getForObject(url, String.class);

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        List<Cryptocurrency> cryptocurrencies = mapper.readValue(
                response,
                mapper.getTypeFactory().constructCollectionType(List.class, Cryptocurrency.class)
        );


        return  cryptocurrencies;

    }


    public List<Cryptocurrency> getTop200AndSave() throws IOException {
        List<Cryptocurrency> cryptocurrencies = getTop200();
        cryptocurrencyRepository.saveAll(cryptocurrencies);
        return cryptocurrencies;
    }

    public void start() throws IOException {
        if (isServiceRunning) {
            return;
        }
        Config config = configService.loadConfig();
        scheduledTask = taskScheduler.scheduleAtFixedRate(() -> {
            CompletableFuture.runAsync(() -> {
                try {
                    getTop200AndSave();
                } catch (IOException e) {
//                    logger.error("Async task failed", e);
                }
            });
        }, Duration.ofSeconds(config.getPoll_interval()));
        isServiceRunning = true;
    }

    public void stop() {
        if (scheduledTask != null && !scheduledTask.isCancelled()) {
            scheduledTask.cancel(false);
        }
        isServiceRunning = false;
    }

    public String getStatus() {
        return isServiceRunning ? "RUNNING" : "STOPPED";
    }

    public void setAutostart(boolean autostart) throws IOException {
        Config config = configService.loadConfig();
        config.setAutostart(autostart);
        configService.saveConfig(config);
    }

    public void setDelay(int delay) throws IOException {
        Config config = configService.loadConfig();
        config.setPoll_interval(delay);
        configService.saveConfig(config);
        if (isServiceRunning) {
            stop();
            start();
        }
    }

    public List<CryptocurrencyDto> getTop100FromDb() {

//        return cryptocurrencyRepository.findTop100ByOrderByMarketCapRankAsc().stream()
//                .map(c -> new CryptocurrencyDto(c.getName(), c.getCurrentPrice(), c.getLastUpdated()))
//                .collect(Collectors.toList()).stream().distinct().toList();

//        return cryptocurrencyRepository.findAll().stream()
//                .collect(Collectors.toMap(
//                        Cryptocurrency::getName,
//                        Function.identity(),
//                        (existing, replacement) ->
//                                existing.getLastUpdated().isAfter(replacement.getLastUpdated())
//                                        ? existing
//                                        : replacement
//                ))
//                .values()
//                .stream()
//                .map(c -> new CryptocurrencyDto(
//                        c.getName(),
//                        c.getCurrentPrice(),
//                        c.getLastUpdated()
//                ))
//                .toList();



        return cryptocurrencyRepository.findLatestDistinctCurrencies().stream()
                .map(c -> new CryptocurrencyDto(
                        c.getName(),
                        c.getCurrentPrice(),
                        c.getLastUpdated()
                ))
                .toList();
    }

    public Optional<CryptocurrencyDto> getByName(String name) {

        var tmp = cryptocurrencyRepository.findFirstByNameOrderByLastUpdatedStringDesc(name);
        return  tmp.map(c -> new CryptocurrencyDto(c.getName(), c.getCurrentPrice(), c.getLastUpdated()));

    }
}
