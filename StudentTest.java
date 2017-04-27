package prj5;

import java.util.ArrayList;

/**
 * @author group 3
 * @version 420
 */

public class StudentTest extends student.TestCase {

    private Student student;
    private Student student2;
    private Student student3;


    /**
     * sets up test cases
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
     * tests getHasHeard()
     */
    public void testGetHasHeard() {
        assertEquals(student.getHasHeard("American Pie"), true);
        assertEquals(student.getHasHeard("Anarchy in the UK"), false);
        assertEquals(student2.getHasHeard("American Pie"), false);
        assertEquals(student3.getHasHeard("Another One Bites the Dust"), false);
        assertEquals(student.getHasHeard("Not in list"), false);
    }


    /**
     * tests getLikes()
     */
    public void testGetLikes() {
        assertEquals(student.getLikes("American Pie"), false);
        assertEquals(student.getLikes("Not in list"), false);
        assertEquals(student.getLikes("All These Things I've Done"), true);
        assertEquals(student2.getLikes("American Pie"), true);
        assertEquals(student3.getLikes("Another One Bites the Dust"), false);
    }


    /**
     * tests emptyHasHeardResponse()
     */
    public void testEmptyHasHeardResponse() {
        assertEquals(student.emptyHasHeardResponse("American Pie"), false);
        assertEquals(student3.emptyHasHeardResponse(
            "Another One Bites the Dust"), true);
        assertEquals(student.emptyHasHeardResponse("Not in list"), false);
    }


    /**
     * tests emptyLikesResponse()
     */
    public void testEmptyLikesResponse() {
        assertEquals(student.emptyLikesResponse("American Pie"), false);
        assertEquals(student3.emptyLikesResponse("Another One Bites the Dust"),
            true);
        assertEquals(student.emptyLikesResponse("Not in list"), false);
    }

}
