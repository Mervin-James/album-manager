package albums;

public class Album {
    private String title;
    private String artist;
    private Genre genre; //enum class; Classical, Country, Jazz, Pop, Unknown
    private Date releaseDate;
    private boolean isAvailable;

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Album) {
            Album album = (Album) obj;
            return (album.title.equals(this.title) || album.artist.equals(this.artist));
        }
        return false;
    }

    @Override
    public String toString() {
        return title + "::" + artist + "::" + genre + "::" + releaseDate + "::" + isAvailable;
    }
}
