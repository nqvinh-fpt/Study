package fa.training.main;

import fa.training.entities.Song;
import fa.training.entities.Video;
import fa.training.management.MultimediaManagement;
import fa.training.utils.Validator;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        MultimediaManagement manager = new MultimediaManagement();
        while (true) {
            System.out.println("---------Java.M.A401------");
            System.out.println("1. Add a new Video");
            System.out.println("2. Add a new Song");
            System.out.println("3. Show all multimedia ");
            System.out.println("4. Exit");
            int choice = Validator.inputNumber("Your choice: ");

            switch (choice) {
                case 1:
                    Video video = new Video();
                    video.createMultimedia();
                    manager.addMultimedia(video);
                    break;
                case 2:
                    Song song = new Song();
                    song.createMultimedia();
                    manager.addMultimedia(song);
                    break;
                case 3:
                    manager.displayMultimedia();
                    break;
                case 4:
                    System.out.println("Exiting......");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
