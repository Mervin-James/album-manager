package albums;

/**
 * A class that stores Albums and can add, remove, lend, and return albums.
 * The Collection class also has methods to print albums in the sequence they
 * are added, by date, and by genre. The private helper methods
 * compartmentalize functionality for the print methods, for finding albums in
 * the collection, for and growing the collection array.
 *
 * @author Akshar Patel, Mervin James
 */
public class Collection {
    private Album[] albums;
    private int numAlbums; //number of albums currently in the collection

    /**
     * Constructor which generates a collection from an array of albums.
     * This constructor takes in an array of albums and the number of
     * albums in the array as arguments.
     *
     * @param albums    the array of albums that comprises the collection.
     * @param numAlbums the number of albums in the array of albums.
     */
    public Collection(Album[] albums, int numAlbums) {
        this.albums = albums;
        this.numAlbums = numAlbums;
    }

    /**
     * Generates an output message after attempting to remove an album.
     *
     * @param album   the album attempting to being removed.
     * @param removed the status of the album's removal.
     * @return the output message of the status of the operation to remove
     * the album.
     */
    public String albumRemovedMessage(Album album, boolean removed) {
        if (removed) {
            return album.getTitle() + "::" + album.getArtist() +
                    " >> deleted.";
        }
        return album.getTitle() + "::" + album.getArtist() +
                " >> is not in the collection.";
    }

    /**
     * Generates an output message after attempting to add an album.
     *
     * @param album the album attempting to being included.
     * @param added the status of the album's inclusion.
     * @return the output message of the status of the operation to add
     * the album.
     */
    public String albumAddedMessage(Album album, boolean added) {
        if (added) {
            return album.toString() + " >> added.";
        }
        return album.toString() + " >> is already in the collection.";
    }

    /**
     * Helper method that generates a message once an album is lent out.
     *
     * @param album   the album being lent out.
     * @param lentOut the availability status of the album being lent out.
     * @return the output String which will be displayed to the user.
     */
    public String lendingOutOutput(Album album, boolean lentOut) {
        if (lentOut) {
            return album.getTitle() + "::" + album.getArtist() +
                    " >> lending out and set to not available.";
        }
        return album.getTitle() + "::" + album.getArtist() +
                " >> is not available.";
    }

    /**
     * Helper method that generates a message once an album is returned.
     *
     * @param album    the album being returned.
     * @param returned the availability status of the album being returned.
     * @return the output String which will be displayed to the user.
     */
    public String returningOutput(Album album, boolean returned) {
        if (returned) {
            return album.getTitle() + "::" + album.getArtist() +
                    " >> returning and set to available.";
        }
        return album.getTitle() + "::" + album.getArtist() +
                " >> return cannot be completed.";
    }

    /**
     * Helper method that finds an album in the collection, if it exists.
     *
     * @param album the album attempted to being found.
     * @return the index of the album inside the collection array, otherwise
     * returns -1 if not found.
     */
    private int find(Album album) {
        for (int i = 0; i < numAlbums; i++) {
            if (albums[i].equals(album)) {
                return i;
            }
        }
        return -1;
    } //find the album index, or return NOT_FOUND

    /**
     * Helper method that increases the capacity of the collection array.
     * This method is called when there are no more empty spaces for albums
     * inside the collection, and increases the collection array's capacity
     * by 4.
     */
    private void grow() {
        Album[] newArray = new Album[numAlbums + 4];
        for (int i = 0; i < numAlbums; i++) {
            newArray[i] = albums[i];
        }
        albums = newArray;
    } //increase the capacity of the array list by 4

    /**
     * Adds an album to the collection, if it isn't already included.
     *
     * @param album the album being added to the collection.
     * @return true if the album is added to the collection,
     * otherwise false if the album is already in the collection to begin
     * with.
     */
    public boolean add(Album album) {
        if (find(album) != -1) { //if the album is in the collection
            return false;
        }
        albums[numAlbums++] = album;
        if (numAlbums == albums.length) {
            grow();
        }
        return true;
    }

    /**
     * Removes an album from the collection, if it exists inside.
     *
     * @param album the album to be removed.
     * @return true if the album is removed, otherwise false if the
     * album does not exist in the collection to begin with.
     */
    public boolean remove(Album album) {
        int albumIndex = find(album);
        if (albumIndex == -1) {
            return false;
        }
        Album[] newArray = new Album[albums.length];
        boolean isSkipped = false;  // marks when the deleted album has been
        // skipped
        for (int i = 0; i < numAlbums; i++) {
            if (i == albumIndex) {
                isSkipped = true;
            }
            if (isSkipped) {
                newArray[i] = albums[i + 1];
                continue;
            }
            newArray[i] = albums[i];
        }
        numAlbums--;
        albums = newArray;
        return true;
    }

    /**
     * Sets the status of an album being lent out to unavailable, if found.
     *
     * @param album the album being lent out.
     * @return true if the album's status has been set to
     * unavailable, otherwise false if the album is not found in the
     * collection to begin with.jsdf
     */
    public boolean lendingOut(Album album) {
        int albumIndex = find(album);
        if (albumIndex == -1 || !albums[albumIndex].isAvailable()) {
            return false;
        }
        albums[albumIndex].setAvailable(false);
        return true;
    } //set to not available

    /**
     * Sets the status of an album being returned to available, if found.
     *
     * @param album the album being returned.
     * @return true if the album's status has been set to available,
     * otherwise false if the album is not found in the collection to begin
     * with.
     */
    public boolean returnAlbum(Album album) {
        int albumIndex = find(album);
        if (albumIndex == -1 || albums[albumIndex].isAvailable()) {
            return false;
        }
        albums[albumIndex].setAvailable(true);
        return true;
    } //set to available

    /**
     * Prints all the albums in the collection.
     */
    public void print() {
        if (numAlbums == 0) {
            System.out.println("The collection is empty!");
            return;
        }
        System.out.println("*List of albums in the collection.");
        for (int i = 0; i < numAlbums; i++) {
            System.out.println(albums[i].toString());
        }
        System.out.println("*End of list");
    } //display the list without specifying the order

    /**
     * Prints all the albums in the collection by ascending release date.
     */
    public void printByReleaseDate() {
        if (numAlbums == 0) {
            System.out.println("The collection is empty!");
            return;
        }
        albums = sortByReleaseDate();
        System.out.println("*Album collection by the release dates.");
        for (int i = 0; i < numAlbums; i++) {
            System.out.println(albums[i].toString());
        }
        System.out.println("*End of list");
    }

    /**
     * Prints all the albums in the collection in alphabetical genre order.
     */
    public void printByGenre() {
        if (numAlbums == 0) {
            System.out.println("The collection is empty!");
            return;
        }
        albums = sortByGenre();
        System.out.println("*Album collection by genre.");
        for (int i = 0; i < numAlbums; i++) {
            System.out.println(albums[i].toString());
        }
        System.out.println("*End of list");
    }

    /**
     * Helper method that sorts the albums by ascending release date.
     *
     * @return the sorted list of albums in the collection by ascending
     * release date.
     */
    private Album[] sortByReleaseDate() {
        for (int i = 0; i < numAlbums - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < numAlbums; j++) {
                if (albums[j].getReleaseDate()
                        .compareTo(albums[minIndex].getReleaseDate()) ==
                        -1) {
                    minIndex = j;
                }
            }
            Album tempAlbum = albums[minIndex];
            albums[minIndex] = albums[i];
            albums[i] = tempAlbum;
        }
        return albums;
    }

    /**
     * Helper method that sorts the albums in alphabetical genre order.
     *
     * @return the sorted list of albums in the collection in alphabetical
     * genre order.
     */
    private Album[] sortByGenre() {
        for (int i = 0; i < numAlbums - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < numAlbums; j++) {
                if (albums[j].getGenre()
                        .compareTo(albums[minIndex].getGenre()) <
                        0) {
                    minIndex = j;
                }
            }
            Album tempAlbum = albums[minIndex];
            albums[minIndex] = albums[i];
            albums[i] = tempAlbum;
        }
        return albums;
    }
}