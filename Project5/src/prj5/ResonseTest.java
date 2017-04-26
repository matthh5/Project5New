package prj5;

import junit.framework.TestCase;

/**
 * @author group 24
 * @version 420
 */
public class ResonseTest extends TestCase {
    private Response response;


    /**
     * sets up test cases
     */
    public void setUp() {
        response = new Response(true, false, "All These Things I've Done",
            false, false);
    }


    /**
     * test the getHasHeard method.
     */
    public void testGetHasHeard() {
        assertEquals(true, response.getHasHeard());
    }


    /**
     * test the getLikes method.
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
     * test the setHasHeard method.
     */
    public void testSetHasHeard() {
        assertEquals(true, response.getHasHeard());
        response.setHasHeard(false);
        assertEquals(false, response.getHasHeard());
    }


    /**
     * test the setLikes method.
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
     * tests isEmptyHasHeard()
     */
    public void testIsEmptyHasHeard()
    {
        assertEquals(response.isEmptyHasHeard(), false); 
    }
    
    /**
     * tests isEmptyLikes()
     */
    public void testIsEmptyLikes()
    {
        assertEquals(response.isEmptyLikes(), false); 
    }
}
