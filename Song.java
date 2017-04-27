package prj5;

/**
 * The class for song whch contains the fields for artistname, songtitle, genre and year
 *
 * @author Matt Hwang <matthh5> and Samantha Tao <samant8>
 * @version 2017.04.26
 */
public class Song {
    private String artistName;
    private String songTitle;
    private String genre;
    private String year;


    /** 
     * Default constructor for the song, initializes the artistname, songtitle
     * genre and year
     * @param artistName name of artist
     * @param songTitle title of song
     * @param genre genre of song
     * @param year year song released
     */
    public Song(
        String artistName,
        String songTitle,
        String genre,
        String year) {
        this.artistName = artistName;
        this.songTitle = songTitle;
        this.genre = genre;
        this.year = year;
    }


    /**
     * return the artist name as a string.
     * 
     * @return the artistName
     */
    public String getArtistName() {
        return artistName;
    }


    /**
     * return the song title as a string
     * 
     * @return the songTitle
     */
    public String getSongTitle() {
        return songTitle;
    }


    /**
     * return the genre as a string
     * 
     * @return the genre
     */
    public String getGenre() {
        return genre;
    }


    /**
     * return the date as a string
     * 
     * @return the date
     */
    public String getYear() {
        return year;
    }


    /**
     * set the artistName to the given String name
     * 
     * @param name
     *            name of the artist
     */
    public void setArtistName(String name) {
        artistName = name;
    }


    /**
     * set the songTitle to the given String title
     * 
     * @param title
     *            title of the song
     */
    public void setSongTitle(String title) {
        songTitle = title;
    }


    /**
     * set the genre to the given String genre name
     * 
     * @param genreName
     *            name of the genre
     */
    public void setGenre(String genreName) {
        genre = genreName;
    }


    /**
     * set the date to the given string dateNum
     * 
     * @param  yearNum
     *            the date of song release
     */
    public void setYear(String yearNum) {
        year = yearNum;
    }

}
