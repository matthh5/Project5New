package prj5;

import java.awt.Color;
import java.util.ArrayList;
import CS2114.Button;
import CS2114.Shape;
import CS2114.TextShape;
import CS2114.Window;
import CS2114.WindowSide;

/**
 * @author Matt Hwang <matthh5> and Samantha Tao <samant8>
 * @version 2017.04.26
 *
 * Front end class, has all the buttons and shows the glyphs
 * Contains methods that build the glyphs and display
 * Based on the user's preference shows glyphs based on hobby, region and major
 * as well as sort the glyphs by artist, year, title and song genre
 * Display glyphs with 9 to a page, and next and previous buttons go through the array 
 * to represent pages in the window
 * There are fields for buttons, windows, and arrays
 */
public class GUIPrj5Window {
    private Window window;
    private Button prevButton;
    private Button nextButton;
    private Button sortByArtist;
    private Button sortByTitleButton;
    private Button sortByYearButton;
    private Button sortByGenre;
    private Button repHobbyButton;
    private Button repMajorButton;
    private Button repRegionButton;
    private Button quitButton;
    private LinkedList<Song> songList;
    //GUIPrjprivate ArrayList<Student> studentList;
    private int[] resultArray; 
    private String representBy; 
    //private int index; 
    private int songIndex; 

    /**
     * Default constructor for the GUIPjWindow class, initializes all the fields as well as creates the window
     * Adds buttons to the window, and links the methods to the buttons.
     *
     * @param songList LinkedList of songs that contain all the information to be displayed
     */
    public GUIPrj5Window(
        LinkedList<Song> songList) {
        this.songList = songList;
        //this.studentList = studentList;
        window = new Window("Project 5, Matthh5, samant8");
        window.setSize(1000, 600);
        prevButton = new Button("Prev");
        window.addButton(prevButton, WindowSide.NORTH);
        sortByArtist = new Button("Sort by Artist Name");
        window.addButton(sortByArtist, WindowSide.NORTH);
        sortByTitleButton = new Button("Sort by Song Title");
        window.addButton(sortByTitleButton, WindowSide.NORTH);
        sortByYearButton = new Button("Sort by Release Year");
        window.addButton(sortByYearButton, WindowSide.NORTH);
        sortByGenre = new Button("Sort by Genre");
        window.addButton(sortByGenre, WindowSide.NORTH);
        nextButton = new Button("Next");
        window.addButton(nextButton, WindowSide.NORTH);
        repHobbyButton = new Button("Represent by Hobby");
        window.addButton(repHobbyButton, WindowSide.SOUTH);
        repMajorButton = new Button("Represent by Major");
        window.addButton(repMajorButton, WindowSide.SOUTH);
        repRegionButton = new Button("Represent by Region");
        window.addButton(repRegionButton, WindowSide.SOUTH);
        quitButton = new Button("Quit");
        window.addButton(quitButton, WindowSide.SOUTH);
        
        sortByArtist.onClick(this, "clickedSortArtistName");
        sortByTitleButton.onClick(this, "clickedSortSongTitle");
        sortByYearButton.onClick(this, "clickedSortSongYear");
        sortByGenre.onClick(this, "clickedSortGenre");
        quitButton.onClick(this, "clickedQuit");
        nextButton.onClick(this, "clickedNext");
        prevButton.onClick(this, "clickedPrev");
        repHobbyButton.onClick(this, "clickedRepHobby");
        repMajorButton.onClick(this, "clickedRepMajor");
        repRegionButton.onClick(this, "clickedRepRegion");
        // sortSongsByArtist();
        // representHobby();
        //index = 0; 
        songIndex = 0; 
        resultArray = Input.representMajor(); 
        this.representBy = "Hobby"; 
        prevButton.disable();
        //drawLegend(); 
        //displayResults(); 
        //displayGlyph(500, 100, songList.get(0), 0); 
        //displayGlyphs(); 
    }
    
    /**
     * Method that draws the legend for the window. Based on the representation by the user
     * the legend changes to accomodate that. If the representBy is equal to hobby the legend
     * changes to read, art, sports, and music, which describe what the glyphs represent.
     * If RepresentBy is equal to Major the legend changes to Computer science, Other Engineering
     * Math or CMDA, and Other. Lastly if RepresentBy is set to Region, the legend changes to NorthEast us, 
     * Southeast us, rest of us and outside of us
     */
    public void drawLegend()
    {
        Shape box = new Shape(820, 245, 150, 200);
        box.setBackgroundColor(Color.WHITE);
        box.setForegroundColor(Color.BLACK);
        TextShape legend = new TextShape(835, 260, "" + representBy + " Legend", Color.black);
        legend.setBackgroundColor(Color.WHITE); 
        TextShape text1 = new TextShape(835, 280, "asdf", Color.MAGENTA);
        text1.setBackgroundColor(Color.WHITE);
        TextShape text2 = new TextShape(835, 300, "asdf", Color.BLUE);
        text2.setBackgroundColor(Color.WHITE);
        TextShape text3 = new TextShape(835, 320, "asdf", Color.ORANGE);
        text3.setBackgroundColor(Color.WHITE);
        TextShape text4 = new TextShape(835, 340, "asdf", Color.GREEN);
        text4.setBackgroundColor(Color.WHITE);
        TextShape heard = new TextShape(835, 400, "Heard", Color.BLACK);
        heard.setBackgroundColor(Color.white);
        TextShape songTitle = new TextShape(860, 360, "Song Title", Color.BLACK);
        songTitle.setBackgroundColor(Color.WHITE);
        Shape bar = new Shape(885, 380, 5, 50, Color.black); 
        TextShape likes = new TextShape(895, 400, "Likes", Color.BLACK);
        
        if(representBy.equals("Hobby"))
        {
            text1.setText("Read");
            text2.setText("art");
            text3.setText("sports");
            text4.setText("music");
        }
        if(representBy.equals("Major"))
        {
            text1.setText("Computer Science");
            text2.setText("Other Engineering");
            text3.setText("Math or CMDA");
            text4.setText("Other");
        }
        if(representBy.equals("Region"))
        {
            text1.setText("Northeast US");
            text2.setText("Southeast US");
            text3.setText("Rest of US");
            text4.setText("Outside US");
        }
        
        likes.setBackgroundColor(Color.white);
        window.addShape(legend);
        window.addShape(text1);
        window.addShape(text2);
        window.addShape(text3);
        window.addShape(text4);
        window.addShape(songTitle);
        window.addShape(heard);
        window.addShape(bar);
        window.addShape(likes);
        window.addShape(box);
    }
    
    /**
     * Onclick of the next button, the previous button will be enabled as well as remove all 
     * shapes on the window. After that it will grab the next set of information to be displayed
     * as glyphs
     *
     * @param button the button clicked that would call the ClickedNext Method
     */
    public void clickedNext(Button button)
    {
        prevButton.enable();
        window.removeAllShapes();
        displayGlyphs(); 
    }
    
    /**
     * Onclick of the prev button if it is at the front of the "pages" the previous button is disabled
     * Otherwise it will traverse the "pages" and move through to the beginning if clicked that
     * many times
     *
     * @param button the button clicked that would call the clickedPrev Method
     */
    public void clickedPrev(Button button)
    {
        if(songIndex - 18 >= 0)
        {
            nextButton.enable();
            songIndex = songIndex - 18; 
            window.removeAllShapes();
            displayGlyphs();
        }
        if(songIndex - 9 <= 0)
        {
            prevButton.disable();
        }
    }
    
    /**
     * Method that displays 9 glyphs to a screen
     * Calls the displayGlyph method and places the next 9 glyphs on the page
     * As each glyph is placed, the index is incremented to traverse the array 
     */
    public void displayGlyphs()
    {
        if(songIndex < songList.size())
        {
            drawLegend(); 
            int y = 60;
            for(int j = 0; j < 3; j++)
            {
                int x = 100;
                for(int i = 0; i < 3; i++)
                {
                    if(songIndex < songList.size())
                    {
                        Song song = songList.get(songIndex);
                        displayGlyph(x, y, song, songIndex * 8); 
                        
                        x = x + window.getWidth()/3 - 30;
                    }
                    else
                    {
                        nextButton.disable();
                    }
                    songIndex++; 
                }
                y = y + window.getHeight()/3 - 50; 
            }
        }   
    }
    
    /**
     * Method that draws the glyphs and grabs the data from the song passed through from
     * the parameters. The glyphs represent likes and heards based on the representation passed
     * and length of the bars is based on the percentages of students that have heard and liked based
     * on the category
     *
     * @param x the x coordinate where the bar should be created
     * @param y the y coordinate where the bar should be created
     * @param song the song that we are getting infomation from such as artist name and song title
     * @param index the index of the array where the information is stored in
     */
    public void displayGlyph(int x, int y, Song song, int index)
    {
        int stem1 = resultArray[index];
        int stem2 = resultArray[index + 1];
        int stem3 = resultArray[index + 2];
        int stem4 = resultArray[index + 3]; 
        int stem5 = resultArray[index + 4];
        int stem6 = resultArray[index + 5];
        int stem7 = resultArray[index + 6];
        int stem8 = resultArray[index + 7]; 
        TextShape title = new TextShape(x, y - 40, song.getSongTitle());
        title.setX(x - title.getWidth()/2);
        title.setBackgroundColor(Color.white);
        window.addShape(title); 
        TextShape artist = new TextShape(x, y - 20, "By " + song.getArtistName());
        artist.setX(x - artist.getWidth()/2);
        artist.setBackgroundColor(Color.white);
        window.addShape(artist);
        Shape middle = new Shape(x, y, 5, 40, Color.black); 
        window.addShape(middle);
        Shape bar1 = new Shape(x - (stem1 * 1), y, stem1 * 1, 10, Color.magenta);
        window.addShape(bar1);
        Shape bar2 = new Shape(x, y, stem2 * 1, 10, Color.MAGENTA);
        window.addShape(bar2);
        Shape bar3 = new Shape(x - (stem3 * 1), y + 10, stem3 * 1, 10, Color.blue);
        window.addShape(bar3);
        Shape bar4 = new Shape(x, y + 10, stem4 * 1, 10, Color.blue); 
        window.addShape(bar4);
        Shape bar5 = new Shape(x - (stem5 * 1), y + 20, stem5 * 1, 10, Color.orange); 
        window.addShape(bar5);
        Shape bar6 = new Shape(x, y + 20, stem6 * 1, 10, Color.orange); 
        window.addShape(bar6);
        Shape bar7 = new Shape(x - (stem7 * 1), y + 30, stem7 * 1, 10, Color.GREEN); 
        window.addShape(bar7);
        Shape bar8 = new Shape(x, y + 30, stem8 * 1, 10, Color.green); 
        window.addShape(bar8);   
    }
    
    /**
     * Method called when the quit button is clicked, exits the window
     *
     * @param button button clicked to call the method clickedQuit
     */
    public void clickedQuit(Button button)
    {
        System.exit(0);
    }
    
    /**
     * Sorts the list of songs based on Artist name alphabetically
     * All the shapes are removed and then
     * When called the list is sorted, and then the glyphs are displayed again in the new order
     *
     * @param button the button clicked to call the method clickedSortArtistName
     */
    public void clickedSortArtistName(Button button)
    {
        songList = Input.sortSongsByArtistName();
        if(representBy.equals("Major"))
        {
            resultArray = Input.representMajor();
        }
        else if(representBy.equals("Hobby"))
        {
            resultArray = Input.representHobby();
        }
        else
        {
            resultArray = Input.representRegion(); 
        }
        //displayResults(); 
        songIndex = 0;
        window.removeAllShapes();
        displayGlyphs(); 
    }
    
    /**
     * Sorts the list of songs alphabetically based on the song title
     * All the shapes are removed and then when called the list is sorted,
     * and then the glyphs are displayed in the new order
     *
     * @param button the button clicked that will call the method clickedSortSongTitle
     */
    public void clickedSortSongTitle(Button button)
    {
        songList = Input.sortSongsByTitle();
        if(representBy.equals("Major"))
        {
            resultArray = Input.representMajor();
        }
        else if(representBy.equals("Hobby"))
        {
            resultArray = Input.representHobby();
        }
        else
        {
            resultArray = Input.representRegion(); 
        }
        songIndex = 0;
        window.removeAllShapes();
        displayGlyphs(); 
    }
    
    /**
     * Sorts the list of songs in numeric order, incremental
     * All the shapes are removed and then when called the list is sorted,
     * and then the glyphs are displayed in the new order
     *
     * @param button the button clicked that will call the method clickedSortSongYear
     */
    public void clickedSortSongYear(Button button)
    {
        songList = Input.sortSongsByReleaseYear();
        if(representBy.equals("Major"))
        {
            resultArray = Input.representMajor();
        }
        else if(representBy.equals("Hobby"))
        {
            resultArray = Input.representHobby();
        }
        else
        {
            resultArray = Input.representRegion(); 
        }
        songIndex = 0;
        window.removeAllShapes();
        displayGlyphs(); 
    }
    
    /**
     * Sorts the list of songs alphabetically based on the song's genre
     * All the shapes are removed and then when called the list is sorted,
     * and then the glyphs are displayed in the new order
     *
     * @param button the button clicked that will call the method clickedSortGenre
     */
    public void clickedSortGenre(Button button)
    {
        songList = Input.sortSongsByGenre();
        if(representBy.equals("Major"))
        {
            resultArray = Input.representMajor();
        }
        else if(representBy.equals("Hobby"))
        {
            resultArray = Input.representHobby();
        }
        else
        {
            resultArray = Input.representRegion(); 
        }
        songIndex = 0;
        window.removeAllShapes();
        displayGlyphs(); 
    }
    
    /**
     * Changes the representation of the glyphs to hobby
     * The glyph lengths will be changed based on the percentages of liked and heard for the 
     * categories in the hobby which are read, art, sports, and music
     * 
     * @param button the button clicked that calls this method clickedRepHobby
     */
    public void clickedRepHobby(Button button)
    {
        representBy = "Hobby"; 
        resultArray = Input.representHobby();
        window.removeAllShapes();
        if(songIndex > 0)
        {
            songIndex = songIndex - 9;    
        }
        displayGlyphs(); 
    }
    
     /**
     * Changes the representation of the glyphs to major
     * The glyph lengths will be changed based on the percentages of liked and heard for the 
     * categories in the major which are computer science, other engineering, math or cmda, and other
     * 
     * @param button the button clicked that calls this method clickedRepMajor
     */
    public void clickedRepMajor(Button button)
    {
        representBy = "Major"; 
        resultArray = Input.representMajor();
        window.removeAllShapes();
        if(songIndex > 0)
        {
            songIndex = songIndex - 9;    
        }
        displayGlyphs(); 
    }
    
     /**
     * Changes the representation of the glyphs to Region
     * The glyph lengths will be changed based on the percentages of liked and heard for the 
     * categories in the region which are Northeast US, Southeast US, rest of US and outside of US
     * 
     * @param button the button clicked that calls this method clickedRepRegion
     */
    public void clickedRepRegion(Button button)
    {
        representBy = "Region"; 
        resultArray = Input.representRegion();
        window.removeAllShapes();
        if(songIndex > 0)
        {
            songIndex = songIndex - 9;    
        } 
        displayGlyphs(); 
    }
    
    /**public void displayResults() {
        int numSong = 0;
        for (int i = 0; i < songList.size(); i++) {
            Song song = songList.get(i);
            int index = numSong * 8;
            System.out.println("Song Title: " + song.getSongTitle());
            System.out.println("Song Artist: " + song.getArtistName());
            System.out.println("Song Genre: " + song.getGenre());
            System.out.println("Song Year: " + song.getYear());
            System.out.println("Heard");
            System.out.println("reading:" + resultArray[index] + " art:"
                + resultArray[index + 1] + " sports:" + resultArray[index + 2]
                + " music:" + resultArray[index + 3]);
            System.out.println("Likes");
            System.out.println("reading:" + resultArray[index + 4] + " art:"
                + resultArray[index + 5] + " sports:" + resultArray[index + 6]
                + " music:" + resultArray[index + 7]);
            System.out.println("");
            numSong++;
        }
        System.out.println("---------------------------------------------");
    }
    */
}
