package be.craftcode.java25;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class Java22GatherersTest {

    Java22Gatherers java22Gatherers = new Java22Gatherers();

    @Test
    void testOldGroupWithLimit() {
        List<List<Integer>> sizeThreeLimitTwoResult = new ArrayList<>(Arrays.asList(Arrays.asList(0, 1, 2), Arrays.asList(3, 4, 5)));
        assertEquals(sizeThreeLimitTwoResult, java22Gatherers.oldGroupWithLimit(3L,2), "Expected [[0, 1, 2], [3, 4, 5]]");
        List<List<Integer>> sizeFourLimitThreeResult = new ArrayList<>(Arrays.asList(Arrays.asList(0, 1, 2, 3), Arrays.asList(4,5,6,7), Arrays.asList(8,9,10,11)));
        assertEquals(sizeFourLimitThreeResult, java22Gatherers.oldGroupWithLimit(4L,3), "Expected [[0, 1, 2, 3], [4, 5, 6, 7], [8, 9, 10, 11]]");
    }

    @Test
    void testNewGroupWithLimit() {
        List<List<Integer>> sizeThreeLimitTwoResult = new ArrayList<>(Arrays.asList(Arrays.asList(0, 1, 2), Arrays.asList(3, 4, 5)));
        assertEquals(sizeThreeLimitTwoResult, java22Gatherers.newGroupWithLimit(3,2), "Expected [[0, 1, 2], [3, 4, 5]]");
        List<List<Integer>> sizeFourLimitThreeResult = new ArrayList<>(Arrays.asList(Arrays.asList(0, 1, 2, 3), Arrays.asList(4,5,6,7), Arrays.asList(8,9,10,11)));
        assertEquals(sizeFourLimitThreeResult, java22Gatherers.newGroupWithLimit(4,3), "Expected [[0, 1, 2, 3], [4, 5, 6, 7], [8, 9, 10, 11]]");
    }

    @Test
    void testRollingGroupWithLimit() {
        List<List<Integer>> sizeThreeLimitTwoResult = new ArrayList<>(Arrays.asList(Arrays.asList(0, 1, 2), Arrays.asList(1, 2, 3)));
        assertEquals(sizeThreeLimitTwoResult, java22Gatherers.rollingGroupWithLimit(3,2), "Expected [[0, 1, 2], [1, 2, 3]]");
        List<List<Integer>> sizeFourLimitThreeResult = new ArrayList<>(Arrays.asList(Arrays.asList(0, 1, 2, 3), Arrays.asList(1, 2, 3, 4), Arrays.asList(2, 3, 4, 5)));
        assertEquals(sizeFourLimitThreeResult, java22Gatherers.rollingGroupWithLimit(4,3), "Expected [[0, 1, 2, 3], [1, 2, 3, 4], [2, 3, 4, 5]]");
    }

    @Test
    void testCountWithScan() {
        ArrayList<String> countToNine = new ArrayList<>(Arrays.asList("1", "12", "123", "1234", "12345", "123456", "1234567", "12345678", "123456789"));
        assertEquals(countToNine, java22Gatherers.countTo(9), "Expected [\"1\", \"12\", \"123\", \"1234\", \"12345\", \"123456\", \"1234567\", \"12345678\", \"123456789\"]");
    }
}