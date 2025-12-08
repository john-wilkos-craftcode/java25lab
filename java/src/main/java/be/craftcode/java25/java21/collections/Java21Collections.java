package be.craftcode.java25.java21.collections;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.SortedSet;

public class Java21Collections {
    /*  
        - Check out the specific JDK (Java Development Kit) Enhancement Proposal (JEP-431) at https://openjdk.org/jeps/431
        - For a fascinating peek behind the curtain of Java language design, read through the mailing list thread 
            where they brainstorm this proposal: https://mail.openjdk.org/pipermail/core-libs-dev/2021-April/076461.html

        PROBLEM:

        Before Java 21, accessing the first and last elements of different types of collections was confusing:
        +---------------+---------------------------------+--------------------------+
        |   Collection  |         First Element           |      Last Element        |
        +---------------+---------------------------------+--------------------------+
        |     List      |           list.get(0)           |  list.get(list.size()-1) |
        |     Deque     |        deque.getFirst()         |     deque.getLast()      |
        |   SortedSet   |       sortedSet.first()         |     sortedSet.last()     |
        | LinkedHashSet | linkedHashSet.iterator().next() |       // missing         |
        +---------------+------------------------+-----------------------------------+

        SOLUTION:

        JAVA 21 SEQUENCED COLLECTIONS!

        interface SequencedCollection<E> extends Collection<E> {

            // new method returns a reverse-ordered view. Modifications to original list will be visible (but in reverse).
            SequencedCollection<E> reversed();

            // methods promoted from Deque. Work as expected.
            void addFirst(E);
            void addLast(E);
            E getFirst();
            E getLast();
            E removeFirst();
            E removeLast();
        }

        Open the Sequence-Diagram.png in this folder. Now ordered collections (i.e SortedSet, List, Deque) 
        extend the SequencedCollection interface, and therefore have access to the above methods.

        Your mission is to implement the below methods using these new SequencedCollection methods. 

        To check if you succeeded, run the tests by entering the following command in the terminal:

            mvn test -Dtest="Java21CollectionsTest"

        or simply open java21lab/test/java/be/craftcode/ap/collections/Java21CollectionsTest.java 
            and click on the green arrow to the left of the class name.

        Good luck!
    */

    public String findLastStringInList(List<String> inputStrings){
        //TODO 1: Use the new list methods to make this method return the last string in the input list.
        return "fail";
    }

    public List<Integer> replaceLastItemWithFirst(ArrayList<Integer> inputItems){
        //TODO 2: Switch the first and last items of the given list and return it.
        return inputItems;
    }

    public SortedSet<Long> removeLargestThreeNumbers(SortedSet<Long> inputLongs){
        //TODO 3: remove the three largest numbers and return the set
        return inputLongs;
    }

    public String getLastFruit(LinkedHashSet<String> inputFruits){
        //TODO 4: access the last element of the LinkedHashSet and return it
        return "fail";
    }
}