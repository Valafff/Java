package org.top.airportdirectoryapp.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;

import java.util.List;
import java.util.Optional;

// AirportScenarioTest - класс с unit-тестами для AirportScenario
class AirportScenarioTest {

    private AirportScenario scenario;
    private AirportStorage storageMock;

    @BeforeEach
    public void setUp() {
        storageMock = Mockito.mock(AirportStorage.class, invocation -> {
            throw new UnsupportedOperationException(invocation.getMethod().getName());
        });
        scenario = new AirportScenario(storageMock);
    }

    @Nested
    public class ListAllTest {

        @Test
        public void success() {
            // ожидаемый результат
            List<Airport> expected = List.of(new Airport());
            // сконфигурируем моку так, чтобы при вызове selectAll она вернула ожидаемый результат
            Mockito.doReturn(expected).when(storageMock).selectAll();
            // выполним тестирование
            List<Airport> actual = scenario.listAll();
            // сравним результат - проверить ссылки в данном случае достаточно
            assertEquals(expected, actual);
        }
    }

    @Nested
    public class GetByCodeTest {

        @Test
        public void success() {
            String originCode = "TST";
            Airport expected = new Airport(originCode, "", 1);
            Mockito.doReturn(Optional.of(expected))
                .when(storageMock)
                .selectByCode(originCode);
            Airport actual = scenario.getByCode(originCode);
            assertEquals(expected, actual);
        }

        @Test
        public void airportNotFound() {
            String originCode = "TST";
            Mockito.doReturn(Optional.empty())
                .when(storageMock)
                .selectByCode(originCode);
            assertThrows(
                AirportNotFoundException.class, () -> scenario.getByCode(originCode)
            );
        }

        @ParameterizedTest
        @ValueSource(strings = {"INVALID", "", "001"})
        public void invalidCode(String origin) {
            assertThrows(InvalidCodeException.class, () -> scenario.getByCode(origin));
        }

        @Test
        public void nullCode() {
            assertThrows(InvalidCodeException.class, () -> scenario.getByCode(null));
        }
    }

    @Nested
    public class AddTest {

        @Test
        public void success() {
            Airport origin = new Airport("TST", "", 1);
            Mockito.doReturn(Optional.empty())
                .when(storageMock)
                .selectByCode(origin.getCode());
            Mockito.doNothing().when(storageMock).insert(origin);
            scenario.add(origin);
            // проверим факт того, что сценарии вызвал метод insert у стораджа
            Mockito.verify(storageMock).insert(origin);
        }

        @Test
        public void duplicatedCode() {
            Airport origin = new Airport("TST", "", 1);
            Mockito.doReturn(Optional.of(origin))
                    .when(storageMock)
                    .selectByCode(origin.getCode());
            assertThrows(DuplicatedCodeException.class, () -> scenario.add(origin));
        }
    }

    @Nested
    public class RemoveTest {

        @Test
        public void success() {
            String origin = "TST";
            Mockito.doReturn(Optional.of(origin)).when(storageMock).selectByCode(origin);
            Mockito.doNothing().when(storageMock).deleteByCode(origin);
            scenario.remove(origin);
            Mockito.verify(storageMock).deleteByCode(origin);
        }

        @Test
        public void airportNotFound() {
            String origin = "TST";
            Mockito.doReturn(Optional.empty())
                    .when(storageMock)
                    .selectByCode(origin);
            assertThrows(
                    AirportNotFoundException.class, () -> scenario.remove(origin)
            );
        }
    }

    @Nested
    public class EditTest {

        @Test
        public void success() {
            Airport origin = new Airport("TST", "", 1);
            Mockito.doReturn(Optional.of(origin)).when(storageMock).selectByCode(origin.getCode());
            Mockito.doNothing().when(storageMock).update(origin);
            scenario.edit(origin);
            Mockito.verify(storageMock).update(origin);
        }

        @Test
        public void airportNotFound() {
            Airport origin = new Airport("TST", "", 1);
            Mockito.doReturn(Optional.empty())
                    .when(storageMock)
                    .selectByCode(origin.getCode());
            assertThrows(
                    AirportNotFoundException.class, () -> scenario.edit(origin)
            );
        }
    }
}
