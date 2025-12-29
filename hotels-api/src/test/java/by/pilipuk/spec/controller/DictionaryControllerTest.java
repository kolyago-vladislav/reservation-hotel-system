package by.pilipuk.spec.controller;

import by.pilipuk.environment.service.DictionaryCreationTestService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

@TestInstance(TestInstance.Lifecycle.PER_CLASS) // Позволяет MethodSource быть нестатическим
@DisplayName("Test all methods from DictionaryController.class")
public class DictionaryControllerTest extends BaseControllerTest {

    @Autowired
    private DictionaryCreationTestService dictionaryCreationTestService;

    @ParameterizedTest
    @MethodSource("dictionaryEndpoints")
    void getDictionaries(String url, Supplier<List<?>> dataSupplier) {
        performGetRequest(url, dataSupplier.get());
    }

    private Stream<Arguments> dictionaryEndpoints() {
        return Stream.of(
                Arguments.of("/v1/dictionaries/cities", (Supplier<List<?>>) dictionaryCreationTestService::createCityDtosList),
                Arguments.of("/v1/dictionaries/countries", (Supplier<List<?>>) dictionaryCreationTestService::createCountryDtosList),
                Arguments.of("/v1/dictionaries/roomTypes", (Supplier<List<?>>) dictionaryCreationTestService::createRoomTypesList)
        );
    }
}