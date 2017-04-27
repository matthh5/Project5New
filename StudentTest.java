package prj5;

import java.util.ArrayList;

/**
 * Test class for the student class that tests all of the methods in the student class
 *
 * @author Matt Hwang <matthh5> and Samantha Tao <samant8>
 * @version 2017.04.26
 */

public class StudentTest extends student.TestCase {

    private Student student;
    private Student student2;
    private Student student3;


    /**
     * sets up test cases, is run before every test method is tested
     */
    public void setUp() {
        ArrayList<String> songList;
        String input = "1,10/14/15 10:11,Math or CMDA,Southeast,sports,"
            + "Yes,Yes,Yes,No,Yes,No,No,No,Yes,No";
        songList = new ArrayList<String>();
        songList.add("All These Things I've Done");
        songList.add("All You Need Is Love");
        songList.add("American Pie");
        songList.add("Anarchy in the UK");
        songList.add("Another One Bites the Dust");
        student = new Student(input, songList);
        String input2 = "3,10/14/15 10:28,Computer Science,Southeast,sports,"
            + "No,No,Yes,,,Yes,No,No,Yes,Yes";
        String input3 = "3,10/14/15 10:28,Computer Science,Southeast,sports,"
            + "No,No,Yes,,,Yes,No,No";
        student2 = new Student(input2, songList);
        student3 = new Student(input3, songList);
    }


    /**
     * tests getHobby()
     */
    public void testGetHobby() {
        assertEquals(student.getHobby(), "sports");
        student3.getClass();
    }


    /**
     * tests getMajor()
     */
    public void testGetMajor() {
        assertEquals(student.getMajor(), "Math or CMDA");
    }


    /**
     * tests getRegion()
     */
    public void testGetRegion() {
        assertEquals(student.getRegion(), "Southeast");
    }


    /**
     * tests getHasHeard() if the student has heard the particular song
     */
    public void testGetHasHeard() {
        assertEquals(student.getHasHeard("American Pie"), true);
        assertEquals(student.getHasHeard("Anarchy in the UK"), false);
        assertEquals(student2.getHasHeard("American Pie"), false);
        assertEquals(student3.getHasHeard("Another One Bites the Dust"), false);
        assertEquals(student.getHasHeard("Not in list"), false);
    }


    /**
     * tests getLikes() if the student likes the particular song
     */
    public void testGetLikes() {
        assertEquals(student.getLikes("American Pie"), false);
        assertEquals(student.getLikes("Not in list"), false);
        assertEquals(student.getLikes("All These Things I've Done"), true);
        assertEquals(student2.getLikes("American Pie"), true);
        assertEquals(student3.getLikes("Another One Bites the Dust"), false);
    }


    /**
     * tests emptyHasHeardResponse() if the student didn't respond if they heard the song or not
     */
    public void testEmptyHasHeardResponse() {
        assertEquals(student.emptyHasHeardResponse("American Pie"), false);
        assertEquals(student3.emptyHasHeardResponse(
            "Another One Bites the Dust"), true);
        assertEquals(student.emptyHasHeardResponse("Not in list"), false);
    }


    /**
     * tests emptyLikesResponse() if the student didn't respond if they liked the song or not
     */
    public void testEmptyLikesResponse() {
        assertEquals(student.emptyLikesResponse("American Pie"), false);
        assertEquals(student3.emptyLikesResponse("Another One Bites the Dust"),
            true);
        assertEquals(student.emptyLikesResponse("Not in list"), false);
    }

}
