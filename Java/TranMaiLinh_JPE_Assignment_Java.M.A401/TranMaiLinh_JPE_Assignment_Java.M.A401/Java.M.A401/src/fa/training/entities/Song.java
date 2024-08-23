package fa.training.entities;

import java.util.Scanner;

public class Song extends Multimedia{
    private String singer;

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public Song() {
    }

    public Song(String singer) {
        this.singer = singer;
    }

    public Song(String name, double duration, String singer) {
        super(name, duration);
        this.singer = singer;
    }

    public void createSong() {
        super.createMultimedia();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the singer: ");
        singer = sc.nextLine();
    }

    @Override
    public String toString() {
        return "Song:       " + getName() +"     " +  getDuration() +" minutes    " +  singer ;
    }
}
