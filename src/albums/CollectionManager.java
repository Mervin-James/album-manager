package albums;

import java.util.Scanner;

public class CollectionManager {
    public void run() {
        System.out.println("Collection Manager starts running.");
        Album[] albums = new Album[4];
        Collection collection = new Collection(albums, 0);
        Scanner sc = new Scanner(System.in);
        String command = "";
        while (!command.equals("Q")) {
            String input = sc.nextLine();
            String[] splitInput = input.split(",");
            command = splitInput[0];
            if (command.equals("A") && splitInput.length == 5) {
                addAlbum(collection, splitInput);
            }
            else if (command.equals("D") && splitInput.length == 3) {
                removeAlbum(collection, splitInput);
            }
            else if (command.equals("L") && splitInput.length == 3) {
                lendOutAlbum(collection, splitInput);
            }
            else if (command.equals("R") && splitInput.length == 3) {
                returnAlbum(collection, splitInput);
            }
            else if (command.equals("P") && splitInput.length == 1) {
                collection.print();
            }
            else if (command.equals("PD") && splitInput.length == 1) {
                collection.printByReleaseDate();
            }
            else if (command.equals("PG") && splitInput.length == 1) {
                collection.printByGenre();
            }
            else {
                System.out.println("Invalid command!");
            }

//            System.out.println("numAlbums: " + collection.numAlbums);
//            System.out.println("albums.length: " + collection.albums.length);
        }
        sc.close();
        System.out.println("Collection Manager terminated.");
    }

    private void addAlbum(Collection collection, String[] splitInput) {
        String title = splitInput[1];
        String artist = splitInput[2];
        Genre genre = checkGenre(splitInput[3]);
        Date releaseDate = new Date(splitInput[4]);
        if (!releaseDate.isValid()) {
            System.out.println("Invalid Date!");
            return;
        }
        Album album = new Album(title, artist, genre, releaseDate, true);
        System.out.println(collection.albumAddedMessage(album, collection.add(album)));
    }

    private void removeAlbum(Collection collection, String[] splitInput) {
        String title = splitInput[1];
        String artist = splitInput[2];
        Album album = new Album(title, artist);
        System.out.println(collection.albumRemovedMessage(album, collection.remove(album)));
    }

    private void lendOutAlbum(Collection collection, String[] splitInput) {
        String title = splitInput[1];
        String artist = splitInput[2];
        Album album = new Album(title, artist);
        System.out.println(collection.lendingOutOutput(album, collection.lendingOut(album)));
    }

    private void returnAlbum(Collection collection, String[] splitInput) {
        String title = splitInput[1];
        String artist = splitInput[2];
        Album album = new Album(title, artist);
        System.out.println(collection.returningOutput(album, collection.returnAlbum(album)));
    }

    private Genre checkGenre(String stringGenre) {
        if (stringGenre.equals("Classical") || stringGenre.equals("classical")) {
            return Genre.Classical;
        }
        else if (stringGenre.equals("Country") || stringGenre.equals("country")) {
            return Genre.Country;
        }
        else if (stringGenre.equals("Jazz") || stringGenre.equals("jazz")) {
            return Genre.Jazz;
        }
        else if (stringGenre.equals("Pop") || stringGenre.equals("pop")) {
            return Genre.Pop;
        }
        else {
            return Genre.Unknown;
        }
    }
}
