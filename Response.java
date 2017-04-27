package prj5;

/**
 * Class of Response that contains fields if it is heard, liked and the name
 *
 * @author Matt Hwang <matthh5> and Samantha Tao <samant8>
 * @version 2017.04.26
 */
public class Response {

    private boolean hasHeard;
    private boolean likes;
    private String songName;
    private boolean emptyHasHeard;
    private boolean emptyLikes;


    /**
     * Constructor for the Response class, has variables if it is heard, liked
     * and the name of the song
     * 
     * @param name
     *            Name of the song
     * @param hasHeard whether hasHeard
     * @param likes whether likes
     * @param emptyHasHeard whether heard response is empty
     * @param emptyLikes whether likes response is empty 
     */
    public Response(
        Boolean hasHeard,
        Boolean likes,
        String name,
        boolean emptyHasHeard,
        boolean emptyLikes) {
        this.hasHeard = hasHeard;
        this.likes = likes;
        songName = name;
        this.emptyHasHeard = emptyHasHeard;
        this.emptyLikes = emptyLikes;
    }


    /**
     * Returns true or false if the song has been heard
     * 
     * @return true or false
     */
    public boolean getHasHeard() {
        return hasHeard;
    }


    /**
     * Returns true or false if the song is liked
     * 
     * @return true or false
     */
    public boolean getLikes() {
        return likes;
    }


    /**
     * Returns the songname
     * 
     * @return name of the song
     */
    public String getSongName() {
        return songName;
    }


    /**
     * Sets the hasheard to the boolean passed through the parameter
     * 
     * @param b
     *            the boolean passed if the song has been heard
     */
    public void setHasHeard(boolean b) {
        hasHeard = b;
    }


    /**
     * Sets the likes to the boolean passed through the parameter
     * 
     * @param b
     *            the boolean passed if the song is liked
     */
    public void setLikes(boolean b) {
        likes = b;
    }


    /**
     * Sets the song name to the string passed to the parameter
     * 
     * @param name
     *            the name of the song
     */
    public void setSongName(String name) {
        songName = name;
    }


    /**
     * True or false returns if the heard response was empty 
     *
     * @return boolean whether has heard response is empty
     */
    public boolean isEmptyHasHeard() {
        return emptyHasHeard;
    }


    /**
     * True or false returns if the liked was empty 
     * 
     * @return boolean whether likes response is empty 
     */
    public boolean isEmptyLikes() {
        return emptyLikes;
    }
}
