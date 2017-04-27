package prj5;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Matt Hwang <matthh5> and Samantha Tao <samnt8>
 * @version 2017.04.46
 *
 * Class that tests the LinkedList class and tests all the individual methods in the Linked
 * list class
 */
public class LinkedListTest extends student.TestCase {
    private LinkedList<String> list1;
    private LinkedList<String> emptyList;


    /**
     * Method that sets up all of the test methods, is called before every method
     */
    public void setUp() {
        list1 = new LinkedList<String>();
        list1.add("apple");
        list1.add("banana");
        list1.add("mango");
        list1.add("kiwi");

        emptyList = new LinkedList<String>();
    }


    /**
     * Test the size() method, when the list is empty, and not empty
     */
    public void testSize() {
        assertEquals(0, emptyList.size());
        emptyList.add("apple");
        assertEquals(1, emptyList.size());
        assertEquals(4, list1.size());
    }


    /**
     * Test the add method when the string is null and attempts to add
     * a string to a position not in the string, also test when everything is normal
     */
    public void testAdd() {
        String nullString = null;
        Exception exception = null;
        try {
            list1.add(1, nullString);
        }
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(exception instanceof IllegalArgumentException);

        Exception exception2 = null;
        try {
            list1.add(-1, "String");
        }
        catch (Exception e) {
            exception2 = e;
        }
        assertNotNull(exception2);
        assertTrue(exception2 instanceof IndexOutOfBoundsException);
        assertEquals(list1.size(), 4);

        Exception exception3 = null;
        try {
            list1.add(5, "String");
        }
        catch (Exception e) {
            exception3 = e;
        }
        assertNotNull(exception3);
        assertTrue(exception3 instanceof IndexOutOfBoundsException);

        list1.add(2, "String");
        assertEquals(list1.size(), 5);
        assertEquals(list1.get(2), "String");
        list1.add(0, "String0");
        System.out.println(list1.toString());
        assertEquals(list1.get(0), "String0");
        list1.add(6, "StringEnd");
        assertEquals(list1.get(6), "StringEnd");
        System.out.println(list1.toString());
        emptyList.add(0, "String1");
        assertEquals(emptyList.size(), 1);
        assertEquals(emptyList.get(0), "String1");
    }


    /**
     * test the add method with an exception and calls an indexoutofboundsException
     */
    public void testAddException() {

        Exception exception = null;
        try {
            list1.add(7, "peach");

        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IndexOutOfBoundsException);
        assertNotNull(exception);
    }


    /**
     * test the add method another exception
     */
    public void testAddE() {
        Exception exception = null;
        try {
            list1.add(-1, "peach");

        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IndexOutOfBoundsException);
        assertNotNull(exception);
    }


    /**
     * test the add object when the str is null
     */
    public void testAddObj() {
        list1.add("orange");
        assertEquals(5, list1.size());
        String str = null;

        Exception exception = null;
        try {
            list1.add(str);

        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IllegalArgumentException);
        assertNotNull(exception);
    }


    /**
     * test the isEmpty method
     */
    public void testIsEmpty() {
        assertEquals(true, emptyList.isEmpty());
        emptyList.add("apple");
        assertEquals(false, emptyList.isEmpty());
    }


    /**
     * test the remove object method
     */
    public void testRemoveObj() {
        assertTrue(list1.remove("apple"));
        assertEquals(list1.size(), 3);
        assertEquals(list1.get(0), "banana");
        assertTrue(list1.remove("mango"));
        assertEquals(list1.size(), 2);
        assertEquals(list1.get(1), "kiwi");
        assertFalse(emptyList.remove(" "));
        list1.remove("kiwi");

        emptyList.add("String");
        assertTrue(emptyList.remove("String"));
    }


    /**
     * test the remove index method 
     * Attempts to remove an object when the index is out of bounds
     */
    public void testRemoveIndex() {
        assertTrue(list1.remove(0));
        assertEquals(list1.size(), 3);
        assertEquals(list1.get(0), "banana");
        list1.add("orange");
        list1.add("pear");
        assertTrue(list1.remove(2));
        System.out.print(list1.toString());
        assertTrue(list1.remove(3));
        System.out.print(list1.toString());

        Exception exception = null;
        try {
            list1.remove(-1);
        }
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(exception instanceof IndexOutOfBoundsException);

        Exception exception2 = null;
        try {
            emptyList.remove(0);
        }
        catch (Exception e) {
            exception2 = e;
        }
        assertNotNull(exception2);
        assertTrue(exception2 instanceof IndexOutOfBoundsException);

        Exception exception3 = null;
        try {
            list1.remove(10);
        }
        catch (Exception e) {
            exception3 = e;
        }
        assertNotNull(exception3);
        assertTrue(exception3 instanceof IndexOutOfBoundsException);

    }


    /**
     * test the get method, and tests the get method when the list is empty
     */
    public void testGet() {
        assertEquals("apple", list1.get(0));
        assertEquals("kiwi", list1.get(3));

        Exception exception = null;
        try {
            emptyList.get(0);

        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IndexOutOfBoundsException);
        assertNotNull(exception);

    }


    /**
     * test the contains method
     */
    public void testContains() {
        assertEquals(true, list1.contains("apple"));
        assertEquals(true, list1.contains("kiwi"));
        assertEquals(false, list1.contains("orange"));
    }


    /**
     * test the clear method when it was not full and empty
     */
    public void testClear() {

        assertEquals(4, list1.size());
        list1.clear();
        assertEquals(0, list1.size());
        list1.clear();
    }


    /**
     * test the lastIndexOf method
     */
    public void testLastIndexOf() {
        emptyList.add("orange");
        assertEquals(0, emptyList.lastIndexOf("orange"));
        list1.add(4, "apple");
        assertEquals(4, list1.lastIndexOf("apple"));
        assertEquals(-1, list1.lastIndexOf("orange"));
    }


    /**
     * test the toString() method
     */
    public void testToString() {
        assertEquals("{apple, banana, mango, kiwi}", list1.toString());
        assertEquals("{}", emptyList.toString());
    }


    /**
     * tests equals method with a list that is null, the same, and not same 
     */
    public void testEquals() {
        LinkedList<String> smallListA;
        LinkedList<String> smallListB;
        LinkedList<String> emptyListA = new LinkedList<String>();
        String nullObject = null;
        smallListA = new LinkedList<String>();
        smallListB = new LinkedList<String>();

        smallListA.add("soccer");
        smallListA.add("swimming");
        smallListA.add("gymnastics");

        smallListB.add("soccer");
        smallListB.add("swimming");
        smallListB.add("gymnastics");
        assertEquals(smallListA, smallListA);
        assertEquals(smallListA, smallListB);
        assertFalse(smallListA.equals(nullObject));
        assertFalse(smallListA.equals("soccer"));
        // assertFalse(smallListA.equals(bigListA));
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
        System.out.println(smallListA.toString());
        System.out.println(smallListB.toString());
        assertEquals(smallListA, smallListB);

    }


    /**
     * tests iterator hasNext()
     */
    public void testIteratorHasNext() {
        Iterator<String> iter = list1.iterator();
        assertTrue(iter.hasNext());
        iter.next();
        iter.next();
        iter.next();
        assertFalse(iter.hasNext());
    }


    /**
     * tests iterator next()
     */
    public void testIteratorNext() {
        Iterator<String> iter = list1.iterator();
        // assertEquals(iter.next(), "apple");
        assertEquals(iter.next(), "banana");
        assertEquals(iter.next(), "mango");
        assertEquals(iter.next(), "kiwi");

        Exception exception = null;
        try {
            iter.next();

        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof NoSuchElementException);
        assertNotNull(exception);
    }

}
