package prj5;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// --Jonathan Awad (jonathana)

/**
 * Tests the LinkedList class
 * 
 * @author Jonathan Awad (jonathana)
 * @version 2020.11.21
 */
public class LinkedListTest extends student.TestCase {

    private LinkedList<String> emptyListA;
    private LinkedList<String> emptyListB;
    private LinkedList<String> smallListA;
    private LinkedList<String> smallListB;
    private LinkedList<String> bigListA;
    private LinkedList<String> bigListB;
    private String nullObject;

    /**
     * Initializes 2 empty lists, 2 lists with a small number of items, and 2
     * lists with a large number of items
     */
    public void setUp() {
        emptyListA = new LinkedList<String>();
        emptyListB = new LinkedList<String>();

        smallListA = new LinkedList<String>();
        smallListB = new LinkedList<String>();

        smallListA.add("soccer");
        smallListA.add("swimming");
        smallListA.add("gymnastics");

        smallListB.add("soccer");
        smallListB.add("swimming");
        smallListB.add("gymnastics");

        bigListA = new LinkedList<String>();

        for (int i = 0; i < 100; i++) {
            bigListA.add("sport" + i);
        }

        bigListB = new LinkedList<String>();
        for (int i = 0; i < 100; i++) {
            bigListB.add("sport" + i);
        }

        // to be explicit
        nullObject = null;
    }


    /**
     * Tests the equals method on an empty list
     */
    public void testEqualsEmptyList() {
        assertEquals(emptyListA, emptyListA);
        assertEquals(emptyListA, emptyListB);
        assertFalse(emptyListA.equals(nullObject));
        assertFalse(emptyListA.equals("soccer"));
        assertFalse(emptyListA.equals(smallListA));
        assertFalse(smallListA.equals(emptyListA));
        emptyListB.add("jump roping");
        assertFalse(emptyListA.equals(emptyListB));
        smallListA.clear();
        assertEquals(emptyListA, smallListA);
    }


    /**
     * Tests the equals method on a list with a small number of items in it
     */
    public void testEqualsSmallList() {
        assertEquals(smallListA, smallListA);
        assertEquals(smallListA, smallListB);
        assertFalse(smallListA.equals(nullObject));
        assertFalse(smallListA.equals("soccer"));
        assertFalse(smallListA.equals(bigListA));
        assertFalse(smallListA.equals(emptyListA));
        smallListB.add("jump roping");
        assertFalse(smallListA.equals(smallListB));

        // Make smallListA and smallListB differ in
        // content, but have the same size
        smallListA.add("rope jumping");
        assertFalse(smallListA.equals(smallListB));

        // Replace the last element in smallListA
        // to make smallListA and smallListB equal again
        smallListA.remove("rope jumping");
        smallListA.add("jump roping");
        assertEquals(smallListA, smallListB);
    }


    /**
     * Tests the equals method on a list with a large number of items in it
     */
    public void testEqualsBigList() {
        assertEquals(bigListA, bigListA);
        assertEquals(bigListA, bigListB);
        assertFalse(bigListA.equals(nullObject));
        assertFalse(bigListA.equals("soccer"));
        assertFalse(bigListA.equals(smallListA));
        assertFalse(bigListA.equals(emptyListA));
        bigListB.add("jump roping");
        assertFalse(bigListA.equals(bigListB));

        // Same content, same size, but reversed
        bigListB.clear();
        assertFalse(bigListA.equals(bigListB));
        for (int i = 100; i > 0; i--) {
            bigListB.add("sport" + i);
        }
        assertFalse(bigListA.equals(bigListB));

        // one a subset of the other but with dups
        bigListB.clear();
        assertFalse(bigListA.equals(bigListB));
        for (int i = 0; i < 50; i++) {
            bigListB.add("sport" + i);
        }
        for (int i = 0; i < 50; i++) {
            bigListB.add("sport" + i);
        }
        assertFalse(bigListA.equals(bigListB));

        // make them equal again
        bigListB.clear();
        assertFalse(bigListA.equals(bigListB));
        for (int i = 0; i < 100; i++) {
            bigListB.add("sport" + i);
        }
        assertEquals(bigListA, bigListB);

    }


    /**
     * Tests the toArray method on an empty list
     */
    public void testToArrayEmpty() {

        Object[] emptyArray = {};
        assertTrue(Arrays.equals(emptyListA.toArray(), emptyArray));
        assertTrue(Arrays.equals(emptyListA.toArray(), emptyListB.toArray()));
        assertFalse(Arrays.equals(emptyListA.toArray(), smallListB.toArray()));
        Object[] oneItemArray = { "one thing" };
        emptyListA.add("one thing");
        assertTrue(Arrays.equals(emptyListA.toArray(), oneItemArray));

    }


    /**
     * Tests the toArray method on a list with items in it
     */
    public void testToArrayContents() {

        Object[] origArray = { "soccer", "swimming", "gymnastics" };
        assertTrue(Arrays.equals(smallListA.toArray(), origArray));
        assertTrue(Arrays.equals(emptyListA.toArray(), emptyListB.toArray()));
        assertFalse(Arrays.equals(smallListA.toArray(), bigListB.toArray()));
    }


    /**
     * test add to position
     */
    public void testAdd() {
        Exception exception = null;
        try {
            emptyListA.add(1, nullObject);
            fail("removeFront() is not throwing an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("removeFront() is throwing the wrong type of exceptions",
            exception instanceof IllegalArgumentException);

        emptyListA.add(0, "test");
        assertEquals("test", emptyListA.get(0));
        assertFalse(emptyListA.isEmpty());
        smallListA.add(0, "t");
        assertEquals("t", smallListA.get(0));
    }


    /**
     * test add to position 2
     */
    public void testAdd2() {
        Exception exception = null;
        try {
            smallListA.add(-1, "test");
            fail("removeFront() is not throwing an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("removeFront() is throwing the wrong type of exceptions",
            exception instanceof IndexOutOfBoundsException);

        assertEquals("gymnastics", smallListA.get(2));
    }


    /**
     * test add to position 3
     */
    public void testAdd3() {
        Exception exception = null;
        try {
            smallListA.add(6, "test");
            fail("removeFront() is not throwing an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("removeFront() is throwing the wrong type of exceptions",
            exception instanceof IndexOutOfBoundsException);

        emptyListA.add(0, "t");
        emptyListA.add(1, "test");
        assertEquals(2, emptyListA.size());
    }


    /**
     * test add E
     */
    public void testAddE() {
        Exception exception = null;
        try {
            emptyListA.add(nullObject);
            fail("removeFront() is not throwing an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("removeFront() is throwing the wrong type of exceptions",
            exception instanceof IllegalArgumentException);
    }


    /**
     * test remove E
     */
    public void testRemoveE() {
        assertEquals(3, smallListA.size());
        smallListA.add(3, "test");
        assertEquals("{soccer, swimming, gymnastics, test}", smallListA
            .toString());
        smallListA.add(4, "test1");
        assertEquals(5, smallListA.size());
        assertTrue(smallListA.remove("test"));
        assertEquals(4, smallListA.size());
        assertFalse(emptyListA.remove(nullObject));
    }


    /**
     * test remove E
     */
    public void testRemoveE1() {
        emptyListA.add(0, "test");
        assertEquals(1, emptyListA.size());
        assertTrue(emptyListA.remove("test"));
        assertFalse(smallListA.remove("a"));
    }


    /**
     * test remove index
     */
    public void testRemove() {
        Exception exception = null;
        try {
            smallListA.remove(-1);
            fail("remove() is not throwing an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("remove() is throwing the wrong type of exceptions",
            exception instanceof IndexOutOfBoundsException);

        assertEquals(3, smallListA.size());
        assertTrue("gymnastics", smallListA.remove(2));
        assertEquals(2, smallListA.size());
        smallListA.remove(1);
        assertEquals("soccer", smallListA.get(0));
    }


    /**
     * test remove exception
     */
    public void testRemove1() {
        Exception exception = null;
        try {
            emptyListA.remove(0);
            fail("remove() is not throwing an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("remove() is throwing the wrong type of exceptions",
            exception instanceof IndexOutOfBoundsException);
        assertTrue(smallListA.remove(0));
        smallListB.remove(1);
    }


    /**
     * test remove exception
     */
    public void testRemove2() {
        Exception exception = null;
        try {
            smallListA.remove(4);
            fail("remove() is not throwing an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("remove() is throwing the wrong type of exceptions",
            exception instanceof IndexOutOfBoundsException);
    }


    /**
     * test get method
     */
    public void testGet() {
        Exception exception = null;
        try {
            smallListA.get(-1);
            fail("remove() is not throwing an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("remove() is throwing the wrong type of exceptions",
            exception instanceof IndexOutOfBoundsException);
    }


    /**
     * test get exception
     */
    public void testGet2() {
        Exception exception = null;
        try {
            smallListA.get(5);
            fail("remove() is not throwing an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("remove() is throwing the wrong type of exceptions",
            exception instanceof IndexOutOfBoundsException);
    }


    /**
     * test contains()
     */
    public void testContains() {
        assertTrue(smallListA.contains("swimming"));
        assertFalse(smallListA.contains("test"));
    }


    /**
     * test clear()
     */
    public void testClear() {
        emptyListA.clear();
        smallListA.clear();
        assertEquals(0, smallListA.size());
    }


    /**
     * test lastIndexOf
     */
    public void testLastIndexOf() {
        assertEquals(1, smallListA.lastIndexOf("swimming"));
    }


    /**
     * test toString()
     */
    public void testToString() {
        assertEquals("{soccer, swimming, gymnastics}", smallListA.toString());
        assertEquals("{}", emptyListA.toString());
    }


    /**
     * test hasNext() for iterator method
     */
    public void testHasNext() {
        LinkedList<String> ll = new LinkedList<String>();
        ll.add("one");
        ll.add("two");
        ll.add("three");

        Iterator<String> iter = ll.iterator();

        assertTrue(iter.hasNext());
        iter.next();
        iter.next();
        assertFalse(iter.hasNext());
    }


    /**
     * test next() method for iterator method
     */
    public void testNext() {
        LinkedList<String> ll = new LinkedList<String>();

        ll.add("one");
        ll.add("two");
        ll.add("three");

        Iterator<String> iter = ll.iterator();

        assertEquals("two", iter.next()); // ignore the void warning on here
        // right now; @Override is called
        iter.next();

        Exception exception = null;
        try {
            iter.next();
            fail("next() is not throwing an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("next() is throwing the wrong type of exceptions",
            exception instanceof NoSuchElementException);
    }


    /**
     * test remove() method
     */
    public void testRemoveIterator() {
        LinkedList<String> ll = new LinkedList<String>();

        ll.add("hola");
        ll.add("hello");
        ll.add("bonjour");

        Iterator<String> iter = ll.iterator();

        Exception exception = null;
        try {
            iter.remove();
            fail("remove() is not throwing an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("remove() is throwing the wrong type of exceptions",
            exception instanceof IllegalStateException);

        iter.next();
        iter.remove();
        assertTrue(ll.toString().equals("{hola, hello}"));
    }
}
