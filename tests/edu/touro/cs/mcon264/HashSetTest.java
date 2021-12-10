package edu.touro.cs.mcon264;

import org.junit.jupiter.api.Test;
//import java.util.HashSet; import is a conveneinece so you do not need to use fully qialifed name

import static org.junit.jupiter.api.Assertions.*;

class HashSetTest {

    @Test
    void size() {
        // fully qualified class name used to disambiguate class from 1 or more packagaes
        java.util.HashSet<String> hs = new java.util.HashSet<String>();
        assertEquals(0, hs.size());
    }

    @Test
    void isEmpty() {
    }

    @Test
    void iterator() {
    }
}