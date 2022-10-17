package DataProvider;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class CitySpec {

    private static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("London", "UK", "2643743"),
                Arguments.of("Oxford", "UK", "2640729"),
                Arguments.of("Gdańsk", "PL", "3099434")
        );
    }
}
