package albums;

public class Collection {
    private Album[] albums;
    private int numAlbums; //number of albums currently in the collection

    private String printLendingOut(Album album) {
        String availability = album.isAvailable() ? "lending out and set to not available" : "is not available";
        return album.getTitle() + "::" + album.getArtist() + " >> " + availability;
    }

    private String printReturning(Album album) {
        String availability = album.isAvailable() ? "return cannot be completed" : "returning and set to available";
        return album.getTitle() + "::" + album.getArtist() + " >> " + availability;
    }

    private int find(Album album) {
        for (int i = 0; i < numAlbums; i++) {
            if (albums[i].equals(album)) {
                return i;
            }
        }
        return -1;
    } //find the album index, or return NOT_FOUND

    private void grow() {
        Album[] newArray = new Album[numAlbums + 4];
        for (int i = 0; i < numAlbums; i++) {
            newArray[i] = albums[i];
        }
        albums = newArray;
    } //increase the capacity of the array list by 4

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

    public boolean remove(Album album) {
        int index = find(album);
        if (index == -1) {
            return false;
        }
        albums[index] = null;
        return true;
    }

    public boolean lendingOut(Album album) {
        album.setAvailable(false);
        return true;
    } //set to not available

    public boolean returnAlbum(Album album) {
        album.setAvailable(true);
        return true;
    } //set to available

    public void print() {
        System.out.println("*List of albums in the collection.");
        for (int i = 0; i < numAlbums; i++) {
            System.out.println(albums[i].toString());
        }
         System.out.println("*End of List");
    } //display the list without specifying the order

    public void printByReleaseDate() {
        Album[] dateSortedAlbums = sortByReleaseDate();
        int collectionSize = albums.length;
        System.out.println("*Album collection by the release dates.");
        for(int i = 0; i<collectionSize; i++) {
            System.out.println(dateSortedAlbums[i].toString());
        }
        System.out.println("*End of List");
    }

    public void printByGenre() {
        Album[] genreSortedAlbums = sortByGenre();
        int collectionSize = albums.length;
        System.out.println("*Album collection by genre.");
        for(int i = 0; i<collectionSize; i++) {
            System.out.println(genreSortedAlbums[i].toString());
        }
        System.out.println("*End of List");
    }

    private Album[] sortByReleaseDate() {
        int collectionSize = albums.length;
        Album[] dateSortedAlbums = new Album[collectionSize];
        for(int i = 0; i<collectionSize; i++) {
            dateSortedAlbums[i] = albums[i];
        }
        for(int i = 0; i < collectionSize - 1; i++) {
            for(int j = 0; j < collectionSize - i - 1; j++) {
                if(dateSortedAlbums[j].getReleaseDate().compareTo(dateSortedAlbums[j+1].getReleaseDate()) == -1) {
                    Album tempAlbum = dateSortedAlbums[j];
                    dateSortedAlbums[i] = dateSortedAlbums[j];
                    dateSortedAlbums[j] = tempAlbum;
                }
            }
        }
        return dateSortedAlbums;
    }

    private Album[] sortByGenre() {
        int collectionSize = albums.length;
        Album[] genreSortedAlbums = new Album[collectionSize];
        for(int i = 0; i<collectionSize; i++) {
            genreSortedAlbums[i] = albums[i];
        }
        //TODO: Finish Sorting by Genre
        for(int i = 0; i < collectionSize - 1; i++) {
            for(int j = 0; j < collectionSize - i - 1; j++) {
                Genre genre1 = genreSortedAlbums[i].getGenre();
                Genre genre2 = genreSortedAlbums[j].getGenre();

                if(genre1.toString().compareTo(genre2.toString()) == 1) {
                    Album tempAlbum = genreSortedAlbums[i];
                    genreSortedAlbums[i] = genreSortedAlbums[j];
                    genreSortedAlbums[j] = tempAlbum;
                }
            }
        }
        return genreSortedAlbums;
    }
}