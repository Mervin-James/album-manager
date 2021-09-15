package albums;

public class Collection {
    private Album[] albums;
    private int numAlbums; //number of albums currently in the collection

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

    } //set to not available

    public boolean returnAlbum(Album album) {

    } //set to available

    public void print() {
        for (int i = 0; i < numAlbums; i++) {
            System.out.println(albums[i].toString());
        }
    } //display the list without specifying the order

    public void printByReleaseDate() {

    }

    public void printByGenre() {

    }
}