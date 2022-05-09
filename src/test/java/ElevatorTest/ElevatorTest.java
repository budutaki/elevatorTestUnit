package ElevatorTest;

import Elevator.Elevator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

public class ElevatorTest {


    @ParameterizedTest
    @ValueSource(ints = {-2, 0, 30})
    public void moveTest(int floor) {
        Elevator elevator = new Elevator();
        boolean result = elevator.move(floor);
        Assertions.assertFalse(result);
    }


    @ParameterizedTest
    @MethodSource("methodSource")
    public void calculateMovingTimeParamTest(int cf, int pf, int expectedResult) {
        Elevator elevator = new Elevator();
        elevator.setCurrentFloor(cf);
        elevator.setPreviousFloor(pf);
        int result = elevator.calculateMovingTime();
        Assertions.assertEquals(result, expectedResult);

    }

    private static Stream<Arguments> methodSource() {
        Stream<Arguments> of = Stream.of(
                Arguments.of(5, 7, 20),
                Arguments.of(9, 6, 25),
                Arguments.of(25, 1, 130)

        );
        return of;
    }


    @Test
    public void showQueueTest() {
        Elevator elevator = new Elevator();
        elevator.move(7);
        elevator.move(8);
        String result = elevator.showQueue();

        Assertions.assertTrue(result.contains("этаж 7"));
        Assertions.assertTrue(result.contains("этаж 8"));


    }
}



