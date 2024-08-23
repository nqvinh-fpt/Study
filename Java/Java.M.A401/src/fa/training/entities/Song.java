package fa.training.entities;

import fa.training.utils.Validator;

public class Song extends Multimedia{

    private String singer;

    public Song() {
        super();
        this.singer = "";
    }
    public Song(String name, double duration, String singer) {
        super(name, duration);
        this.singer = singer;
    }
    @Override
    public void createMultimedia() {
        setName(Validator.inputString("Enter name: "));
        setDuration(Validator.inputDouble("Enter duration: ",0));
        this.singer = Validator.inputString("Enter singer: ");
    }

    @Override
    public String toString() {
                return String.format(" %-10s  %-20s  %-10.1f  %-10s","Song:", getName(), getDuration(), singer);
    }


}
