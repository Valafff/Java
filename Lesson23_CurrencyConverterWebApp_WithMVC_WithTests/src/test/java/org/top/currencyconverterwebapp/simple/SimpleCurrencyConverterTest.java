package org.top.currencyconverterwebapp.simple;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.top.currencyconverterwebapp.converter.ExchangeRate;
import org.top.currencyconverterwebapp.converter.InvalidValueException;
import org.top.currencyconverterwebapp.converter.RatesProvider;
import org.top.currencyconverterwebapp.converter.UnsupportedCurrencyException;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SimpleCurrencyConverterTest {

    private final double delta = 0.00001;

    @Test
    public void success() {
        // исходные данные
        String originBaseCurrency = "RUB";
        String originSrcCurrency = "USD";
        String originDstCurrency = originBaseCurrency;

        ExchangeRate originExchangeRate = new ExchangeRate(originSrcCurrency, 78.1);
        ExchangeRate baseExchangeRate = new ExchangeRate(originBaseCurrency, 1);

        // создание моки с выбрасыванием исключения в случае несконфигурированного вызова
        RatesProvider ratesProviderMock = Mockito.mock(RatesProvider.class, invocation -> {
            throw new UnsupportedOperationException(invocation.getMethod().getName());
        });

        // настройка моки для нужного вызова
        Mockito.doReturn(
                        List.of(originExchangeRate, baseExchangeRate) // что вернется при вызове getRates
                ).when(ratesProviderMock) // для объекта ratesProviderMock
                .getRates(originBaseCurrency); // говорим что будет вызываться getRates с параметром originBaseCurrency

        // создание самого сервиса
        SimpleCurrencyConverter converter = new SimpleCurrencyConverter(ratesProviderMock);

        // тестирование
        double originValue = 100;
        double expectedValue = 7810;
        double actualValue = converter.convert(originSrcCurrency, originDstCurrency, originValue);

        // проверка
        assertEquals(expectedValue, actualValue, delta);
    }

    @Test
    public void invalidValueException() {
        // создание моки с выбрасыванием исключения в случае несконфигурированного вызова
        RatesProvider ratesProviderMock = Mockito.mock(RatesProvider.class, invocation -> {
            throw new UnsupportedOperationException(invocation.getMethod().getName());
        });
        // настройка моки для нужного вызова
        Mockito.doReturn(List.of())
                .when(ratesProviderMock)
                .getRates(Mockito.any());
        // создание самого сервиса
        SimpleCurrencyConverter converter = new SimpleCurrencyConverter(ratesProviderMock);
        // тут хотим чтобы вылетел InvalidValueException
        assertThrows(InvalidValueException.class, () -> {
            converter.convert("", "", -1);
        });
    }


    @Test
    public void unsupportedCurrencyExceptionFrom()
    {
        String originBaseCurrency = "RUB";
        String originSrcCurrency = "USD";
        String originDstCurrency = originBaseCurrency;

        ExchangeRate originExchangeRate = new ExchangeRate(originSrcCurrency, 78.1);
        ExchangeRate baseExchangeRate = new ExchangeRate(originBaseCurrency, 1);

        // создание моки с выбрасыванием исключения в случае несконфигурированного вызова
        RatesProvider ratesProviderMock = Mockito.mock(RatesProvider.class, invocation -> {
            throw new UnsupportedOperationException(invocation.getMethod().getName());
        });

        // настройка моки для нужного вызова
        Mockito.doReturn(
                        List.of(originExchangeRate, baseExchangeRate) // что вернется при вызове getRates
                ).when(ratesProviderMock) // для объекта ratesProviderMock
                .getRates(originBaseCurrency); // говорим что будет вызываться getRates с параметром originBaseCurrency

        // создание самого сервиса
        SimpleCurrencyConverter converter = new SimpleCurrencyConverter(ratesProviderMock);

        // тестирование
        double originValue = 100;
        double expectedValue = 7810;

        // тут хотим чтобы вылетел InvalidValueException
        assertThrows(UnsupportedCurrencyException.class, () -> {
            converter.convert("dddd", originDstCurrency, originValue);
        }); new UnsupportedOperationException();
    }
}
