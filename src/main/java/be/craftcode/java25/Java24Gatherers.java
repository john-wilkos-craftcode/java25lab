package be.craftcode.java25;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.*;

/// # [JEP 485](https://openjdk.org/jeps/485): Stream Gatherers
///
/// Java stream pipelines (introduced in Java 8 in 2014) consist of 3 parts:
/// 1. A source of elements
/// 2. Intermediate operations
/// 3. A terminal operation
///
/// ##### For example:
/// ```java
/// long numberOfWords =
///   Stream.of("the", "", "fox", "jumps", "over", "the", "", "dog")  // (1)
///         .filter(Predicate.not(String::isEmpty))                   // (2)
///         .collect(Collectors.counting());                          // (3)
/// ```
/// Previously, there was only one extension point:
/// 1. For the terminal operation, you could implement your own Stream::collect(Collector).
///
/// Now, we have a new extension point for Intermediate operations:
///     **Stream::gather(Gatherer)**
///
/// Check out the [java docs](https://docs.oracle.com/en/java/javase/25/docs/api/java.base/java/util/stream/Gatherers.html)
///
/// Built-in gatherers:
///
/// - **fold**
///       is a stateful many-to-one gatherer which constructs an aggregate incrementally and emits that aggregate when
///       no more input elements exist. (Is a superset of existing method Reduce, in that reduce is a more specific fold)
/// - **mapConcurrent**
///       is a stateful one-to-one gatherer which invokes a supplied function for each input element concurrently, up
///       to a supplied limit.
/// - **scan**
///       is a stateful one-to-one gatherer which applies a supplied function to the current state and the current
///       element to produce the next element, which it passes downstream.
/// - **windowFixed**
///       is a stateful many-to-many gatherer which groups input elements into lists of a supplied size, emitting the
///       windows downstream when they are full.
/// - **windowSliding**
///       is a stateful many-to-many gatherer which groups input elements into lists of a supplied size. After the
///       first window, each subsequent window is created from a copy of its predecessor by dropping the first element
///       and appending the next element from the input stream.
///
public class Java24Gatherers {

    /// This shows the limits in terms of clarity and flexibility of the old stream API.
    ///
    /// This method will generate a nested array of arrays based on the input parameters.
    ///
    /// For example, `groupSize = 2L` and `limit = 3` would return the array `[[0,1],[2,3],[4,5]]`
    ///
    /// Hard to read, and therefore maintain!
    public ArrayList<ArrayList<Integer>> oldGroupWithLimit(long groupSize, int limit) {
        return Stream.iterate(0, i -> i + 1)
            .limit(groupSize * limit)
            .collect(Collector.of(
                    ArrayList::new,
                    (groups, element) -> {
                        if(groups.isEmpty() || groups.getLast().size() == (int) groupSize) {
                            var current = new ArrayList<Integer>();
                            current.add(element);
                            groups.addLast(current);
                        }
                        else {
                            groups.getLast().add(element);
                        }
                    },
                    (left, right) -> {
                        throw new UnsupportedOperationException("Cannot be parallelized");
                    }
            ));
    }

    //TODO 1: Rewrite the above method using a built-in Gatherer. It currently uses slidingWindow, which isn't working.
    // Remember, For example, groupSize = 2 and limit = 3 should return limit of 3 arrays of a group of 2 numbers each:
    // [[0,1],[2,3],[4,5]]
    public ArrayList<ArrayList<Integer>> newGroupWithLimit(int groupSize, int limit) {
        return Stream.iterate(0, i -> i + 1)
                .gather(Gatherers.windowSliding(groupSize))
                .limit(limit)
                .map(ArrayList::new) //The above outputs Lists, so this converts each sublist to an ArrayList
                .collect(Collectors.toCollection(ArrayList::new));
    }

    //TODO 2: Erase the contents of this method. Use the previous method as inspiration and use a built-in
    // gatherer to group a list of numbers in a way where each subsequent group removes the first digit and adds
    // the next digit to the end of the group.
    // For example, groupSize = 2 and limit = 3 should return the following:
    // [[0,1],[1,2],[2,3]]
    // and groupSize = 4 and limit = 4 should return:
    // [[0,1,2,3],[1,2,3,4],[2,3,4,5],[3,4,5,6]]
    public ArrayList<ArrayList<Integer>> rollingGroupWithLimit(int groupSize, int limit) {
        return new ArrayList<>(Arrays.asList(new ArrayList<>(), new ArrayList<>()));
    }

    //TODO 3: Use the scan gatherer to list the steps to count to a number. For example, input = 3 -> output = ["1", "12", "123"]
    public ArrayList<String> countTo(long limit) {
        return Stream.iterate(1, i -> i + 1)
                .limit(limit)
                .map(String::valueOf)
                .collect(Collectors.toCollection(ArrayList::new));
    }

}
