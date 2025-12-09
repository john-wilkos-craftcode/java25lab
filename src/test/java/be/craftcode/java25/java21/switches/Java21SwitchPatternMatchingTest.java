package be.craftcode.java25.java21.switches;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import be.craftcode.java25.java21.switches.Java21SwitchPatternMatching.Nintendo;
import be.craftcode.java25.java21.switches.Java21SwitchPatternMatching.PC;
import be.craftcode.java25.java21.switches.Java21SwitchPatternMatching.PlayStation;
import be.craftcode.java25.java21.switches.Java21SwitchPatternMatching.Xbox;

public class Java21SwitchPatternMatchingTest {
    Java21SwitchPatternMatching java21SwitchPatternMatching = new Java21SwitchPatternMatching();

    @Test
    void givenObjectOldCheckObjectShouldReturnCorrectString(){
        assertEquals("int 3", java21SwitchPatternMatching.oldCheckObject(3));
        assertEquals("long 3", java21SwitchPatternMatching.oldCheckObject(3L));
        assertEquals("double 3.000000", java21SwitchPatternMatching.oldCheckObject(3.0));
        assertEquals("Object String", java21SwitchPatternMatching.oldCheckObject("String"));
        assertEquals("null", java21SwitchPatternMatching.oldCheckObject(null));
    }

    @Test
    void givenObjectCheckObjectShouldReturnCorrectString(){
        assertEquals("int 3", java21SwitchPatternMatching.checkObject(3));
        assertEquals("long 3", java21SwitchPatternMatching.checkObject(3L));
        assertEquals("double 3.000000", java21SwitchPatternMatching.checkObject(3.0));
        assertEquals("Object String", java21SwitchPatternMatching.checkObject("String"));
        assertEquals("null", java21SwitchPatternMatching.checkObject(null));
    }

    @Test
    void testTestStringOld() {
        assertEquals("null", java21SwitchPatternMatching.testStringOld(null));
        assertEquals("You got it", java21SwitchPatternMatching.testStringOld("YES"));
        assertEquals("You got it", java21SwitchPatternMatching.testStringOld("yes"));
        assertEquals("You got it", java21SwitchPatternMatching.testStringOld("Y"));
        assertEquals("You got it", java21SwitchPatternMatching.testStringOld("y"));
        assertEquals("Shame", java21SwitchPatternMatching.testStringOld("NO"));
        assertEquals("Shame", java21SwitchPatternMatching.testStringOld("no"));
        assertEquals("Shame", java21SwitchPatternMatching.testStringOld("N"));
        assertEquals("Shame", java21SwitchPatternMatching.testStringOld("n"));
        assertEquals("Sorry?", java21SwitchPatternMatching.testStringOld("Maybe"));
        assertEquals("Sorry?", java21SwitchPatternMatching.testStringOld("ABC"));
    }

    @Test
    void testStringWithGuards() {
        assertEquals("null", java21SwitchPatternMatching.testStringWithGuards(null));
        assertEquals("You got it", java21SwitchPatternMatching.testStringWithGuards("YES"));
        assertEquals("You got it", java21SwitchPatternMatching.testStringWithGuards("yes"));
        assertEquals("You got it", java21SwitchPatternMatching.testStringWithGuards("Y"));
        assertEquals("You got it", java21SwitchPatternMatching.testStringWithGuards("y"));
        assertEquals("Shame", java21SwitchPatternMatching.testStringWithGuards("NO"));
        assertEquals("Shame", java21SwitchPatternMatching.testStringWithGuards("no"));
        assertEquals("Shame", java21SwitchPatternMatching.testStringWithGuards("N"));
        assertEquals("Shame", java21SwitchPatternMatching.testStringWithGuards("n"));
        assertEquals("Sorry?", java21SwitchPatternMatching.testStringWithGuards("Maybe"));
        assertEquals("Sorry?", java21SwitchPatternMatching.testStringWithGuards("ABC"));
    }

    // @Test
    // void testDominance(){
    //     assertEquals("It's the letter 'y'!", java21SwitchPatternMatching.testDominance("y"));
    //     assertEquals("It's a string: Maybe", java21SwitchPatternMatching.testDominance("Maybe"));
    // }

    @Test
    public void testOldEnumSupport() {
        // Test for PC
        assertEquals("This is a: RTX3060", java21SwitchPatternMatching.oldEnumSupport(PC.RTX3060));
        assertEquals("This is a: RTX4090", java21SwitchPatternMatching.oldEnumSupport(PC.RTX4090));
        assertEquals("This is a: RX580", java21SwitchPatternMatching.oldEnumSupport(PC.RX580));
        assertEquals("This is a: RX7900", java21SwitchPatternMatching.oldEnumSupport(PC.RX7900));

        // Test for Nintendo
        assertEquals("This is a: SWITCH", java21SwitchPatternMatching.oldEnumSupport(Nintendo.SWITCH));
        assertEquals("This is a: WII", java21SwitchPatternMatching.oldEnumSupport(Nintendo.WII));
        assertEquals("This is a: GAMECUBE", java21SwitchPatternMatching.oldEnumSupport(Nintendo.GAMECUBE));
        assertEquals("This is a: N64", java21SwitchPatternMatching.oldEnumSupport(Nintendo.N64));

        // Test for Xbox
        Xbox x = new Xbox();
        assertEquals("This is a: Xbox", java21SwitchPatternMatching.oldEnumSupport(x));

        // Test for PlayStation
        PlayStation ps = new PlayStation();
        assertEquals("This is a: PlayStation", java21SwitchPatternMatching.oldEnumSupport(ps));
    }

    @Test
    public void testBetterEnumSupport() {
        // Test for PC
        assertEquals("This is a: RTX3060", java21SwitchPatternMatching.betterEnumSupport(PC.RTX3060));
        assertEquals("This is a: RTX4090", java21SwitchPatternMatching.betterEnumSupport(PC.RTX4090));
        assertEquals("This is a: RX580", java21SwitchPatternMatching.betterEnumSupport(PC.RX580));
        assertEquals("This is a: RX7900", java21SwitchPatternMatching.betterEnumSupport(PC.RX7900));

        // Test for Nintendo
        assertEquals("This is a: SWITCH", java21SwitchPatternMatching.betterEnumSupport(Nintendo.SWITCH));
        assertEquals("This is a: WII", java21SwitchPatternMatching.betterEnumSupport(Nintendo.WII));
        assertEquals("This is a: GAMECUBE", java21SwitchPatternMatching.betterEnumSupport(Nintendo.GAMECUBE));
        assertEquals("This is a: N64", java21SwitchPatternMatching.betterEnumSupport(Nintendo.N64));

        // Test for Xbox
        Xbox x = new Xbox();
        assertEquals("This is a: Xbox", java21SwitchPatternMatching.betterEnumSupport(x));

        // Test for PlayStation
        PlayStation ps = new PlayStation();
        assertEquals("This is a: PlayStation", java21SwitchPatternMatching.betterEnumSupport(ps));
    }

    


}
