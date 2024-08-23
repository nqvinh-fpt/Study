package fa.training.main;

import fa.training.entities.Multimedia;
import fa.training.entities.Song;
import fa.training.entities.Video;
import fa.training.management.MultimediaManagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    static List<Multimedia> multimediaList = new ArrayList<>();
    static MultimediaManagement multimediaManagement = new MultimediaManagement(multimediaList);

        final static Scanner sc = new Scanner(System.in);

        public static void main(String[] args) {

            int choice;
            do {
                System.out.println("------------------------ MENU -------------------------");
                System.out.println("Choose function:");
                System.out.println("1. Add a new Video");
                System.out.println("2. Add a new Song");
                System.out.println("3. Show all multimedia");
                System.out.println("4. Exit");
                System.out.print("Your choice: ");
                choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("----------- Enter video information ------------");
                        Video video = new Video();
                        video.createVideo();
                        multimediaManagement.addMultimedia(video);
                        break;

                    case 2:
                        System.out.println("----------- Enter song information ------------");
                        Song song = new Song();
                        song.createSong();
                        multimediaManagement.addMultimedia(song);
                        break;
                    case 3:
                        System.out.println("----------- LIST OF MULTIMEDIA ------------");
                        multimediaManagement.displayMultimedia();
                        break;
                    case 4:
                        break;

                    default:
                        System.out.println("Invalid choice. Please choose a valid option.");
                }
            } while (choice != 4);
            sc.close();
    }
}
