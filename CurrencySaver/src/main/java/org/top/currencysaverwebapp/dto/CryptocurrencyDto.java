package org.top.currencysaverwebapp.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;
import java.util.Comparator;

@Schema(description = "DTO для криптовалюты")
public class CryptocurrencyDto implements Comparable<CryptocurrencyDto>
{
    @Schema(description = "Название криптовалюты", example = "Bitcoin")
    private String name;
    @Schema(description = "Текущая цена", example = "65000.0")
    private Double currentPrice;
    @Schema(description = "Время последнего обновления")
    private LocalDateTime lastUpdated;

    public CryptocurrencyDto(String name, Double currentPrice, LocalDateTime lastUpdated) {
        this.name = name;
        this.currentPrice = currentPrice;
        this.lastUpdated = lastUpdated;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(Double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @Override
    public int compareTo(CryptocurrencyDto other) {
        if (this.lastUpdated == null && other.lastUpdated == null) {
            return 0;
        }
        if (this.lastUpdated == null) {
            return 1;
        }
        if (other.lastUpdated == null) {
            return -1;
        }
        return this.lastUpdated.compareTo(other.lastUpdated);
    }

}
