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

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public Date getReleaseDate() {
//        TODO: See if this is redundant
        Date dateCopy = new Date(this.releaseDate);
        return dateCopy;
    }

    public Genre getGenre() {
        //TODO: See if passing this reference is OK
        return this.genre;
    }
}
