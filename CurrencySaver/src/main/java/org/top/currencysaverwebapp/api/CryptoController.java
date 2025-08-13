package org.top.currencysaverwebapp.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.top.currencysaverwebapp.dto.CryptocurrencyDto;
import org.top.currencysaverwebapp.entity.Cryptocurrency;
import org.top.currencysaverwebapp.service.CryptoService;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/crypto")
@Tag(name = "Crypto Controller", description = "Контроллер для работы с криптовалютами")
public class CryptoController {

    private final CryptoService cryptoService;

    public CryptoController(CryptoService cryptoService) {
        this.cryptoService = cryptoService;
    }

    @PostMapping("/autostart")
    @Operation(summary = "Установка автоматического запуска background сервиса")
    public ResponseEntity<String> setAutostart(@RequestParam boolean autostart) throws IOException {
        cryptoService.setAutostart(autostart);
        return ResponseEntity.ok("Autostart set to " + autostart);
    }

    @PostMapping("/setdelay")
    @Operation(summary = "Установка задержки опроса в секундах")
    public ResponseEntity<String> setDelay(@RequestParam int delay) throws IOException {
        cryptoService.setDelay(delay);
        return ResponseEntity.ok("Delay set to " + delay + " seconds");
    }

    @PostMapping("/start")
    @Operation(summary = "Запуск бэкграунд сервиса")
    public ResponseEntity<String> start() throws IOException {
        cryptoService.start();
        return ResponseEntity.ok("Service started");
    }

    @PostMapping("/stop")
    @Operation(summary = "Остановка бэкграунд сервиса")
    public ResponseEntity<String> stop() {
        cryptoService.stop();
        return ResponseEntity.ok("Service stopped");
    }

    @GetMapping("/status")
    @Operation(summary = "Показать статус бэкграунд сервиса")
    public ResponseEntity<String> getStatus() {
        return ResponseEntity.ok(cryptoService.getStatus());
    }

    @GetMapping("/gettop200")
    @Operation(summary = "Получение топ 200 криптовалют")
    public ResponseEntity<List<Cryptocurrency>> getTop200() throws IOException {
        return ResponseEntity.ok(cryptoService.getTop200());
    }

    @GetMapping("/gettop200andsave")
    @Operation(summary = "Получение топ 200 криптовалют и запись в БД")
    public ResponseEntity<List<Cryptocurrency>> getTop200AndSave() throws IOException {
        return ResponseEntity.ok(cryptoService.getTop200AndSave());
    }

    @GetMapping("/gettop100frombd")
    @Operation(summary = "Получение топ 100 криптовалют из БД")
    public ResponseEntity<List<CryptocurrencyDto>> getTop100FromDb() {
        return ResponseEntity.ok(cryptoService.getTop100FromDb());
    }

    @GetMapping("/getbyname")
    @Operation(summary = "Получение конкретной криптовалюты по имени")
    public ResponseEntity<CryptocurrencyDto> getByName(@RequestParam String name) {
        Optional<CryptocurrencyDto> cryptocurrency = cryptoService.getByName(name);
        return cryptocurrency.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
