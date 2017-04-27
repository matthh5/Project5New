package prj5;

import junit.framework.TestCase;

/**
 * Test class for the Response Class, includes tests for all the methods in response class
 *
 * @author Matt Hwang <matthh5> and Samantha Tao <Samant8>
 * @version 2017.04.26
 */
public class ResonseTest extends TestCase {
    private Response response;


    /**
     * sets up test cases, is called before every test case
     */
    public void setUp() {
        response = new Response(true, false, "All These Things I've Done",
            false, false);
    }


    /**
     * test the getHasHeard method when is it true
     */
    public void testGetHasHeard() {
        assertEquals(true, response.getHasHeard());
    }


    /**
     * test the getLikes method, when it is false
     */
    public void testGetLikes() {
        assertEquals(false, response.getLikes());
    }


    /**
     * test the getSongName method.
     */
    public void testGetSongName() {
        assertEquals("All These Things I've Done", response.getSongName());
    }


    /**
     * test the setHasHeard method when it is true and false
     */
    public void testSetHasHeard() {
        assertEquals(true, response.getHasHeard());
        response.setHasHeard(false);
        assertEquals(false, response.getHasHeard());
    }


    /**
     * test the setLikes method when it is true and false
     */
    public void testSetLikes() {
        assertEquals(false, response.getLikes());
        response.setLikes(true);
        assertEquals(true, response.getLikes());
    }


    /**
     * test the setSongName method.
     */
    public void testSetSongName() {
        assertEquals("All These Things I've Done", response.getSongName());
        response.setSongName("All You Need Is Love");
        assertEquals("All You Need Is Love", response.getSongName());
    }
    
    /**
     * tests isEmptyHasHeard() when it is false
     */
    public void testIsEmptyHasHeard()
    {
        assertEquals(response.isEmptyHasHeard(), false); 
    }
    
    /**
     * tests isEmptyLikes() when it is false
     */
    public void testIsEmptyLikes()
    {
        assertEquals(response.isEmptyLikes(), false); 
    }
}
