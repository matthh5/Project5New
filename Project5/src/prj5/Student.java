package prj5;

import java.util.ArrayList;

/**
 * @author group 24
 * @version 420
 *
 */
public class Student {

    private String hobby;
    private String major;
    private String region;
    private ArrayList<Response> response;


    /**
     * The constructor for the student class, instantiates the major, region and
     * hobby of the particular student
     * 
     * @param input
     *            string of input that has the major, region and hobby of
     *            student
     *
     * @param songs list of songs
     */
    public Student(String input, ArrayList<String> songs) {
        String[] data = input.split(",");
        major = data[2];
        region = data[3];
        hobby = data[4];
        response = new ArrayList<Response>();
        int songIndex = 0;
        int length = songs.size() * 2 + 5;
        // System.out.println("results size: " + length);
        for (int i = 5; i < length; i++) {
            Boolean emptyHasHeard = false;
            Boolean emptyLikes = false;
            Boolean hasHeard = false;
            if (i >= data.length) {
                hasHeard = false;
                emptyHasHeard = true;
            }
            else {
                if (data[i].equals("Yes")) {
                    hasHeard = true;
                }
                if (data[i].equals("")) {
                    emptyHasHeard = true;
                }
            }
            Boolean likes = false;
            if (i + 1 < length) {
                if (i + 1 >= data.length) {
                    likes = false;
                    emptyLikes = true;
                }
                else {
                    if (data[i + 1].equals("Yes")) {
                        likes = true;
                    }
                    if (data[i + 1].equals("")) {
                        emptyLikes = true;
                    }
                }
            }
            // else
            // {
            // completeResponse = true;
            // }
            // if(true)
            // {

            Response r = new Response(hasHeard, likes, songs.get(songIndex),
                emptyHasHeard, emptyLikes);
            response.add(r);
            // }
            songIndex++;
            i++;
        }

    }


    /**
     * Returns the hobby of the student
     * 
     * @return hobby
     */
    public String getHobby() {
        return hobby;
    }


    /**
     * Returns the major of the student
     * 
     * @return major
     */
    public String getMajor() {
        return major;
    }


    /**
     * Returns the region of the student
     * 
     * @return region
     */
    public String getRegion() {
        return region;
    }


    /**
     * @param songName
     *            song to check whether heard
     * @return boolean whether student has heard song
     */
    public boolean getHasHeard(String songName) {
        for (int i = 0; i < response.size(); i++) {
            if (response.get(i).getSongName().equals(songName)) {
                return response.get(i).getHasHeard();
            }
        }
        return false;
    }


    /**
     * @param songName
     *            song to check whether likes
     * @return boolean whether student likes song
     */
    public boolean getLikes(String songName) {
        for (int i = 0; i < response.size(); i++) {
            if (response.get(i).getSongName().equals(songName)) {
                return response.get(i).getLikes();
            }
        }
        return false;
    }


    /**
     * @param songName
     *            song to see if response is empty
     * @return boolean whether the heard response is empty
     */
    public boolean emptyHasHeardResponse(String songName) {
        for (int i = 0; i < response.size(); i++) {
            if (response.get(i).getSongName().equals(songName)) {
                return response.get(i).isEmptyHasHeard();
            }
        }
        return false;
    }


    /**
     * @param songName
     *            song to check if response is empty
     * @return boolean whether likes response is empty
     */
    public boolean emptyLikesResponse(String songName) {
        for (int i = 0; i < response.size(); i++) {
            if (response.get(i).getSongName().equals(songName)) {
                return response.get(i).isEmptyLikes();
            }
        }
        return false;
    }
}
