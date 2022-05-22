package org.example.lesson4;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class TriangleTest {
    static Logger logger = LoggerFactory.getLogger(TriangleTest.class);

    private static int counter = 0;

    private static Triangle triangle;

    @BeforeEach
    void beforeEach() {
        triangle = new Triangle();
    }

    @Nested
    @DisplayName("triangle square tests")
    class SquareTest {

        @Test
        @DisplayName("data a=3, b=4, c=5, S=6 is expected")
        void simpleTest() {
            assertEquals(6, triangle.triangleSquare(3, 4, 5));
            logger.info("simpleTest passed");
        }

        @Test
        @DisplayName("data a=3, b=4, c=5, S=6 is expected")
        @Disabled("disabled. we already have the same one before")
        void sameTestBefore() {
            assertEquals(6, triangle.triangleSquare(3, 4, 5));
            logger.info("simpleTest passed");
        }

        @RepeatedTest(5)
        @DisplayName("repeated, data 30, 40, 50, 600")
        void repeatedTests() {
            assertEquals(600, triangle.triangleSquare(30, 40, 50));
            logger.info("repeatedTest " + ++counter + " passed");
        }

        @ParameterizedTest
        @CsvSource({
                "0, 4, 5, 1",
                "3, 0, 5, 2",
                "3, 4, 0, 3"
        })
        @DisplayName("negative, zero")
        void parametrizedTestThrowZero(int a, int b, int c, int d) {
            assertThrows(TriangleException.class, () -> triangle.triangleSquare(a, b, c));
            logger.info("parametrizedTestThrowZero " + d + " passed");
        }

        @ParameterizedTest
        @CsvSource({
                "-3, 4, 5, 1",
                "3, -4, 5, 2",
                "3, 4, -5, 3"
        })
        @DisplayName("negative, negative digits")
        void parametrizedTestThrowNegative(int a, int b, int c, int d) {
            assertThrows(TriangleException.class, () -> triangle.triangleSquare(a, b, c));
            logger.info("parametrizedTestThrowNegative " + d + " passed");
        }

        @ParameterizedTest
        @CsvSource({
                "3, 4, 1000, 1",
                "3, 100, 5, 2",
                "200, 4, 5, 3"
        })
        @DisplayName("negative, not triangle")
        void parametrizedTestThrowNotTriangle(int a, int b, int c, int d) {
            assertThrows(TriangleException.class, () -> triangle.triangleSquare(a, b, c));
            logger.info("parametrizedTestThrowNotTriangle " + d + " passed");
        }

        @Test
        @DisplayName("Timeout test")
        void TimeoutTest() {
            Assertions.assertTimeout(Duration.ofMillis(5),
                    () -> triangle.triangleSquare(3, 4, 5));
            logger.info("TimeoutTest passed");
        }
    }

    @Nested
    @DisplayName("division tests")
    class DivisionTests {


        @ParameterizedTest
        @DisplayName("parametrized")
        @CsvSource({
                "2,1,2",
                "9,3,3",
                "100,5,20"
        })
        void division(int a, int b, double answer) {
            assertEquals(answer, triangle.division(a, b));
            logger.info("parametrizedTest division " + ++counter + " passed");
        }

        @Test
        @DisplayName("Division by zero")
        void divisionByZero() {
            assertThrows(ArithmeticException.class, () -> triangle.division(1, 0));
            logger.warn("divisionByZero passed");
        }
    }
}
