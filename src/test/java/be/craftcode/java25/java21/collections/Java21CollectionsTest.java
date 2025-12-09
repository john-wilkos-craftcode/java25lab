package be.craftcode.java25.java21.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class Java21CollectionsTest {

    Java21Collections java21Collections = new Java21Collections();

    @Test
    void findLastStringInList() {
        List<String> testList = Arrays.asList("Masterchief", "Sonic", "Kratos", "Mario");
        assertEquals("Mario", java21Collections.findLastStringInList(testList), "Expected last string in the list");
    }

    @Test
    void replaceLastItemWithFirst() {
        ArrayList<Integer> testList2 = new ArrayList<>(Arrays.asList(2002, 1989, 2016, 1999));
        ArrayList<Integer> result2 = new ArrayList<>(Arrays.asList(1999, 1989, 2016, 2002));
        assertEquals(result2, java21Collections.replaceLastItemWithFirst(testList2), "Expected last item to be replaced with first");
    }

    @Test
    void removeLargestThreeNumbers() {
        SortedSet<Long> testSet = new TreeSet<>(Arrays.asList(5L, 3L, 2L, 4L, 1L));
        SortedSet<Long> result = new TreeSet<>(Arrays.asList(1L, 2L));
        assertEquals(result, java21Collections.removeLargestThreeNumbers(testSet), "Expected the three largest numbers to be removed");
    }

    @Test
    void getLastFruit() {
        LinkedHashSet<String> testSet = new LinkedHashSet<>(Arrays.asList("Apple", "Orange", "Banana", "Pineapple", "Strawberry"));
        assertEquals("Strawberry", java21Collections.getLastFruit(testSet), "Expected last item from the LinkedHashSet");
    }
}