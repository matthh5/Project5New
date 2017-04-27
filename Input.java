package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Matt Hwang <matthh5> and Samantha Tao <samant8>
 *
 * Input class that imports data from SongList2017S.cvs and MusicSurvetData2017S.csv and
 * creates a songList that has all the information from the data such as song name, title, and 
 * the accordingly likes and heard for each category. 
 *
 * @param stringNameList the list that contains only the name of the songs
 * @param students list of all the student objects
 * @param songList the linkedlist that contains all of the song objects
 * @param resultArray the array that contains all of the data information of song list, artist name and 
 *        the survery percentages
 */
public class Input {
    private static ArrayList<String> stringNameList;
    private static ArrayList<Student> students;
    private static LinkedList<Song> songList;
    private static int[] resultArray;

    /**
     * The main method that creates a window with parameters of songlist and students
     * makes the songlist and people list with the file names, and hard codes the data into the program
     *
     * @param args the array that holds the names of the files
     */
    public static void main(String[] args) {
        String file1 = "SongList2017S.csv";
        String file2 = "MusicSurveyData2017S.csv";
        if (args.length > 0) {
            file1 = args[1];
            file2 = args[0];
        }
        songList = new LinkedList<Song>();
        stringNameList = new ArrayList<String>();
        students = new ArrayList<Student>();
        makeSongList(file1);
        makePeopleList(file2);
        GUIPrj5Window window = new GUIPrj5Window(songList, students);
    }

    /**
     * Displays the result in a toString that returns the songs title, artist name, genre and year
     * with the percentages of likes and heards for each of the hobby categories
     */
    public static void displayResults() {
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
    }

    /**
     * Method that makes the songlist that takes a file as a parameter
     * The scanner scans the file and adds the data into the SongList 
     * If the file is null throw FileNotFoundException
     *
     * @param fileName the file that gets scanned and imported into the songList
     */
    public static void makeSongList(String fileName) {

        Scanner file = null;
        try {
            file = new Scanner(new File(fileName));
        }
        catch (FileNotFoundException e) {
            System.out.println(Thread.currentThread().getStackTrace());
            System.exit(0);
        }
        file.nextLine();

        while (file.hasNext()) {
            String line = file.nextLine();
            String[] data = line.split(",");
            stringNameList.add(data[0]);
            Song song = new Song(data[1], data[0], data[3], data[2]);
            songList.add(song);

        }
    }
    
    /**
     * Method that makes the students list that takes a file as a parameter
     * The scanner scans the file and adds the data into the students  
     * If the file is null throw FileNotFoundException
     *
     * @param fileName the file that gets scanned and imported into the students
     */
    public static void makePeopleList(String fileName) {
        Scanner file = null;
        try {
            file = new Scanner(new File(fileName));
        }
        catch (FileNotFoundException e) {
            System.out.println(Thread.currentThread().getStackTrace());
            System.exit(0);
        }
        file.nextLine();
        while (file.hasNext()) {
            String line = file.nextLine();
            String[] data = line.split(",");
            if (data.length > 2) {
                Student student = new Student(line, stringNameList);
                students.add(student);
            }
        }
    }


    /**
     * Method that when called, sorts the songlist based on genre
     * sorted with the selection sort, the list is sorted by its genre alphabetically
     * 
     * @return songList the sorted list
     */
    public static LinkedList<Song> sortSongsByGenre() {
        for (int i = 0; i < songList.size(); i++) {
            int maxSongIndex = 0;
            for (int j = 0; j < songList.size() - i; j++) {
                String currGenre = songList.get(j).getGenre();
                String maxGenre = songList.get(maxSongIndex).getGenre();
                if (currGenre.compareTo(maxGenre) > 0) {
                    maxSongIndex = j;
                }
            }
            songList.add(songList.size() - i, songList.get(maxSongIndex));
            songList.remove(maxSongIndex);
        }
        return songList;
    }

     /**
     * Method that when called, sorts the songlist based on Song title
     * sorted with the selection sort, the list is sorted by its title alphabetically
     * 
     * @return songList the sorted list
     */
    public static LinkedList<Song> sortSongsByTitle() {
        for (int i = 0; i < songList.size(); i++) {
            int maxSongIndex = 0;
            for (int j = 0; j < songList.size() - i; j++) {
                String currTitle = songList.get(j).getSongTitle();
                String maxTitle = songList.get(maxSongIndex).getSongTitle();
                if (currTitle.compareTo(maxTitle) > 0) {
                    maxSongIndex = j;
                }
            }
            songList.add(songList.size() - i, songList.get(maxSongIndex));
            songList.remove(maxSongIndex);
        }
        return songList;
    }

     /**
     * Method that when called, sorts the songlist based on Artist Name
     * sorted with the selection sort, the list is sorted by its Artist Name alphabetically
     * 
     * @return songList the sorted list
     */
    public static LinkedList<Song> sortSongsByArtistName() {
        for (int i = 0; i < songList.size(); i++) {
            int maxSongIndex = 0;
            for (int j = 0; j < songList.size() - i; j++) {
                String currName = songList.get(j).getArtistName();
                String maxName = songList.get(maxSongIndex).getArtistName();
                if (currName.compareTo(maxName) > 0) {
                    maxSongIndex = j;
                }
            }
            songList.add(songList.size() - i, songList.get(maxSongIndex));
            songList.remove(maxSongIndex);
        }
        return songList;
    }

    /**
     * Method that when called, sorts the songlist based on Song release year
     * sorted with the selection sort, the list is sorted by its song release year numerically
     * 
     * @return songList the sorted list
     */
    public static LinkedList<Song> sortSongsByReleaseYear() {
        for (int i = 0; i < songList.size(); i++) {
            int maxSongIndex = 0;
            for (int j = 0; j < songList.size() - i; j++) {
                String currYear = songList.get(j).getYear();
                String maxYear = songList.get(maxSongIndex).getYear();
                if (currYear.compareTo(maxYear) > 0) {
                    maxSongIndex = j;
                }
            }
            songList.add(songList.size() - i, songList.get(maxSongIndex));
            songList.remove(maxSongIndex);
        }
         return songList;
    }

    /**
     * Parses through the students list and records if each student has heard or liked
     * each of the songs and records that in a field, it is then divided by the number of students
     * whom replied and outputs a percentage of students who like and have heard each song
     * this data is then recorded into the resultArray. The resultArray is unique to hobby when
     * this method is called and data values after the title and artist contains numeric number percentages
     * that represent each hobby category
     */
    public static int[] representHobby() {
        resultArray = new int[songList.size() * 8];
        int songNum = 0;
        for (int i = 0; i < songList.size(); i++) {
            String songName = songList.get(i).getSongTitle();
            int readingLikes = 0;
            int artLikes = 0;
            int sportsLikes = 0;
            int musicLikes = 0;
            int numReadingHeard = 0;
            int numArtHeard = 0;
            int numSportsHeard = 0;
            int numMusicHeard = 0;
            int numReading = 0;
            int numArt = 0;
            int numSports = 0;
            int numMusic = 0;

            int numHeardReadingResponses = 0;
            int numLikesReadingResponses = 0;

            int numHeardArtResponses = 0;
            int numLikesArtResponses = 0;

            int numHeardSportsResponses = 0;
            int numLikesSportsResponses = 0;

            int numHeardMusicResponses = 0;
            int numLikesMusicResponses = 0;

            for (int j = 0; j < students.size(); j++) {
                Student student = students.get(j);
                String hobby = student.getHobby();
                if (hobby.equals("reading")) {
                    numReading++;
                    if (!student.emptyHasHeardResponse(songName)) {
                        numHeardReadingResponses++;
                    }
                    if (!student.emptyLikesResponse(songName)) {
                        numLikesReadingResponses++;
                    }
                    if (student.getHasHeard(songName)) {
                        numReadingHeard++;

                    }
                    if (student.getLikes(songName)) {
                        readingLikes++;
                    }
                }
                if (hobby.equals("art")) {
                    numArt++;
                    if (!student.emptyHasHeardResponse(songName)) {
                        numHeardArtResponses++;
                    }
                    if (!student.emptyLikesResponse(songName)) {
                        numLikesArtResponses++;
                    }
                    if (student.getHasHeard(songName)) {
                        numArtHeard++;

                    }
                    if (student.getLikes(songName)) {
                        artLikes++;
                    }
                }
                if (hobby.equals("sports")) {
                    numSports++;
                    if (!student.emptyHasHeardResponse(songName)) {
                        numHeardSportsResponses++;
                    }
                    if (!student.emptyLikesResponse(songName)) {
                        numLikesSportsResponses++;
                    }
                    if (student.getHasHeard(songName)) {
                        numSportsHeard++;

                    }
                    if (student.getLikes(songName)) {
                        sportsLikes++;
                    }
                }
                if (hobby.equals("music")) {
                    numMusic++;
                    if (!student.emptyHasHeardResponse(songName)) {
                        numHeardMusicResponses++;
                    }
                    if (!student.emptyLikesResponse(songName)) {
                        numLikesMusicResponses++;
                    }
                    if (student.getHasHeard(songName)) {
                        numMusicHeard++;
                    }
                    if (student.getLikes(songName)) {
                        musicLikes++;
                    }
                }
            }
            resultArray[songNum * 8] = (int)((numReadingHeard * 1.0
                / numHeardReadingResponses) * 100);
            resultArray[songNum * 8 + 1] = (int)((numArtHeard * 1.0
                / numHeardArtResponses) * 100);
            resultArray[songNum * 8 + 2] = (int)((numSportsHeard * 1.0
                / numHeardSportsResponses) * 100);
            resultArray[songNum * 8 + 3] = (int)((numMusicHeard * 1.0
                / numHeardMusicResponses) * 100);
   
            resultArray[songNum * 8 + 4] = (int)((readingLikes * 1.0
                / numLikesReadingResponses) * 100);
            resultArray[songNum * 8 + 5] = (int)((artLikes * 1.0
                / numLikesArtResponses) * 100);
            resultArray[songNum * 8 + 6] = (int)((sportsLikes * 1.0
                / numLikesSportsResponses) * 100);
            resultArray[songNum * 8 + 7] = (int)((musicLikes * 1.0
                / numLikesMusicResponses) * 100);
            songNum++;
        }
        return resultArray;
    }

    /**
     * Parses through the students list and records if each student has heard or liked
     * each of the songs and records that in a field, it is then divided by the number of students
     * whom replied and outputs a percentage of students who like and have heard each song
     * this data is then recorded into the resultArray. The resultArray is unique to major when
     * this method is called and data values after the title and artist contains numeric number percentages
     * that represent each major category
     */
    public static int[] representMajor() {
        resultArray = new int[songList.size() * 8];
        int songNum = 0;
        for (int i = 0; i < songList.size(); i++) {
            String songName = songList.get(i).getSongTitle();
            int CsLikes = 0;
            int EngineeringLikes = 0;
            int cmdaLikes = 0;
            int otherLikes = 0;
            int numCsHeard = 0;
            int numEngineeringHeard = 0;
            int numCmdaHeard = 0;
            int numOtherHeard = 0;

            int numHeardCsResponses = 0;
            int numLikesCsResponses = 0;

            int numHeardEngineeringResponses = 0;
            int numLikesEngineeringResponses = 0;

            int numHeardCmdaResponses = 0;
            int numLikesCmdaResponses = 0;

            int numHeardOtherResponses = 0;
            int numLikesOtherResponses = 0;

            for (int j = 0; j < students.size(); j++) {
                Student student = students.get(j);
                String major = student.getMajor();
                if (major.equals("Computer Science")) {
                    if (!student.emptyHasHeardResponse(songName)) {
                        numHeardCsResponses++;
                    }
                    if (!student.emptyLikesResponse(songName)) {
                        numLikesCsResponses++;
                    }
                    if (student.getHasHeard(songName)) {
                        numCsHeard++;

                    }
                    if (student.getLikes(songName)) {
                        CsLikes++;
                    }
                }
                if (major.equals("Other Engineering")) {
                    if (!student.emptyHasHeardResponse(songName)) {
                        numHeardEngineeringResponses++;
                    }
                    if (!student.emptyLikesResponse(songName)) {
                        numLikesEngineeringResponses++;
                    }
                    if (student.getHasHeard(songName)) {
                        numEngineeringHeard++;

                    }
                    if (student.getLikes(songName)) {
                        EngineeringLikes++;
                    }
                }
                if (major.equals("Math or CMDA")) {
                    if (!student.emptyHasHeardResponse(songName)) {
                        numHeardCmdaResponses++;
                    }
                    if (!student.emptyLikesResponse(songName)) {
                        numLikesCmdaResponses++;
                    }
                    if (student.getHasHeard(songName)) {
                        numCmdaHeard++;

                    }
                    if (student.getLikes(songName)) {
                        cmdaLikes++;
                    }
                }
                if (major.equals("Other")) {
                    if (!student.emptyHasHeardResponse(songName)) {
                        numHeardOtherResponses++;
                    }
                    if (!student.emptyLikesResponse(songName)) {
                        numLikesOtherResponses++;
                    }
                    if (student.getHasHeard(songName)) {
                        numOtherHeard++;
                    }
                    if (student.getLikes(songName)) {
                        otherLikes++;
                    }
                }

            }

            resultArray[songNum * 8] = (int)((numCsHeard * 1.0
                / numHeardCsResponses) * 100);
            resultArray[songNum * 8 + 1] = (int)((numEngineeringHeard * 1.0
                / numHeardEngineeringResponses) * 100);
            resultArray[songNum * 8 + 2] = (int)((numCmdaHeard * 1.0
                / numHeardCmdaResponses) * 100);
            resultArray[songNum * 8 + 3] = (int)((numOtherHeard * 1.0
                / numHeardOtherResponses) * 100);

            resultArray[songNum * 8 + 4] = (int)((CsLikes * 1.0
                / numLikesCsResponses) * 100);
            resultArray[songNum * 8 + 5] = (int)((EngineeringLikes * 1.0
                / numLikesEngineeringResponses) * 100);
            resultArray[songNum * 8 + 6] = (int)((cmdaLikes * 1.0
                / numLikesCmdaResponses) * 100);
            resultArray[songNum * 8 + 7] = (int)((otherLikes * 1.0
                / numLikesOtherResponses) * 100);
            songNum++;
        }
        return resultArray;
    }

    /**
     * Parses through the students list and records if each student has heard or liked
     * each of the songs and records that in a field, it is then divided by the number of students
     * whom replied and outputs a percentage of students who like and have heard each song
     * this data is then recorded into the resultArray. The resultArray is unique to Region when
     * this method is called and data values after the title and artist contains numeric number percentages
     * that represent each Region category
     */
    public static int[] representRegion() {
        resultArray = new int[songList.size() * 8];
        int songNum = 0;
        for (int i = 0; i < songList.size(); i++) {
            String songName = songList.get(i).getSongTitle();
            int northeastLikes = 0;
            int southeastLikes = 0;
            int usLikes = 0;
            int otherLikes = 0;
            int numNortheastHeard = 0;
            int numSoutheastHeard = 0;
            int numUsHeard = 0;
            int numOtherHeard = 0;

            int numHeardNortheastResponses = 0;
            int numLikesNortheastResponses = 0;

            int numHeardSoutheastResponses = 0;
            int numLikesSoutheastResponses = 0;

            int numHeardUsResponses = 0;
            int numLikesUsResponses = 0;

            int numHeardOtherResponses = 0;
            int numLikesOtherResponses = 0;

            for (int j = 0; j < students.size(); j++) {
                Student student = students.get(j);
                String region = student.getRegion();
                if (region.equals("Northeast")) {
                    if (!student.emptyHasHeardResponse(songName)) {
                        numHeardNortheastResponses++;
                    }
                    if (!student.emptyLikesResponse(songName)) {
                        numLikesNortheastResponses++;
                    }
                    if (student.getHasHeard(songName)) {
                        numNortheastHeard++;

                    }
                    if (student.getLikes(songName)) {
                        northeastLikes++;
                    }
                }
                if (region.equals("Southeast")) {
                    if (!student.emptyHasHeardResponse(songName)) {
                        numHeardSoutheastResponses++;
                    }
                    if (!student.emptyLikesResponse(songName)) {
                        numLikesSoutheastResponses++;
                    }
                    if (student.getHasHeard(songName)) {
                        numSoutheastHeard++;

                    }
                    if (student.getLikes(songName)) {
                        southeastLikes++;
                    }
                }
                if (region.equals(
                    "United States (other than Southeast or Northwest)")) {
                    if (!student.emptyHasHeardResponse(songName)) {
                        numHeardUsResponses++;
                    }
                    if (!student.emptyLikesResponse(songName)) {
                        numLikesUsResponses++;
                    }
                    if (student.getHasHeard(songName)) {
                        numUsHeard++;

                    }
                    if (student.getLikes(songName)) {
                        usLikes++;
                    }
                }
                if (region.equals("Outside of United States")) {
                    if (!student.emptyHasHeardResponse(songName)) {
                        numHeardOtherResponses++;
                    }
                    if (!student.emptyLikesResponse(songName)) {
                        numLikesOtherResponses++;
                    }
                    if (student.getHasHeard(songName)) {
                        numOtherHeard++;
                    }
                    if (student.getLikes(songName)) {
                        otherLikes++;
                    }
                }

            }

            resultArray[songNum * 8] = (int)((numNortheastHeard * 1.0
                / numHeardNortheastResponses) * 100);
            resultArray[songNum * 8 + 1] = (int)((numSoutheastHeard * 1.0
                / numHeardSoutheastResponses) * 100);
            resultArray[songNum * 8 + 2] = (int)((numUsHeard * 1.0
                / numHeardUsResponses) * 100);
            resultArray[songNum * 8 + 3] = (int)((numOtherHeard * 1.0
                / numHeardOtherResponses) * 100);

            resultArray[songNum * 8 + 4] = (int)((northeastLikes * 1.0
                / numLikesNortheastResponses) * 100);
            resultArray[songNum * 8 + 5] = (int)((southeastLikes * 1.0
                / numLikesSoutheastResponses) * 100);
            resultArray[songNum * 8 + 6] = (int)((usLikes * 1.0
                / numLikesUsResponses) * 100);
            resultArray[songNum * 8 + 7] = (int)((otherLikes * 1.0
                / numLikesOtherResponses) * 100);
            songNum++;
        }
        return resultArray;
    }
}
