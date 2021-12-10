import edu.touro.cs.mcon264.HashFun;
import edu.touro.cs.mcon264.Telephone;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class HashFunTest {

    @Test
    public void maximum() {
        assertEquals(234, HashFun.maximum(2, 8, 4, 1, -90, 234, 68, 3));
        assertEquals(234, HashFun.maximum(new int[]{2, 8, 4, 1, -90, 234, 68, 3}));
    }

    @Test
    public void bitOps() {
        assertEquals(0b101, 0b101 & 0b111);
        assertEquals(0b111, 0b101 | 0b111);
        assertEquals(0b010, 0b101 ^ 0b111);
        assertEquals(0b1010, 0b101 << 1);
        assertEquals(0b10, 0b101 >> 1);

        int x = 0;
        if (4 > 3 || ++x > 2) // logical or short circuit stops logical ops on first TRUE
            System.out.println();
        if (4 > 13 && ++x > 2) // logical and short circuit stops logical ops on first FALSE
            System.out.println();
        assertEquals(0, x);
    }

    @Test
    public void hashFunSet1() {
        HashSet<HashFun> set = new HashSet<>();
        set.add(new HashFun());
        assertTrue(set.contains(new HashFun()));
    }

    @Test
    public void hashFunSet2() {
        HashSet<HashFun> set = new HashSet<>();
        HashFun hf = new HashFun();
        hf.s = 453;
        hf.st = "Fred Math";
        set.add( hf );

        HashFun hf2 = new HashFun();
        hf2.s = 453;
        hf2.st = "Fred Math";
        assertTrue(set.contains(hf2));
    }
    @Test
    public void hashFunSet3() {
        Object o1 = new Object();
        Object o2 = new Object();
        assertTrue( ! o1.equals(o2));
        assertTrue( o2.hashCode() != o1.hashCode());
    }

    @Test
    public void HashMap()
    {
        HashMap<String, Telephone> phoneBook = new HashMap<>();

        phoneBook.put("Robinson, Yoni", new Telephone("9179238432"));

        Telephone t = phoneBook.get("Robinson, Yoni");

        assertEquals( new Telephone("9179238432"), t);
    }


    @Test
    public void modulus() // n MOD m, returns 0..m-1
    {
        // % is called remainder operator
        assertEquals(4, 124 % 5);
        assertEquals(-3, -8 % 5);
    }
}