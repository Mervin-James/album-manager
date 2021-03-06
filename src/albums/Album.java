package albums;

/**
 * A class that defines an Album object by title, artist, genre, release
 * date, and availability.
 * The Album class also has getter methods defined for each title, artist,
 * availability, release date, and genre attributes. This class also contains
 * a setter method and a String representation generator for availability. In
 * addition, this class has a method to compare with other albums and to
 * generate a String representation of the album.
 *
 * @author Akshar Patel, Mervin James
 */
public class Album {
    private final String title;
    private final String artist;
    private Genre genre; //enum class; Classical, Country, Jazz, Pop, Unknown
    private Date releaseDate;
    private boolean isAvailable;

    /**
     * Constructs an album from title, artist, genre, date, and availability.
     *
     * @param title       the name of the album.
     * @param artist      the name of the artist of the album.
     * @param genre       the genre of the album.
     * @param releaseDate the date the album was released.
     * @param isAvailable the status of the availability of the album in
     *                    the collection.
     */
    public Album(String title, String artist, Genre genre, Date releaseDate,
                 boolean isAvailable) {
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.isAvailable = isAvailable;
    }

    /**
     * Constructs an album from its title and artist.
     *
     * @param title  the name of the album.
     * @param artist the name of the artist of the album.
     */
    public Album(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    /**
     * Generates a String representation of this album's availability.
     *
     * @return "is available" if the album is available to lend out and "is
     * not available" if otherwise.
     */
    private String availability() {
        return this.isAvailable ? "is available" : "is not available";
    }

    /**
     * Determines if this album and an object are equivalent.
     * If the object is an Album, the method compares this album's title and
     * artist attributes to the object's.
     *
     * @param obj the object that this Album is being compared to.
     * @return true if both objects are Album objects with identical titles
     * and artists, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Album) {
            Album album = (Album) obj;
            return (album.title.equals(this.title) &&
                    album.artist.equals(this.artist));
        }
        return false;
    }

    /**
     * Generates a String representation of this Album object.
     *
     * @return the String representation of this Album object.
     */
    @Override
    public String toString() {
        return title + "::" + artist + "::" + genre + "::" + releaseDate +
                "::" + availability();
    }

    /**
     * Getter method for this Album's title property.
     *
     * @return this Album's title property as a String.
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Getter method for this Album's artist name property.
     *
     * @return this Album's artist property as a String.
     */
    public String getArtist() {
        return this.artist;
    }

    /**
     * Getter method for this Album's availability property.
     *
     * @return this Album's boolean availability property.
     */
    public boolean isAvailable() {
        return this.isAvailable;
    }

    /**
     * Setter method for this Album's availability property.
     *
     * @param isAvailable the boolean that will set the isAvailable property
     *                    of this Album
     */
    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    /**
     * Getter method for this Album's release date.
     *
     * @return this Album's releaseDate property as a Date object.
     */
    public Date getReleaseDate() {
        return this.releaseDate;
    }

    /**
     * Getter method for this Album's genre.
     *
     * @return the genre property of this Album.
     */
    public Genre getGenre() {
        return this.genre;
    }
}