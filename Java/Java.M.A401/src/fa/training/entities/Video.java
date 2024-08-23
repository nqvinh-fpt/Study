package fa.training.entities;

import fa.training.utils.Validator;

public class Video extends Multimedia{

    public Video() {
        super();
    }

    public Video(String name, double duration) {
        super(name, duration);
    }

    @Override
    public void createMultimedia() {
        setName(Validator.inputString("Enter name: "));
        setDuration(Validator.inputDouble("Enter duration : ",0));
    }

    @Override
    public String toString() {
        return String.format(" %-10s  %-20s  %-10.1f","Video:", getName(), getDuration());
    }
}
