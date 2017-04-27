/**
 * 
 */
package prj5;

import junit.framework.TestCase;

/**
 * @author Mary
 * @version 4/20
 */
public class SongTest extends TestCase {

    private Song song;


    /**
     * sets up test cases
     */
    public void setUp() {
        song = new Song("The Killers", "All These Things I've Done",
            "alternative", "2005");
    }


    /**
     * test the getArtistName method
     */ 
    public void testGetArtistName() {
        assertEquals("The Killers", song.getArtistName());
    }


    /**
     * test the getSongTitle method
     */
    public void testGetSongTitle() {
        assertEquals("All These Things I've Done", song.getSongTitle());
    }


    /**
     * test the getGenre method
     */
    public void testGetGenre() {
        assertEquals("alternative", song.getGenre());
    }


    /**
     * test the getYear method
     */
    public void getYear() {
        assertEquals("2005", song.getYear());
    }


    /**
     * test the setArtistName method
     */
    public void testSetArtistName() {
        song.setArtistName("The Beatles");
        assertEquals("The Beatles", song.getArtistName());
    }


    /**
     * test the setSongTitle method
     */
    public void testSetSongTitle() {
        song.setSongTitle("All You Need Is Love");
        assertEquals("All You Need Is Love", song.getSongTitle());
    }


    /**
     * test the setGenre method
     */
    public void testSetGenre() {
        song.setGenre("pop rock");
        assertEquals("pop rock", song.getGenre());
    }


    /**
     * test the setYear method
     */
    public void testSetYear() {
        song.setYear("1967");
        assertEquals("1967", song.getYear());
    }

}
