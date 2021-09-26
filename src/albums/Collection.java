package albums;

/**
 * A class that stores Albums and provides methods to add, remove, lend out,
 * and return albums.
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

    public Collection(Album[] albums, int numAlbums) {
        this.albums = albums;
        this.numAlbums = numAlbums;
    }

    public String albumRemovedMessage(Album album) {
        return album.getTitle() + "::" + album.getArtist() + " >> deleted.";
    }

    public String albumAddedMessage(Album album, boolean added) {
        if (added) {
            return album.toString() + " >> added.";
        }
        return album.toString() + " >> is already in the collection.";
    }

    /**
     * Helper method that generates an output String once an album is lent out.
     *
     * @param album the album being lent out.
     * @return the output String which will be displayed to the user.
     */
    public String lendingOutOutput(Album album) {
        String availability = album.isAvailable() ? "lending out and set to " +
                "not available" : "is not available";
        return album.getTitle() + "::" + album.getArtist() + " >> " +
                availability;
    }

    /**
     * Helper method that generates an output String once an album is returned.
     *
     * @param album the album being returned.
     * @return the output String which will be displayed to the user.
     */
    public String returningOutput(Album album) {
        String availability = album.isAvailable() ? "return cannot be " +
                "completed" : "returning and set to available";
        return album.getTitle() + "::" + album.getArtist() + " >> " +
                availability;
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
     * otherwise false if the album is already in the collection to begin with.
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
     * Removes an album from the collection, if it exists inside the collection.
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
        if (albumIndex == -1) {
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
        if (albumIndex == -1) {
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
        System.out.println("*End of List");
    } //display the list without specifying the order

    /**
     * Prints all the albums in the collection by ascending release date.
     */
    public void printByReleaseDate() {
        if (numAlbums == 0) {
            System.out.println("The collection is empty!");
            return;
        }
        Album[] dateSortedAlbums = sortByReleaseDate();
        System.out.println("*Album collection by the release dates.");
        for (int i = 0; i < numAlbums; i++) {
            System.out.println(dateSortedAlbums[i].toString());
        }
        System.out.println("*End of List");
    }

    /**
     * Prints all the albums in the collection in alphabetical genre order.
     */
    public void printByGenre() {
        if (numAlbums == 0) {
            System.out.println("The collection is empty!");
            return;
        }
        Album[] genreSortedAlbums = sortByGenre();
        System.out.println("*Album collection by genre.");
        for (int i = 0; i < numAlbums; i++) {
            System.out.println(genreSortedAlbums[i].toString());
        }
        System.out.println("*End of List");
    }

    /**
     * Helper method that sorts the albums by ascending release date.
     *
     * @return the sorted list of albums in the collection by ascending
     * release date.
     */
    private Album[] sortByReleaseDate() {
        Album[] dateSortedAlbums = new Album[numAlbums];
        for (int i = 0; i < numAlbums; i++) {
            dateSortedAlbums[i] = albums[i];
        }
        for (int i = 0; i < numAlbums - 1; i++) {
            for (int j = 0; j < numAlbums - i - 1; j++) {
                if (dateSortedAlbums[j].getReleaseDate()
                        .compareTo(dateSortedAlbums[j + 1].getReleaseDate()) ==
                        -1) {
                    Album tempAlbum = dateSortedAlbums[j];
                    dateSortedAlbums[i] = dateSortedAlbums[j];
                    dateSortedAlbums[j] = tempAlbum;
                }
            }
        }
        return dateSortedAlbums;
    }

    /**
     * Helper method that sorts the albums in alphabetical genre order.
     *
     * @return the sorted list of albums in the collection in alphabetical
     * genre order.
     */
    private Album[] sortByGenre() {
        Album[] genreSortedAlbums = new Album[numAlbums];
        for (int i = 0; i < numAlbums; i++) {
            genreSortedAlbums[i] = albums[i];
        }
        for (int i = 0; i < numAlbums - 1; i++) {
            for (int j = 0; j < numAlbums - i - 1; j++) {
                Genre genre1 = genreSortedAlbums[i].getGenre();
                Genre genre2 = genreSortedAlbums[j].getGenre();

                if (genre1.toString().compareTo(genre2.toString()) == 1) {
                    Album tempAlbum = genreSortedAlbums[i];
                    genreSortedAlbums[i] = genreSortedAlbums[j];
                    genreSortedAlbums[j] = tempAlbum;
                }
            }
        }
        return genreSortedAlbums;
    }
}