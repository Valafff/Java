package org.top.currencysaverwebapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import io.swagger.v3.oas.annotations.media.Schema;


@Entity
@Table(name = "cryptocurrency")
@JsonIgnoreProperties(ignoreUnknown = true)
@Schema(description = "Сущность криптовалюты")
public class Cryptocurrency
{

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ISO_DATE_TIME;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "database_id", nullable = false)
    @JsonIgnore
    private Long databaseId;

    @Column(name = "full_name", nullable = false)
    @JsonProperty("id")
    @Schema(description = "Идентификатор", example = "bitcoin")
    private String id;

    @Column(name = "symbol", nullable = false)
    @JsonProperty("symbol")
    @Schema(description = "Символ", example = "btc")
    private String symbol;

    @Column(name = "name", nullable = false)
    @JsonProperty("name")
    @Schema(description = "Название", example = "Bitcoin")
    private String name;

    @Column(name = "image_url")
    @JsonProperty("image")
    @Schema(description = "URL изображения")
    private String image;

    @Column(name = "current_price")
    @JsonProperty("current_price")
    @Schema(description = "Текущая цена")
    private Double currentPrice;

    @Column(name = "market_cap")
    @JsonProperty("market_cap")
    @Schema(description = "Рыночная капитализация")
    private Double marketCap;

    @Column(name = "market_cap_rank")
    @JsonProperty("market_cap_rank")
    @Schema(description = "Ранг по рыночной капитализации")
    private Integer marketCapRank;

    @Column(name = "fully_diluted_valuation")
    @JsonProperty("fully_diluted_valuation")
    @Schema(description = "Полностью разводненная оценка")
    private Double fullyDilutedValuation;

    @Column(name = "total_volume")
    @JsonProperty("total_volume")
    @Schema(description = "Общий объем")
    private Double totalVolume;

    @Column(name = "high_24h")
    @JsonProperty("high_24h")
    @Schema(description = "Максимум за 24 часа")
    private Double high24h;

    @Column(name = "low_24h")
    @JsonProperty("low_24h")
    @Schema(description = "Минимум за 24 часа")
    private Double low24h;

    @Column(name = "price_change_24h")
    @JsonProperty("price_change_24h")
    @Schema(description = "Изменение цены за 24 часа")
    private Double priceChange24h;

    @Column(name = "price_change_percentage_24h")
    @JsonProperty("price_change_percentage_24h")
    @Schema(description = "Процентное изменение цены за 24 часа")
    private Double priceChangePercentage24h;

    @Column(name = "market_cap_change_24h")
    @JsonProperty("market_cap_change_24h")
    @Schema(description = "Изменение рыночной капитализации за 24 часа")
    private Double marketCapChange24h;

    @Column(name = "market_cap_change_percentage_24h")
    @JsonProperty("market_cap_change_percentage_24h")
    @Schema(description = "Процентное изменение рыночной капитализации за 24 часа")
    private Double marketCapChangePercentage24h;

    @Column(name = "circulating_supply")
    @JsonProperty("circulating_supply")
    @Schema(description = "Циркулирующее предложение")
    private Double circulatingSupply;

    @Column(name = "total_supply")
    @JsonProperty("total_supply")
    @Schema(description = "Общее предложение")
    private Double totalSupply;

    @Column(name = "max_supply")
    @JsonProperty("max_supply")
    @Schema(description = "Максимальное предложение")
    private Double maxSupply;

    @Column(name = "ath")
    @JsonProperty("ath")
    @Schema(description = "Исторический максимум")
    private Double ath;

    @Column(name = "ath_change_percentage")
    @JsonProperty("ath_change_percentage")
    @Schema(description = "Процентное изменение от исторического максимума")
    private Double athChangePercentage;

    @Column(name = "ath_date_string")
    @JsonProperty("ath_date")
    @Schema(description = "Дата исторического максимума")
    private String athDateString;

    @Column(name = "atl")
    @JsonProperty("atl")
    @Schema(description = "Исторический минимум")
    private Double atl;

    @Column(name = "atl_change_percentage")
    @JsonProperty("atl_change_percentage")
    @Schema(description = "Процентное изменение от исторического минимума")
    private Double atlChangePercentage;

    @Column(name = "atl_date_string")
    @JsonProperty("atl_date")
    @Schema(description = "Дата исторического минимума")
    private String atlDateString;

    @Column(name = "last_updated_string")
    @JsonProperty("last_updated")
    @Schema(description = "Время последнего обновления")
    private String lastUpdatedString;

    public Cryptocurrency() {
    }

    public Long getDatabaseId() {
        return databaseId;
    }

    public void setDatabaseId(Long databaseId) {
        this.databaseId = databaseId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(Double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public Double getMarketCap() {
        return marketCap;
    }

    public void setMarketCap(Double marketCap) {
        this.marketCap = marketCap;
    }

    public Integer getMarketCapRank() {
        return marketCapRank;
    }

    public void setMarketCapRank(Integer marketCapRank) {
        this.marketCapRank = marketCapRank;
    }

    public Double getFullyDilutedValuation() {
        return fullyDilutedValuation;
    }

    public void setFullyDilutedValuation(Double fullyDilutedValuation) {
        this.fullyDilutedValuation = fullyDilutedValuation;
    }

    public Double getTotalVolume() {
        return totalVolume;
    }

    public void setTotalVolume(Double totalVolume) {
        this.totalVolume = totalVolume;
    }

    public Double getHigh24h() {
        return high24h;
    }

    public void setHigh24h(Double high24h) {
        this.high24h = high24h;
    }

    public Double getLow24h() {
        return low24h;
    }

    public void setLow24h(Double low24h) {
        this.low24h = low24h;
    }

    public Double getPriceChange24h() {
        return priceChange24h;
    }

    public void setPriceChange24h(Double priceChange24h) {
        this.priceChange24h = priceChange24h;
    }

    public Double getPriceChangePercentage24h() {
        return priceChangePercentage24h;
    }

    public void setPriceChangePercentage24h(Double priceChangePercentage24h) {
        this.priceChangePercentage24h = priceChangePercentage24h;
    }

    public Double getMarketCapChange24h() {
        return marketCapChange24h;
    }

    public void setMarketCapChange24h(Double marketCapChange24h) {
        this.marketCapChange24h = marketCapChange24h;
    }

    public Double getMarketCapChangePercentage24h() {
        return marketCapChangePercentage24h;
    }

    public void setMarketCapChangePercentage24h(Double marketCapChangePercentage24h) {
        this.marketCapChangePercentage24h = marketCapChangePercentage24h;
    }

    public Double getCirculatingSupply() {
        return circulatingSupply;
    }

    public void setCirculatingSupply(Double circulatingSupply) {
        this.circulatingSupply = circulatingSupply;
    }

    public Double getTotalSupply() {
        return totalSupply;
    }

    public void setTotalSupply(Double totalSupply) {
        this.totalSupply = totalSupply;
    }

    public Double getMaxSupply() {
        return maxSupply;
    }

    public void setMaxSupply(Double maxSupply) {
        this.maxSupply = maxSupply;
    }

    public Double getAth() {
        return ath;
    }

    public void setAth(Double ath) {
        this.ath = ath;
    }

    public Double getAthChangePercentage() {
        return athChangePercentage;
    }

    public void setAthChangePercentage(Double athChangePercentage) {
        this.athChangePercentage = athChangePercentage;
    }

    public LocalDateTime getAthDate() {
        return athDateString != null ?
                LocalDateTime.parse(athDateString, DATE_TIME_FORMATTER) :
                null;
    }

    public void setAthDate(LocalDateTime athDate) {
        this.athDateString = athDate != null ?
                athDate.format(DATE_TIME_FORMATTER) :
                null;
    }

    public Double getAtl() {
        return atl;
    }

    public void setAtl(Double atl) {
        this.atl = atl;
    }

    public Double getAtlChangePercentage() {
        return atlChangePercentage;
    }

    public void setAtlChangePercentage(Double atlChangePercentage) {
        this.atlChangePercentage = atlChangePercentage;
    }

    public LocalDateTime getAtlDate() {
        return atlDateString != null ?
                LocalDateTime.parse(atlDateString, DATE_TIME_FORMATTER) :
                null;
    }

    public void setAtlDate(LocalDateTime atlDate) {
        this.atlDateString = atlDate != null ?
                atlDate.format(DATE_TIME_FORMATTER) :
                null;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdatedString != null ?
                LocalDateTime.parse(lastUpdatedString, DATE_TIME_FORMATTER) :
                null;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdatedString = lastUpdated != null ?
                lastUpdated.format(DATE_TIME_FORMATTER) :
                null;
    }

}


